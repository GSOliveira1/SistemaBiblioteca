package visao;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import modelo.Livro;
import persistencia.BancoDeDados;
import persistencia.IDInvalido;

public class LivroGUI extends JPanel {

    private final BancoDeDados bd;
    private final Runnable onVoltar;

    private final DefaultTableModel tableModel;
    private final JTable tabela;

    private final JButton btnAlterar;
    private final JButton btnRemover;

    public LivroGUI(BancoDeDados bd, Runnable onVoltar) {
        this.bd = bd;
        this.onVoltar = onVoltar;

        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Gerenciar Livros");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 18f));

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(e -> this.onVoltar.run());

        JPanel topo = new JPanel(new BorderLayout());
        topo.add(titulo, BorderLayout.WEST);
        topo.add(btnVoltar, BorderLayout.EAST);
        add(topo, BorderLayout.NORTH);

        // Tabela
        tableModel = new DefaultTableModel(new Object[] { "ID", "Nome", "Autor" }, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        tabela = new JTable(tableModel);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(new JScrollPane(tabela), BorderLayout.CENTER);

        // Botões de ações
        JPanel acoes = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton btnAdicionar = new JButton("Adicionar");
        JButton btnBuscar = new JButton("Buscar");
        btnAlterar = new JButton("Alterar");
        btnRemover = new JButton("Remover");

        btnAlterar.setEnabled(false);
        btnRemover.setEnabled(false);

        tabela.getSelectionModel().addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return;
            boolean selecionou = tabela.getSelectedRow() != -1;
            btnAlterar.setEnabled(selecionou);
            btnRemover.setEnabled(selecionou);
        });


        btnAdicionar.addActionListener(e -> adicionarLivro());
        btnBuscar.addActionListener(e -> buscarLivro());
        btnAlterar.addActionListener(e -> alterarLivroSelecionado());
        btnRemover.addActionListener(e -> removerLivroSelecionado());

        acoes.add(btnAdicionar);
        acoes.add(btnRemover);
        acoes.add(btnBuscar);
        acoes.add(btnAlterar);

        add(acoes, BorderLayout.SOUTH);

        atualizarTabela();
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        ArrayList<Livro> livros = bd.getLivros().listar();
        for (Livro l : livros) {
            tableModel.addRow(new Object[] { l.getId(), l.getNome(), l.getAutor() });
        }

        tabela.clearSelection();
        btnAlterar.setEnabled(false);
        btnRemover.setEnabled(false);
    }

    private void adicionarLivro() {
        JTextField tfNome = new JTextField(20);
        JTextField tfAutor = new JTextField(20);
        JTextField tfId = new JTextField(10);

        JPanel painel = new JPanel(new GridLayout(0, 1, 6, 6));
        painel.add(new JLabel("Nome:"));
        painel.add(tfNome);
        painel.add(new JLabel("Autor:"));
        painel.add(tfAutor);
        painel.add(new JLabel("ID:"));
        painel.add(tfId);

        int opt = JOptionPane.showConfirmDialog(this, painel, "Adicionar Livro",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opt != JOptionPane.OK_OPTION) return;

        String nome = tfNome.getText().trim();
        String autor = tfAutor.getText().trim();
        String idStr = tfId.getText().trim();

        if (nome.isEmpty() || autor.isEmpty() || idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha Nome, Autor e ID.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido (use um número inteiro).");
            return;
        }

        // Evitar IDs duplicados
        try {
            bd.getLivros().buscarPorID(id);
            JOptionPane.showMessageDialog(this, "Já existe um livro com esse ID.");
            return;
        } catch (IDInvalido ex) {
            // ok, não existe
        }

        bd.getLivros().adicionar(new Livro(nome, autor, id));
        atualizarTabela();
    }

    private void removerLivroSelecionado() {
        int row = tabela.getSelectedRow();
        if (row == -1) return;

        int id = (Integer) tableModel.getValueAt(row, 0);
        String nome = (String) tableModel.getValueAt(row, 1);

        int opt = JOptionPane.showConfirmDialog(this, "Remover o livro: " + nome + "(ID: )" +  id, "Confirmar remoção", JOptionPane.YES_NO_OPTION);

        if (opt != JOptionPane.YES_OPTION) return;

        try {
            bd.getLivros().remover(id);
            atualizarTabela();
        } catch (IDInvalido ex) {
            JOptionPane.showMessageDialog(this, "Erro: ID inválido.");
        }
    }

    private void buscarLivro() {
        String input = JOptionPane.showInputDialog(this, "Informe o ID do livro:");
        if (input == null) return;

        input = input.trim();
        if (input.isEmpty()) return;

        int id;
        try {
            id = Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID inválido (use um número inteiro).");
            return;
        }

        // tenta selecionar na tabela
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            int idLinha = (Integer) tableModel.getValueAt(i, 0);
            if (idLinha == id) {
                tabela.setRowSelectionInterval(i, i);
                tabela.scrollRectToVisible(new Rectangle(tabela.getCellRect(i, 0, true)));
                return;
            }
        }

        // se não encontrou na tabela, tenta buscar no bd e informar
        try {
            Livro l = (Livro) bd.getLivros().buscarPorID(id);
            JOptionPane.showMessageDialog(this, "Encontrado:" + "Nome: " + l.getNome() + "Autor: " + l.getAutor() + "ID: " + l.getId());
            atualizarTabela();
        } catch (IDInvalido ex) {
            JOptionPane.showMessageDialog(this, "Livro não encontrado.");
        }
    }

    private void alterarLivroSelecionado() {
        int row = tabela.getSelectedRow();
        if (row == -1) return;

        int id = (Integer) tableModel.getValueAt(row, 0);

        Livro livro;
        try {
            livro = (Livro) bd.getLivros().buscarPorID(id);
        } catch (IDInvalido ex) {
            JOptionPane.showMessageDialog(this, "Erro: ID inválido.");
            return;
        }

        JTextField tfNome = new JTextField(livro.getNome(), 20);
        JTextField tfAutor = new JTextField(livro.getAutor(), 20);

        JLabel lbId = new JLabel(String.valueOf(livro.getId()));

        JPanel painel = new JPanel(new GridLayout(0, 1, 6, 6));
        painel.add(new JLabel("ID (não altera):"));
        painel.add(lbId);
        painel.add(new JLabel("Nome:"));
        painel.add(tfNome);
        painel.add(new JLabel("Autor:"));
        painel.add(tfAutor);

        int opt = JOptionPane.showConfirmDialog(this, painel, "Alterar Livro",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (opt != JOptionPane.OK_OPTION) return;

        String novoNome = tfNome.getText().trim();
        String novoAutor = tfAutor.getText().trim();

        if (!novoNome.isEmpty()) livro.setNome(novoNome);
        if (!novoAutor.isEmpty()) livro.setAutor(novoAutor);

        atualizarTabela();
    }
}

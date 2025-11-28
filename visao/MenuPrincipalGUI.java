package visao;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.CardLayout;

import persistencia.BancoDeDados;

public class MenuPrincipalGUI {

    private final BancoDeDados bd;

    private final JFrame frame;
    private final CardLayout cardLayout;
    private final JPanel cards;

    public MenuPrincipalGUI(BancoDeDados bd) {
        this.bd = bd;

        this.frame = new JFrame("Biblioteca");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.cardLayout = new CardLayout();
        this.cards = new JPanel(cardLayout);

        JPanel telaInicial = criarTelaInicial();
        LivroGUI telaLivros = new LivroGUI(bd, () -> cardLayout.show(cards, "MENU"));

        cards.add(telaInicial, "MENU");
        cards.add(telaLivros, "LIVROS");

        frame.setContentPane(cards);
        frame.setSize(800, 500);
        frame.setLocationRelativeTo(null);
    }

    private JPanel criarTelaInicial() {
        JPanel painel = new JPanel(new BorderLayout(10, 10));
        painel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titulo = new JLabel("Menu Principal");
        titulo.setFont(titulo.getFont().deriveFont(Font.BOLD, 20f));
        painel.add(titulo, BorderLayout.NORTH);

        JPanel botoes = new JPanel(new GridLayout(0, 1, 10, 10));

        JButton btnEstudantes = new JButton("Gerenciar Estudantes");
        JButton btnLivros = new JButton("Gerenciar Livros");
        JButton btnAlugueis = new JButton("Gerenciar Aluguéis");
        JButton btnSair = new JButton("Sair");

        btnLivros.addActionListener(e -> cardLayout.show(cards, "LIVROS"));

        btnEstudantes.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Tela de Estudantes ainda não implementada."));
        btnAlugueis.addActionListener(e -> JOptionPane.showMessageDialog(frame,
                "Tela de Aluguéis ainda não implementada."));

        btnSair.addActionListener(e -> frame.dispose());

        botoes.add(btnEstudantes);
        botoes.add(btnLivros);
        botoes.add(btnAlugueis);
        botoes.add(btnSair);

        painel.add(botoes, BorderLayout.CENTER);

        return painel;
    }

    public void mostrar() {
        frame.setVisible(true);
    }
}

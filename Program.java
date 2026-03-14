import javax.swing.SwingUtilities;

import persistencia.BancoDeDados;
import visao.MenuPrincipalGUI;

public class Program {

    public static void main(String[] args) {
        BancoDeDados bd = new BancoDeDados();

        SwingUtilities.invokeLater(() -> {
            new MenuPrincipalGUI(bd).mostrar();
        });
    }
}

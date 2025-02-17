import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Ventana v = new Ventana();
        v.setTitle("Configuración de Izaje");
        v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        v.setSize(600, 500);
        v.setResizable(false);
        v.setVisible(true);
    }
}

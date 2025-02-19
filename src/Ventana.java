import java.awt.*;
import javax.swing.*;

public class Ventana extends JFrame {
    private JPanel panelPrincipal;
    private Panel1 panel1;
    private Panel2 panel2;
    private Panel3 panel3;
    private Percha pi1;
    private JButton siguiente;
    private JButton anterior;
    private JButton verificar;

    public Ventana(){
        
        // Crear el contenedor principal con CardLayout
        panelPrincipal = new JPanel(new CardLayout());

        // Se define un objeto aleatorio para el ejemplo
        pi1 = new Percha("PI1", 10f, 1.2f, 2.5f, 16, 15f, 22, 10f, 1f, 1f);
        pi1.getCancamosSup()[4].setNombre("HS1");
        pi1.getCancamosSup()[5].setNombre("IS1");
        pi1.getCancamosSup()[6].setNombre("JS1");
        pi1.getCancamosSup()[7].setNombre("KS1");
        pi1.getCancamosSup()[12].setNombre("HS2");
        pi1.getCancamosSup()[13].setNombre("IS2");
        pi1.getCancamosSup()[14].setNombre("JS2");
        pi1.getCancamosSup()[15].setNombre("KS2");

        // Agregar las tarjetas al contenedor
        panel1 = new Panel1();
        panel2 = new Panel2(pi1);
        panel3 = new Panel3(pi1);
        panelPrincipal.add(panel1);
        panelPrincipal.add(panel2);
        panelPrincipal.add(panel3);

        // Crear botones para navegar
        JPanel panelBotones = new JPanel();
        siguiente = new JButton("Siguiente");
        anterior = new JButton("Anterior");
        verificar = new JButton ("Verificar");
        panelBotones.add(anterior);
        panelBotones.add(siguiente);
        panelBotones.add(verificar);
        anterior.setEnabled(false);
        verificar.setEnabled(false);

        

        // Agregar acciones a los botones
        CardLayout cl = (CardLayout) panelPrincipal.getLayout();
        siguiente.addActionListener(e -> {
            cl.next(panelPrincipal);
            actualizarEstadoBotones();
        });

        anterior.addActionListener(e -> {
            cl.previous(panelPrincipal);
            actualizarEstadoBotones();
        });

        verificar.addActionListener(e -> {
            Verificacion verif = new Verificacion(panel1, panel2, panel3, pi1);
            if(verif.getBandera()){
                VentanaVerificacion frame2 = new VentanaVerificacion(verif, panel1, panel2, panel3, pi1);
                frame2.setVisible(true);    
            }
        });

        // Agregar los paneles al marco
        Container ct = getContentPane();
        ct.setLayout(new BorderLayout());
        ct.add(panelPrincipal, BorderLayout.CENTER);
        ct.add(panelBotones, BorderLayout.SOUTH);
    }

    private void actualizarEstadoBotones() {
        Component[] cards = panelPrincipal.getComponents();
        for (int i = 0; i < cards.length; i++) {
            if (cards[i].isVisible()) {
                // Habilitar/Deshabilitar botones según la tarjeta visible
                anterior.setEnabled(i > 0);
                siguiente.setEnabled(i < cards.length - 1);
                break;
            }
            if(cards[(cards.length - 1)].isVisible())
                verificar.setEnabled(true);
            else
                verificar.setEnabled(false);
        }
    }

}

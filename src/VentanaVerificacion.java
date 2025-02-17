import java.awt.*;
import javax.swing.*;


public class VentanaVerificacion extends JFrame{
    private final JLabel titulo;
    private final JLabel angulo;
    private final JLabel marca1;
    private final JLabel marca2;
    private final JLabel marca3;
    private final JLabel marca4;
    private final JLabel marca5;
    private final JLabel eslingaSup;
    private final JLabel eslingaInf;
    private final JLabel cancamoSup;
    private final JLabel cancamoInf;
    private final JButton b_exportar;
    @SuppressWarnings("unused")
    private Exportar export;

    public VentanaVerificacion(Verificacion verif, Panel1 panel1, Panel2 panel2, Panel3 panel3, Percha pi1){
        setTitle("Verificación");
        setSize(300, 320);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Cerrar solo esta ventana al cerrar
        setLocationRelativeTo(null);
        
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        titulo = new JLabel ("<html><u>RESULTADOS</u></html>");
        angulo = new JLabel("Angulo eslinga superior ->");
        eslingaSup = new JLabel("Resistencia esliga superior ->");
        eslingaInf = new JLabel("Resistencia esliga inferior ->");
        cancamoSup = new JLabel("Resistencia cancamo superior ->");
        cancamoInf = new JLabel("Resistencia cancamo inferior ->");
        marca1 = new JLabel ("");
        marca2 = new JLabel ("");
        marca3 = new JLabel ("");
        marca4 = new JLabel ("");
        marca5 = new JLabel ("");
        b_exportar = new JButton("Exportar");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titulo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10);
        add(angulo, gbc);

        if(verif.verif_angulo()){
            marca1.setText("OK");
            marca1.setForeground(Color.GREEN);
        }   
        else{
            marca1.setText("MAL");
            marca1.setForeground(Color.RED);
        }
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(marca1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(eslingaSup, gbc);

        if(verif.verif_eslingaSup()){
            marca2.setText("OK");
            marca2.setForeground(Color.GREEN);
        }   
        else{
            marca2.setText("MAL");
            marca2.setForeground(Color.RED);
        }
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(marca2, gbc);

        //-----
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(eslingaInf, gbc);

        if(verif.verif_eslingaInf()){
            marca3.setText("OK");
            marca3.setForeground(Color.GREEN);
        }   
        else{
            marca3.setText("MAL");
            marca3.setForeground(Color.RED);
        }
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(marca3, gbc);

        //---------------
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(cancamoSup, gbc);

        if(verif.verif_cancamoSup()){
            marca4.setText("OK");
            marca4.setForeground(Color.GREEN);
        }   
        else{
            marca4.setText("MAL");
            marca4.setForeground(Color.RED);
        }
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(marca4, gbc);

        //------------
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        add(cancamoInf, gbc);

        if(verif.verif_cancamoInf()){
            marca5.setText("OK");
            marca5.setForeground(Color.GREEN);
        }   
        else{
            marca5.setText("MAL");
            marca5.setForeground(Color.RED);
        }
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        add(marca5, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(b_exportar, gbc);

        b_exportar.setEnabled(false);

        if(verif.verif_angulo() && verif.verif_eslingaSup() && verif.verif_eslingaInf() && verif.verif_cancamoSup() && verif.verif_cancamoInf()){
            b_exportar.setEnabled(true);
        }        
    
        b_exportar.addActionListener(e -> {export = new Exportar (verif, panel1, panel2, panel3, pi1);});
    }
}

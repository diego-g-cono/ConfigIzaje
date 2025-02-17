import java.awt.*;
import javax.swing.*;

public class Panel3 extends JPanel{
    private final JLabel titulo;
    private final JLabel l_longEslinga;
    private final JTextField tf_longEslinga;
    private final JLabel l_capEslinga;
    private final JTextField tf_capEslinga;
    private final JLabel l_cancamos;
    private final JCheckBox[] cb_cancamos;

    public Panel3(Percha pi1){

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        //TITULO
        titulo = new JLabel("<html><u>TIROS INFERIORES</u></html>");
        //CAMPO LONGITUD ESLINGA
        l_longEslinga = new JLabel ("Longitud de la Eslinga: ");
        tf_longEslinga = new JTextField ();
        tf_longEslinga.setText("4");
        tf_longEslinga.setColumns(10);
        //CAMPO LONGITUD ESLINGA
        l_capEslinga = new JLabel ("Capacidad de la Eslinga: ");
        tf_capEslinga = new JTextField ();
        tf_capEslinga.setText("10");
        tf_capEslinga.setColumns(10);
        //CAMPO CANCAMOS
        l_cancamos = new JLabel ("Cancamos a utilizar: ");

        cb_cancamos = new JCheckBox[pi1.getCancamosInf().length];

        for (int i = 0; i < 16; i++) {
            cb_cancamos[i] = new JCheckBox(pi1.getCancamosInf()[i].getNombre());    
        }
        cb_cancamos[1].setSelected(true);
        cb_cancamos[5].setSelected(true);
        cb_cancamos[9].setSelected(true);

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
        add(l_longEslinga, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_longEslinga, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(l_capEslinga, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_capEslinga, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(l_cancamos, gbc);

        if((cb_cancamos.length/2) %2 == 0){
            for(int i = 0; i < cb_cancamos.length/4; i++){
                gbc.gridx = i+1;
                gbc.gridwidth = 1;
                gbc.gridy = 3;
                gbc.anchor = GridBagConstraints.CENTER;
                add(cb_cancamos[i], gbc);

                gbc.gridx = i+1;
                gbc.gridwidth = 1;
                gbc.gridy = 4;
                gbc.anchor = GridBagConstraints.CENTER;
                add(cb_cancamos[i+cb_cancamos.length/4], gbc);
            }
        }else{
            for(int i = 0; i < cb_cancamos.length/4; i++){
                gbc.gridx = i+1;
                gbc.gridwidth = 1;
                gbc.gridy = 3;
                gbc.anchor = GridBagConstraints.CENTER;
                add(cb_cancamos[i], gbc);

                gbc.gridx = i+1;
                gbc.gridwidth = 1;
                gbc.gridy = 4;
                gbc.anchor = GridBagConstraints.CENTER;
                add(cb_cancamos[i+cb_cancamos.length/4+1], gbc);
            }
            gbc.gridx = cb_cancamos.length+1;
            gbc.gridwidth = 1;
            gbc.gridy = 3;
            gbc.anchor = GridBagConstraints.CENTER;
            add(cb_cancamos[cb_cancamos.length/4], gbc);
        }

        setBackground(Color.GREEN);
    }
    
    public String getResistEslingInf(){
        return tf_capEslinga.getText();
    }

    public String getLongEslingaInf(){
        return tf_longEslinga.getText();
    }
    public JCheckBox[] getCheckBoxInf(){
        return cb_cancamos;
    }
}

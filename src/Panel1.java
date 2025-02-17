import java.awt.*;
import java.text.*;
import javax.swing.*;
import javax.swing.text.*;

public class Panel1 extends JPanel{
    private final JLabel l_fecha;
    private final JFormattedTextField tf_fecha;
    private final JLabel l_producto;
    private final JTextField tf_producto;
    private final JLabel l_cantMax;
    private final JTextField tf_cantMax;
    private final JLabel l_puntosIzaje;
    private final JTextField tf_puntosIzaje;
    private final JLabel l_pesoTotal;
    private final JTextField tf_pesoTotal;
    private final JLabel l_pesoUnitario;
    private final JTextField tf_pesoUnitario;
    private final JLabel l_numPercha;
    private final JTextField tf_numPercha;
    private final JLabel l_capMaxPercha;
    private final JTextField tf_capMaxPercha;
    private final JLabel l_operacion;
    private final JTextField tf_operacion;
    private final JLabel titulo1;

    public Panel1 (){
        setLayout(new GridBagLayout());
        //JPanel panel1 = new JPanel(new GridBagLayout());
        //CAMPO FECHA
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        DateFormatter dateFormatter = new DateFormatter(dateFormat);
        l_fecha = new JLabel("FECHA: ");
        tf_fecha = new JFormattedTextField(dateFormatter);
        tf_fecha.setColumns(10); // Ancho del campo de texto
        tf_fecha.setValue(new java.util.Date());
        
        //CAMPO PRODUCTO A MANIPULAR
        l_producto = new JLabel("PRODUCTO A MANIPULAR: ");
        tf_producto = new JTextField();
        tf_producto.setText("ADN");
        tf_producto.setColumns(10);

        //CAMPO CANTIDAD MAXIMA A IZAR
        l_cantMax = new JLabel("CANTIDAD MÁXIMA A IZAR: ");
        tf_cantMax = new JTextField();
        tf_cantMax.setText("5");
        tf_cantMax.setColumns(10);

        //CAMPO CANTIDAD DE PUNTOS DE IZAJE
        l_puntosIzaje = new JLabel("CANT. PUNTOS DE IZAJE DE LA CARGA: ");
        tf_puntosIzaje = new JTextField();
        tf_puntosIzaje.setText("3");
        tf_puntosIzaje.setColumns(10);

        //CAMPO PESO TOTAL CON CANTIDAD MAXIMA
        l_pesoTotal = new JLabel("PESO TOTAL CON CANT. MÁXIMA (Tn): ");
        tf_pesoTotal = new JTextField();
        tf_pesoTotal.setText("10.8");
        tf_pesoTotal.setColumns(10);

        //CAMPO PESO UNITARIO MAXIMO
        l_pesoUnitario = new JLabel("PESO UNITARIO MÁX. (Tn): ");
        tf_pesoUnitario = new JTextField();
        tf_pesoUnitario.setText("2.16");
        tf_pesoUnitario.setColumns(10);

        //CAMPO NUM PERCHA
        l_numPercha = new JLabel("Nº PERCHA: ");
        tf_numPercha = new JTextField();
        tf_numPercha.setText("Percha Integral - 01/02");
        tf_numPercha.setColumns(10);

        //CAMPO CAPACIDAD MAX PERCHA
        l_capMaxPercha = new JLabel("CAPACIDAD MÁXIMA PERCHA (Tn): ");
        tf_capMaxPercha = new JTextField();
        tf_capMaxPercha.setText("40 TN - 10 TN POR CANCAMO");
        tf_capMaxPercha.setColumns(10);

        //CAMPO OPERACION
        l_operacion = new JLabel("OPERACIÓN: ");
        tf_operacion = new JTextField();
        tf_operacion.setText("SIDERURGICO");
        tf_operacion.setColumns(10);

        //CAMPO TITULO1
        titulo1 = new JLabel("<html><u>DATOS GENERALES</u></html>");

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titulo1, gbc);

        gbc.gridx = 0; // Columna
        gbc.gridy = 1; // Fila
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST;
        gbc.insets = new Insets(10, 10, 10, 10); // Margen alrededor del componente
        add(l_fecha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_fecha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(l_producto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_producto, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.EAST;
        add(l_cantMax, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_cantMax, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.EAST;
        add(l_puntosIzaje, gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_puntosIzaje, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.EAST;
        add(l_pesoTotal, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_pesoTotal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.EAST;
        add(l_pesoUnitario, gbc);

        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_pesoUnitario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.EAST;
        add(l_numPercha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_numPercha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.EAST;
        add(l_capMaxPercha, gbc);

        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_capMaxPercha, gbc);

        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.EAST;
        add(l_operacion, gbc);

        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.anchor = GridBagConstraints.WEST;
        add(tf_operacion, gbc);
        setBackground(Color.CYAN);

    }

    public String getPesoTotal(){
        return tf_pesoTotal.getText();
    }
    public String getPuntosIzaje(){
        return tf_puntosIzaje.getText();
    }
    public String getFecha(){
        return tf_fecha.getText();
    }
    public String getProducto(){
        return tf_producto.getText();
    }
    public String getCantMax(){
        return tf_cantMax.getText();
    }
    public String getPesoUnitario(){
        return tf_pesoUnitario.getText();
    }
    public String getNumPercha(){
        return tf_numPercha.getText();
    }
    public String getCapPercha(){
        return tf_capMaxPercha.getText();
    }
    public String getOperacion(){
        return tf_operacion.getText();
    }     
}
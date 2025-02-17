import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Exportar {
    private String nombreArchivo;
    private Float peso;
    private Double longitud;

    public Exportar(Verificacion verif, Panel1 panel1, Panel2 panel2, Panel3 panel3, Percha pi1){
        nombreArchivo = "ConfigIzaje.txt";
        //Bloque try con recursos para evitar tener que usar el close, buffer es para no tener que abrir el archivo en cada write
        try (BufferedWriter archivo = new BufferedWriter(new FileWriter(nombreArchivo))) {
            archivo.write("Configuración de Izaje\n");
            archivo.write("--------------------------\n");
            archivo.write("FECHA: " + panel1.getFecha()+"\n");
            archivo.write("PRODUCTO A MANIPULAR: " + panel1.getProducto()+"\n");
            archivo.write("CANTIDAD MÁXIMA A IZAR: " + panel1.getCantMax()+"\n");
            archivo.write("CANT. PUNTOS DE IZAJE DE LA CARGA: " + panel1.getPuntosIzaje()+"\n");
            archivo.write("PESO TOTAL CON CANT. MÁXIMA (Tn): " + panel1.getPesoTotal()+"\n");
            archivo.write("PESO UNITARIO MÁX. (Tn): " + panel1.getPesoUnitario()+"\n");
            archivo.write("Nº PERCHA: "+ panel1.getNumPercha()+"\n");
            archivo.write("CAPACIDAD MÁXIMA PERCHA (Tn): "+ panel1.getCapPercha()+"\n");
            archivo.write("OPERACIÓN: "+ panel1.getOperacion()+"\n\n");
            archivo.write("Tiros Superiores\n");
            archivo.write("--------------------------\n");
            archivo.write("Longitud de la Eslinga: " + panel2.getLongEslingaSup() + "\n");
            archivo.write("Capacidad de la Eslinga: " + panel2.getResistEslingSup() + "\n");
            archivo.write("Cancamos a utilizar: ");
            for (int i = 0; i < panel2.getCheckBoxSup().length/2; i++) {
                if(panel2.getCheckBoxSup()[i].isSelected()){
                    archivo.write(pi1.getCancamosSup()[i].getNombre());
                    archivo.write("  ");
                    archivo.write(pi1.getCancamosSup()[i+panel2.getCheckBoxSup().length/2].getNombre());
                    archivo.write("  ");
                }
            }
            archivo.write("\n\n");
            archivo.write("Tiros Inferiores\n");
            archivo.write("--------------------------\n");
            archivo.write("Longitud de la Eslinga: " + panel3.getLongEslingaInf() + "\n");
            archivo.write("Capacidad de la Eslinga: " + panel3.getResistEslingInf() + "\n");
            archivo.write("Cancamos a utilizar: ");
            for (int i = 0; i < panel3.getCheckBoxInf().length/2; i++) {
                if(panel3.getCheckBoxInf()[i].isSelected()){
                    archivo.write(pi1.getCancamosInf()[i].getNombre());
                    archivo.write("  ");
                    archivo.write(pi1.getCancamosInf()[i+panel3.getCheckBoxInf().length/2].getNombre());
                    archivo.write("  ");
                }
            }
            archivo.write("\n\n");
            peso = verif.getPesoTotal()+pi1.getPeso();
            archivo.write("Peso bajo gancho de grúa: " + peso.toString() + "\n");
            longitud = verif.getLong() + 0.5 + Float.parseFloat(panel3.getLongEslingaInf());
            longitud = Math.round(longitud * 100.0) / 100.0;
            archivo.write("Longitud Total: " + longitud.toString() + "\n");
            JOptionPane.showMessageDialog(null,"El archivo se exportó de forma exitosa!", "Información", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,"No se pudo exportar el archivo!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }
}

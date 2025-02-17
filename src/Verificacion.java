import javax.swing.*;

public class Verificacion {
    private Float peso_total;
    private Float long_eslingaSup;
    private Float dist_centro;
    private Double angulo;
    private Double carga_eslingaSup;
    private Double carga_cancamoSup;
    private Float resistencia_cancamoSup;
    private Float resistencia_cancamoInf;
    private Float puntos_izaje;
    private Float carga_eslingaInf;
    private Float carga_cancamoInf;
    private Float resistencia_eslingaSup;
    private Float resistencia_eslingaInf;
    private Boolean bandera;

    public Verificacion(Panel1 panel1, Panel2 panel2, Panel3 panel3, Percha pi1){
        
        inicializarValores();
        //TIROS SUPERIORES
        int cont = 0, j = 0;
        if(panel2.getCheckBoxSup().length/2%2==0){
            for (int i = 0; i < panel2.getCheckBoxSup().length/4; i++) {
                if(cont==0 && (panel2.getCheckBoxSup()[i].isSelected() || panel2.getCheckBoxSup()[panel2.getCheckBoxSup().length/2-1-i].isSelected())){
                    dist_centro = pi1.getCancamosSup()[i].getDistCentro();
                    resistencia_cancamoSup = pi1.getCancamosSup()[i].getCapacidad();
                    j = i;
                    cont++;
                }else if(cont==1 && panel2.getCheckBoxSup().length/2-1-j != panel2.getCheckBoxSup().length/2-1-i && (panel2.getCheckBoxSup()[i].isSelected() || panel2.getCheckBoxSup()[panel2.getCheckBoxSup().length/2-1-i].isSelected())){
                    cont++;
                    JOptionPane.showMessageDialog(null,"Se seleccionaron más de un cáncamo superior, se tomará el par más alejado del centro.", "Advertencia!", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
            for (int i = 0; i <= panel2.getCheckBoxSup().length/4; i++) {
                if(cont==0 && (panel2.getCheckBoxSup()[i].isSelected() || panel2.getCheckBoxSup()[panel2.getCheckBoxSup().length/2-1-i].isSelected())){
                    dist_centro = pi1.getCancamosSup()[i].getDistCentro();
                    resistencia_cancamoSup = pi1.getCancamosSup()[i].getCapacidad();
                    j = i;
                    cont++;
                }else if(cont==1 && panel2.getCheckBoxSup().length/2-1-j != panel2.getCheckBoxSup().length/2-1-i && (panel2.getCheckBoxSup()[i].isSelected() || panel2.getCheckBoxSup()[panel2.getCheckBoxSup().length/2-1-i].isSelected())){
                    cont++;
                    JOptionPane.showMessageDialog(null,"Se seleccionaron más de un cáncamo superior, se tomará el par más alejado del centro.", "Advertencia!", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

        //TIROS INFERIORES
        cont = 0;
        if(panel3.getCheckBoxInf().length/2%2==0){
            for (int i = 0; i < panel3.getCheckBoxInf().length/4; i++) {
                if(cont==0 && (panel3.getCheckBoxInf()[i].isSelected() || panel3.getCheckBoxInf()[panel3.getCheckBoxInf().length/2-1-i].isSelected())){
                    resistencia_cancamoInf = pi1.getCancamosSup()[i].getCapacidad();
                    cont++;
                }
            }
        }else{
            for (int i = 0; i <= panel3.getCheckBoxInf().length/4; i++) {
                if(cont==0 && (panel3.getCheckBoxInf()[i].isSelected() || panel3.getCheckBoxInf()[panel3.getCheckBoxInf().length/2-1-i].isSelected())){
                    resistencia_cancamoInf = pi1.getCancamosSup()[i].getCapacidad();
                    cont++;
                }
            }
        }
        try {
            peso_total = Float.valueOf(panel1.getPesoTotal());
            long_eslingaSup = Float.valueOf(panel2.getLongEslingaSup());
            resistencia_eslingaSup = Float.valueOf(panel2.getResistEslingSup());
            puntos_izaje = Float.valueOf(panel1.getPuntosIzaje()); 
            resistencia_eslingaInf = Float.valueOf(panel3.getResistEslingInf());
            angulo = Math.toDegrees(Math.asin((Math.sqrt(Math.pow(dist_centro,2)+Math.pow((pi1.getAncho()/2),2)))/long_eslingaSup));
            System.out.println(angulo);
            carga_eslingaSup = ((peso_total + pi1.getPeso())/4)/Math.cos(Math.toRadians(angulo));
            carga_cancamoSup = carga_eslingaSup;
            carga_eslingaInf = peso_total/puntos_izaje;
            carga_cancamoInf = carga_eslingaInf;
            this.bandera = true;
        } catch (NumberFormatException e) {
            this.bandera = false;
            JOptionPane.showMessageDialog(null,"Debe completar todos los campos de forma correcta!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
            
    }

    private void inicializarValores(){
        angulo = 0d;
        resistencia_eslingaSup = 0f;
        resistencia_eslingaInf = 0f;
        carga_eslingaSup = 0d;
        carga_eslingaInf = 0f;
        carga_cancamoInf = 0f;
        carga_cancamoSup = 0d;
        dist_centro = 0f;
        peso_total = 0f;
        long_eslingaSup = 0f;
        puntos_izaje = 0f;
        resistencia_cancamoInf = 0f;
        resistencia_cancamoSup = 0f;
        bandera = false;
    }

    public Boolean verif_angulo(){
        return (angulo < 60);
    }

    public Boolean verif_eslingaSup(){
        return (resistencia_eslingaSup > carga_eslingaSup);
    }

    public Boolean verif_eslingaInf(){
        return (resistencia_eslingaInf > carga_eslingaInf);
    }

    public Boolean verif_cancamoSup(){
        return (resistencia_cancamoSup > carga_cancamoSup);
    }

    public Boolean verif_cancamoInf(){
        return (resistencia_cancamoInf > carga_cancamoInf);
    }

    public Float getPesoTotal(){
        return peso_total;
    }

    public Double getLong(){
        return (Math.sqrt(Math.pow(long_eslingaSup,2)-Math.pow(dist_centro,2)));
    }
    public Boolean getBandera(){
        return bandera;
    }
}


/* this.angulo = 0d;
        this.resistencia_eslingaSup = 0f;
        this.resistencia_eslingaInf = 0f;
        this.carga_eslingaSup = 0d;
        this.carga_eslingaInf = 0f;
        this.carga_cancamoInf = 0f;
        this.carga_cancamoSup = 0d;
        this.dist_centro = 0f;
        this.peso_total = 0f;
        this.long_eslingaSup = 0f;
        this.puntos_izaje = 0f;
        this.resistencia_cancamoInf = 0f;
        this.resistencia_cancamoSup = 0f;
        this.bandera = false; */
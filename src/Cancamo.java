public class Cancamo {
    private Float capacidad;
    private Float dist_centro;
    private String nombre;

    public Cancamo(String n, Float c, Float dc){
        this.nombre = n;
        this.capacidad = c;
        this.dist_centro = dc;
    };

    protected void setCapacidad(Float c){
        this.capacidad = c;
    }
    public Float getCapacidad(){
        return this.capacidad;
    }

    protected void setDistCentro(Float d){
        this.dist_centro = d;
    }
    public Float getDistCentro(){
        return this.dist_centro;
    }

    public void setNombre(String n){
        this.nombre = n;
    }
    public String getNombre(){
        return this.nombre;
    }
}

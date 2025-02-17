public class Percha {

    private final Float longitud, ancho, peso, sep_cancSup, sep_cancInf;
    private String nombre;
    private final Cancamo[] cancamos_sup;
    private final Cancamo[] cancamos_inf;

    public Percha(String n, Float l, Float a, Float p, int cs, Float ccs, int ci, Float cci, Float sepCS, Float sepCI) {
        this.nombre = n;
        this.longitud = l;
        this.ancho = a;
        this.peso = p;
        this.sep_cancSup = sepCS;
        this.sep_cancInf = sepCI;

        this.cancamos_sup = new Cancamo[cs];
        this.cancamos_inf = new Cancamo[ci];

        // Inicializar cancamos_sup
        if((cs/2)%2 == 0){
            for (int i = 0; i < cs/4; i++) {
                cancamos_sup[i] = new Cancamo((char)(i+65)+"S1", ccs, (this.longitud/2)-(i*this.sep_cancSup));
                cancamos_sup[i+cs/2]= new Cancamo((char)(i+65)+"S2", ccs, (this.longitud/2)-(i*this.sep_cancSup));
            }
            for (int i = cs/2-1; i >= cs/4; i--) {
                cancamos_sup[i] = new Cancamo((char)(i+65)+"S1", ccs, (this.longitud/2)-(i*this.sep_cancSup));
                cancamos_sup[i+cs/2]= new Cancamo((char)(i+65)+"S2", ccs, (this.longitud/2)-(i*this.sep_cancSup));
            }

        }else{
            for (int i = 0; i < cs/4; i++) {
                cancamos_sup[i] = new Cancamo((char)(i+65)+"S1", ccs, (this.longitud/2)-(i*this.sep_cancSup));
                cancamos_sup[i+cs/2]= new Cancamo((char)(i+65)+"S2", ccs, (this.longitud/2)-(i*this.sep_cancSup));
            }
            for (int i = cs/2-1; i > cs/4; i--) {
                cancamos_sup[i] = new Cancamo((char)(i+65)+"S1", ccs, (this.longitud/2)-(i*this.sep_cancSup));
                cancamos_sup[i+cs/2]= new Cancamo((char)(i+65)+"S2", ccs, (this.longitud/2)-(i*this.sep_cancSup));
            }
            cancamos_sup[cs/4] = new Cancamo((char)((cs/4)+65)+"S1", ccs, 0f);
            cancamos_sup[cs*3/4]= new Cancamo((char)((cs/4)+65)+"S2", ccs, 0f);
        }
        
        // Inicializar cancamos_inf
        if((ci/2)%2 == 0){
            for (int i = 0; i < ci/4; i++) {
                cancamos_inf[i] = new Cancamo((char)(i+65)+"I1", cci, (this.longitud/2)-(i*this.sep_cancInf));
                cancamos_inf[i+ci/2]= new Cancamo((char)(i+65)+"I2", cci, (this.longitud/2)-(i*this.sep_cancInf));
            }
            for (int i = ci/2-1; i >= ci/4; i--) {
                cancamos_inf[i] = new Cancamo((char)(i+65)+"I1", cci, (this.longitud/2)-(i*this.sep_cancInf));
                cancamos_inf[i+ci/2]= new Cancamo((char)(i+65)+"I2", cci, (this.longitud/2)-(i*this.sep_cancInf));
            }

        }else{
            for (int i = 0; i < ci/4; i++) {
                cancamos_inf[i] = new Cancamo((char)(i+65)+"I1", cci, (this.longitud/2)-(i*this.sep_cancInf));
                cancamos_inf[i+ci/2]= new Cancamo((char)(i+65)+"I2", cci, (this.longitud/2)-(i*this.sep_cancInf));
            }
            for (int i = ci/2-1; i > ci/4; i--) {
                cancamos_inf[i] = new Cancamo((char)(i+65)+"I1", cci, (this.longitud/2)-(i*this.sep_cancInf));
                cancamos_inf[i+ci/2]= new Cancamo((char)(i+65)+"I2", cci, (this.longitud/2)-(i*this.sep_cancInf));
            }
            cancamos_inf[ci/4] = new Cancamo((char)((ci/4)+65)+"I1", cci, 0f);
            cancamos_inf[ci*3/4]= new Cancamo((char)((ci/4)+65)+"I2", cci, 0f);
        }

    }

    public void setNombre(String n){
        nombre = n;
    }
    public float getLongitud(){
        return longitud;
    }
    public float getAncho(){
        return ancho;
    }
    public float getPeso(){
        return peso;
    }
    public String getNombre(){
        return nombre;
    }
    public Cancamo[] getCancamosSup(){
        return cancamos_sup;
    }
    public Cancamo[] getCancamosInf(){
        return cancamos_inf;
    }
}

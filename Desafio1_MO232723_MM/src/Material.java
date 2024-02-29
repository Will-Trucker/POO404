

public abstract class Material {
    protected String codigo;
    protected String titulo;
    protected int unidadesDisponibles;

    // Constructor
    public Material(String codigo, String titulo, int unidadesDisponibles){
        this.codigo = codigo;
        this.titulo = titulo;
        this.unidadesDisponibles = unidadesDisponibles;
    }

    //Getters y Setters
    public String getCodigo(){
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public int getUnidadesDisponibles(){
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    // Imprimir datos del material
    @Override
    public String toString(){
        return "Código: "+codigo+", Titulo "+titulo+", Unidades Disponibles: "+unidadesDisponibles;
    }
}

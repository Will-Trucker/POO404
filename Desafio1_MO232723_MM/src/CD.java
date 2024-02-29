import java.lang.Override;
public class CD extends Material {
    private String artista;
    private String genero;
    private int duracion;
    private int numCanciones;

    public CD(String codigo, String titulo, int unidadesDisponibles, String artista, String genero, int duracion, int numCanciones){
        super(codigo,titulo,unidadesDisponibles);
        this.artista = artista;
        this.genero = genero;
        this.duracion = duracion;
        this.numCanciones = numCanciones;
    }

    //Getters y Setters
    public String getArtista(){
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    @Override
    public String toString(){
        return super.toString()+ ", Artista "+artista+", Genero "+genero+", Duracion"+duracion+", Num. canciones "+numCanciones;
    }


}

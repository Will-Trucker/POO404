// Se extiende de Material
public class Libro extends Material{
    private String autor;
    private int numPaginas;
    private String editorial;
    private int anioPublicacion;

    //Constructor
    public Libro(String codigo, String titulo, int unidadesDisponibles,String autor, int numPaginas, String editorial, int anioPublicacion){
        super(codigo,titulo,unidadesDisponibles);
        this.autor = autor;
        this.numPaginas = numPaginas;
        this.editorial = editorial;
        this.anioPublicacion = anioPublicacion;
    }

    public String getAutor(){
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNumPaginas(){
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    public String getEditorial(){
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    //Imprimir datos del libro
    @Override
    public String toString(){
        return super.toString()+ ", Autor "+autor+", Num. páginas "+numPaginas+", Editorial "+editorial+", Año de publicacion "+anioPublicacion;
    }
}

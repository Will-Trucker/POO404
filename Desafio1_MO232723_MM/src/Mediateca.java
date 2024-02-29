import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;
import java.lang.*;

public class Mediateca {
    private List<Libro> libros;
    private List<CD> cds;

    public Mediateca() {
        libros = new ArrayList<>();
        cds = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarCD(CD cd) {
        cds.add(cd);
    }

    public void borrarLibro(String codigo) {
        libros.removeIf(libro -> libro.getCodigo().equals(codigo));
    }

    public void borrarCD(String codigo) {
        cds.removeIf(cd -> cd.getCodigo().equals(codigo));
    }

    public void listarMateriales() {
        StringBuilder mensaje = new StringBuilder("Libros disponibles:\n");
        for (Libro libro : libros) {
            mensaje.append(libro).append("\n");
        }
        mensaje.append("\nCDs disponibles:\n");
        for (CD cd : cds) {
            mensaje.append(cd).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensaje.toString(), "Materiales Disponibles", JOptionPane.INFORMATION_MESSAGE);
    }

    public Material buscarMaterial(String codigo) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(codigo)) {
                return libro;
            }
        }

        for (CD cd : cds) {
            if (cd.getCodigo().equals(codigo)) {
                return cd;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Mediateca mediateca = new Mediateca();
        while(true){
            String opcion = JOptionPane.showInputDialog("Ingrese la opcion que desea\n " +
                    "\n1. Ingresar materiales\n"+
                    "\n2. Borrar Materiales\n"+
                    "\n3. Listar Materiales\n"+
                    "\n4. Buscar Materiales\n"+
                    "\n5. Salir ");
            if(opcion == null || opcion.equals("5")){
                break;
            }
            switch (opcion){
                case "1":
                    String tipoMaterial = JOptionPane.showInputDialog("Ingrese el tipo de material"+
                            "\n1. Libros\n"+
                            "\n2. CDS\n");
                    if(tipoMaterial.equals("1")){
                        String codigoLibro = JOptionPane.showInputDialog("Ingrese cod. del libro: ");
                        String tituloLibro = JOptionPane.showInputDialog("Ingrese titulo de libro: ");
                        String autorLibro = JOptionPane.showInputDialog("Ingrese el autor del libro: ");
                        int numPaginas = Integer.parseInt(JOptionPane.showInputDialog("Num. de paginas: "));
                        String editorial =  JOptionPane.showInputDialog("Ingrese la editorial del libro: ");
                        int aniopublicacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese año de publicacion de libro"));
                        int unidadesDisponiblesLibro = Integer.parseInt(JOptionPane.showInputDialog("Unidades existentes: "));
                        Libro libro = new Libro(codigoLibro, tituloLibro,unidadesDisponiblesLibro,autorLibro,numPaginas,editorial,aniopublicacion);
                        mediateca.agregarLibro(libro);
                        JOptionPane.showMessageDialog(null,"Libro agregado exitosamente. ", "Éxito",JOptionPane.INFORMATION_MESSAGE);
                    } else if(tipoMaterial.equals("2")){
                        String codigoCD = JOptionPane.showInputDialog("Ingrese cod. del CD: ");
                        String tituloCD = JOptionPane.showInputDialog("Ingrese titulo del CD: ");
                        String artistaCD = JOptionPane.showInputDialog("Ingrese artista del CD: ");
                        String generoCD = JOptionPane.showInputDialog("Ingrese genero del CD: ");
                        int duracionCD = Integer.parseInt(JOptionPane.showInputDialog("Ingrese duracion del CD: "));
                        int numCanciones = Integer.parseInt(JOptionPane.showInputDialog("Ingrese num. canciones de artista: "));
                        int unidadesDisponiblesCD = Integer.parseInt(JOptionPane.showInputDialog("Ingrese unidades disponibles: "));
                        CD cd = new CD(codigoCD,tituloCD,duracionCD,generoCD,artistaCD,numCanciones,unidadesDisponiblesCD);
                        mediateca.agregarCD(cd);
                        JOptionPane.showMessageDialog(null,"CD agregado exitosamente. ","Éxito",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"OPCION NO VALIDA","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "2":
                    String codigoBorrar = JOptionPane.showInputDialog("Ingrese el codigo del material a borrar");
                    Material materialborrar = mediateca.buscarMaterial(codigoBorrar);
                    if(materialborrar instanceof Libro){
                        mediateca.borrarLibro(codigoBorrar);
                        JOptionPane.showMessageDialog(null,"Libro borrado exitosamente");
                    } else if (materialborrar instanceof CD){
                        mediateca.borrarCD(codigoBorrar);
                        JOptionPane.showMessageDialog(null,"CD borrado exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(null,"Material no encontrado","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "3":
                    mediateca.listarMateriales();
                    break;
                case "4":
                    String codigoBuscar = JOptionPane.showInputDialog("Ingrese el código del material que desea buscar: ");
                    Material materialBuscado = mediateca.buscarMaterial(codigoBuscar);
                    if(materialBuscado != null){
                        JOptionPane.showMessageDialog(null, "Material encontrado \n" + materialBuscado, "Exito", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null,"Material no encontrado \n","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Opcion Invalida","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

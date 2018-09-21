/**
 *
 * @author Carina Amairani Díaz Ramirez
 */
package Modelo;


public class ModelBloc {
    
    //Almacena la ruta del archivo
        private String path = "C:\\Users\\Ami\\Documents\\NetBeansProjects\\BlocDeNotas\\archivos\\texto.txt"; 

    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }
    
    
    
    //Guarda el contenido 
    private String message = ""; 

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    
    
}



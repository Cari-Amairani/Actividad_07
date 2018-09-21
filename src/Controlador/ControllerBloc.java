/**
 *
 * @author Carina Amairani Díaz Ramirez
 */
package Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Modelo.ModelBloc;
import Vista.ViewBloc;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ControllerBloc {

    
    // Crea un objeto para modelo
    ModelBloc modelBloc;
    
    ViewBloc viewBloc; 
    // Crea un objeto para ls vista

    
    
    
    ActionListener actionlistener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewBloc.abrir) {
                jb_archivo_action_performed();
            } else if (e.getSource() == viewBloc.Guardar) {
                jb_guardar_action_performed();
            }
        }
    };

    
    
   
    public ControllerBloc(ModelBloc modelBloc, ViewBloc viewBloc) {
        this.modelBloc = modelBloc;
        this.viewBloc = viewBloc;

        this.viewBloc.abrir.addActionListener(actionlistener);
        this.viewBloc.Guardar.addActionListener(actionlistener);
        initComponents();
    }

    /**
     * Método para el boton archivo
     */
    public void jb_archivo_action_performed() {
        this.readFile(modelBloc.getPath()); 
        //Motodo readFile y con la variable PATH
    }

    /**
     * Método para el boton guardar
     */
    public void jb_guardar_action_performed() {
        //Muestra el contenido en la pantalla
        modelBloc.setMessage(viewBloc.Jta_texto.getText()); 
        this.writeFile(modelBloc.getPath(), modelBloc.getMessage());
    }

    
    /**
     * Método para mostrar contenido del archivo.
     *
     * @param path: Indica la ruta donde se encuentra el archivo.
     * @return
     */
    public String readFile(String path) {
        try {
           //Muestra las filas. 
           String row; 
           // Muestra el contenido del archivo
            try (FileReader archivo = new FileReader(path)) { 
                // Almacena el contenido 
                BufferedReader bufferedreader = new BufferedReader(archivo); 
                while ((row = bufferedreader.readLine()) != null) {
                    viewBloc.Jta_texto.setText(row);
                }
            }
            //Marca los errores
        } catch (FileNotFoundException err) { 
            System.err.println("Archivo no encontrado: " + err.getMessage());
            //Marca error si no se puede visualizar el archivo
        } catch (IOException err) { 
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
        return null;
    }

    
    
    
    
    
    /**
     * Método para escribir Guardar  el nuevo contenido del fichero
     * @param path: Ruta del archivo
     * @param message: Almacena el texto 
     */
    
    public void writeFile(String path, String message) {
        try {
            //Abre el archivo, si no existe se crea
            File archivo = new File(path); 
            FileWriter filewriter = new FileWriter(archivo, false);

            try (PrintWriter printwriter = new PrintWriter(filewriter)) {
                printwriter.println(message);
                printwriter.close();
            }
        } 
        //Evalua si no hay errores
        catch (FileNotFoundException err) {
            System.err.println("Archivo no encontrado: " + err.getMessage());
        } catch (IOException err) {
            System.err.println("Error en operación I/O: " + err.getMessage());
        }
    }

    /**
     * Conponentes
     */
    public void initComponents() {
        viewBloc.setVisible(true);
    }

}

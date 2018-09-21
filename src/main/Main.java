/**
 *
 * @author Carina Amairani Díaz Ramirez
 */
package main;

import Controlador.ControllerBloc;
import Modelo.ModelBloc;
import Vista.ViewBloc;


public class Main {

    public static void main(String[] args) {
        
        ModelBloc modelblocnotas = new ModelBloc();
        ViewBloc viewblocnotas = new ViewBloc();
        ControllerBloc ontrollerblocnotas = new ControllerBloc(modelblocnotas, viewblocnotas); 
        
    }
    
}

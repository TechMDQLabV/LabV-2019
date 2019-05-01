package models;

import java.util.Observable;
import java.util.Observer;

public class Mechanic implements Observer {

    public void update(Observable o, Object args) {
        System.out.println("Something has changed in the car Nº: " + ((Car) o).getIdCar());
        if(args != null){
            System.out.println("\n" + ((Change) args).toString());
        }
        if(o instanceof Car){
            System.out.println("\t" + ((Car) o).toString());
            System.out.println("");
        }
    }
}

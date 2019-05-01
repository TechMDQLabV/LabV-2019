import models.Car;
import models.Mechanic;

import java.util.ArrayList;
import java.util.List;
import utilities.Tools;

public class mainObserver {
    public static void main(String[] args){
        Mechanic mechanic = new Mechanic();

        List<Car> cars = new ArrayList<Car>();

        for (int i=0; i<10;i++){
            cars.add(new Car(i+1,Tools.fName()+" "+Tools.fLastName()));
        }

        for(Car car : cars){
            car.addObserver(mechanic);
        }

        for(int i=0; i < 10; i++){
            int change = Tools.fRandomRange(0,3);
            int j = Tools.fRandomRange(0,9);
            Tools.fReplicante('_',150);
            System.out.println("");
            switch(change){
                case 0:
                    cars.get(j).setDriverName(Tools.fName()+" "+Tools.fLastName());
                    break;
                case 1:
                    cars.get(j).setOilLevel(Tools.fRandomRange(0,90));
                    break;
                case 2:
                    cars.get(j).setWaterLevel(Tools.fRandomRange(0,90));
                    break;
                case 3:
                    cars.get(j).setWheelAirLevel(Tools.fRandomRange(0,29));
                    break;
            }
        }

    }
}

package models;

import java.util.Observable;

public class Car extends Observable {
    private int idCar;
    private String driverName;
    private int oilLevel;
    private int waterLevel;
    private int wheelAirLevel;

    public Car(int idCar, String driverName) {
        this.idCar = idCar;
        this.driverName = driverName;
        this.oilLevel = 100;
        this.waterLevel = 100;
        this.wheelAirLevel = 30;
    }

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        String oldDriverName = this.driverName;
        this.driverName = driverName;
        setChanged();
        notifyObservers(new Change("Driver", oldDriverName, this.driverName));
    }

    public int getOilLevel() {
        return oilLevel;
    }

    public void setOilLevel(int oilLevel) {
        int oldOilLevel = this.oilLevel;
        this.oilLevel = oilLevel;
        setChanged();
        notifyObservers(new Change("Oil Level", String.valueOf(oldOilLevel), String.valueOf(this.oilLevel)));
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(int waterLevel) {
        int oldWaterLevel = this.waterLevel;
        this.waterLevel = waterLevel;
        setChanged();
        notifyObservers(new Change("Water Level", String.valueOf(oldWaterLevel), String.valueOf(this.waterLevel)));
    }

    public int getWheelAirLevel() {
        return wheelAirLevel;
    }

    public void setWheelAirLevel(int wheelAirLevel) {
        int oldWheelAirLevel = this.wheelAirLevel;
        this.wheelAirLevel = wheelAirLevel;
        setChanged();
        notifyObservers(new Change("Wheel Air Level", String.valueOf(oldWheelAirLevel), String.valueOf(this.wheelAirLevel)));
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", driverName='" + driverName + '\'' +
                ", oilLevel=" + oilLevel +
                ", waterLevel=" + waterLevel +
                ", wheelAirLevel=" + wheelAirLevel +
                '}';
    }
}

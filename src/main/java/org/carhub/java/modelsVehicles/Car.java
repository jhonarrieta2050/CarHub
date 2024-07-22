package org.carhub.java.modelsVehicles;

public class Car extends Vehicles {

    public Car() {
    }

    public Car(String name, int userId) {
        super(name, userId);
    }

    public Car(int id, String name, double price, String type) {
        super(id, name, price, type);
    }

    @Override
    void engineSound() {
        System.out.println("Car Engine Sound");
    }

}
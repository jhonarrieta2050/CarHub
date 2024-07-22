package org.carhub.java.modelsVehicles;

public class Motorcycle extends Vehicles {

    public Motorcycle() {
    }

    public Motorcycle(String name, int userId) {
        super(name, userId);
    }

    public Motorcycle(int userId, String name, double price, String type) {
        super(userId, name, price, type);
    }

    @Override
    void engineSound() {
        System.out.println("This is an engine sound of motorcycle"); ;
    }
}
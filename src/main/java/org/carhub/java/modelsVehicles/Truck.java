package org.carhub.java.modelsVehicles;

public class Truck extends Vehicles {

    public Truck() {
    }

    public Truck(String name, int userId) {
        super(name, userId);
    }

    public Truck(int userId, String name, double price, String type) {
        super(userId, name, price, type);
    }

    @Override
    void engineSound() {
        System.out.println("The Truck Engine Sound is on");
    }
}

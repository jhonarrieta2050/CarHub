package org.carhub.java.modelsVehicles;

public abstract class Vehicles {

    protected int id;
    protected String name;
    protected double price;
    protected String type;
    protected int userId;
    protected static int idS;

    public Vehicles() {
    }

    public Vehicles(String name, int userId) {
        this.name = name;
        this.userId = userId;
    }

    public Vehicles(int userId, String name, double price, String type) {
        this.id = idS++;
        this.userId = userId;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    abstract void engineSound();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", userId=" + userId +
                '}';
    }
}
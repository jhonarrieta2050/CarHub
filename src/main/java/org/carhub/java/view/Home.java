package org.carhub.java.view;

import org.carhub.java.modelUser.User;

import java.util.Scanner;

public class Home {
    private final Scanner sc = new Scanner(System.in);

    private int actualUserID = 0;
    private boolean pass = true;

    //Home
    public void home(User user){
        do {
            this.actualUserID = user.getId();
            System.out.println("Welcome back " + user.getName());
            System.out.println("What do you want to do?");
            System.out.println("1. Buy vehicles");
            System.out.println("2.See your vehicles");
            System.out.println("3. Sell your vehicles");
            System.out.println("4. Edit your vehicles");
            System.out.println("5. see the maintenance of your vehicles");
            System.out.println("6. Exit");
            System.out.println("7.add vehicles ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addVehicles();
                    break;
                case 2:
                    searchVehicles();
                    break;
                case 6:
                    pass = false;
                    break;
            }
        }while (pass);
    }

    //Buy vehicles
    private void addVehicles(){
        System.out.println("What do you want to add?");
        System.out.println("1. Car");
        System.out.println("2. Motorcycle");
        System.out.println("3. Truck");
        String choice = sc.next();

        System.out.println("Name of the product: ");
        String vehicleName = sc.next();
        System.out.println("Price of the product: ");
        String vehiclePrice = sc.next();
        System.out.println("Type of product: ");
        String vehicleType = sc.next();

        String id = String.valueOf(actualUserID);


        System.out.println("Vehicle added to the list");
    }

    private void searchVehicles(){
        System.out.println("What do you want to search?");
        System.out.println("Write the name of the product: ");
        String productName = sc.next();




    }
}
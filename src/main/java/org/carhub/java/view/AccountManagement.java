package org.carhub.java.view;


import org.carhub.java.modelUser.User;
import org.carhub.java.controllerss.ControllerUsers;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class AccountManagement {

    private boolean opc = true;
    private final ControllerUsers controller = new ControllerUsers();
    private final Scanner sc = new Scanner(System.in);
    private User user;

    //The welcome
    public User accountManagement()  {

        do {
            System.out.println("Hello and welcome back");
            System.out.println("Choose an option");
            System.out.println("1. Login");
            System.out.println("2. sign up");
            System.out.println("3. Exit");
            String op = sc.next();

            switch (op) {
                case "1" -> {
                    user = logIn();
                    if (user != null) {
                        opc = false;
                    }
                }
                case "2" -> {
                    try {
                        signUp();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                case "3" -> System.exit(0);
                default -> System.out.println("Invalid option");
            }
        }while (opc);

        return user;
    }

    //Register
    private void signUp() throws InterruptedException {
        boolean pass = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter your name");
        String name = sc.next();
        System.out.println("Enter your age");
        String age = sc.next();
        System.out.println("Enter your birthday");
        String birthday = sc.next();
        System.out.println("Enter your email");
        String email = sc.next();
        System.out.println("Enter your password");
        String password = sc.next();


        ExecutorService frameThread = Executors.newSingleThreadExecutor();

        Runnable Thread = () -> {
            System.out.println("Creating account");
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Your account has been created");
        };

        Future<?> future = frameThread.submit(Thread);

        while (!future.isDone()) {
            System.out.println("Please wait");
            TimeUnit.SECONDS.sleep(2);
        }

        frameThread.shutdown();


        pass = controller.add(name, age, birthday, email, password);

        if (pass) {
            System.out.println("Account created");
        }else{
            System.out.println("Account not created");
        }
    }

    // Login in your account
    private User logIn() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your email address");
        String email = sc.nextLine();
        System.out.println("Please enter your password");
        String password = sc.nextLine();

        User user = controller.search(email,password);

        if (user != null) {
            System.out.println("Logged in");
            return user;
        }else{
            System.out.println("Login failed");
        }
        return null;
    }
}

package org.carhub.java.controllerss;


import org.carhub.java.modelUser.User;
import org.carhub.java.modelUser.UserDao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ControllerUsers implements ControllerInterface<User> {
    private final UserDao userAccess = new UserDao();

    @Override
    public boolean add(String... info) {

        String name = info[0];
        int age = Integer.parseInt(info[1]);

        DateTimeFormatter parser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday = LocalDate.parse(info[2],parser);

        String email = info[3];
        String password = info[4];

       int r = userAccess.add(new User(name, age, birthday, email, password));

       return r != -1;
    }

    @Override
    public boolean remove(String... info) {
        return false;
    }

    @Override
    public User search(String... info) {

        String email = info[0];
        String password = info[1];

        return userAccess.get(new User(email,password));
    }

}

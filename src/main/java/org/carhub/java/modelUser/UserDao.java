package org.carhub.java.modelUser;

import org.carhub.java.DAO.DAO;
import org.carhub.java.controllerss.ConversionFunctions;
import org.carhub.java.database.ConnectionDataBase;

import java.sql.*;
import java.time.LocalDate;

public class UserDao implements DAO<User> {
    private final String ADD = "INSERT INTO USERS (name, age, birthday, email, password, wallet) VALUES (?, ?, ?, ?, ?, ?)";
    private final String GET = "SELECT * FROM USERS WHERE email = ? AND password = ?";
    @Override
    public int add(User model) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = ConnectionDataBase.getConnection();
            ps = con.prepareStatement(ADD);

            ps.setString(1, model.getName());
            ps.setInt(2,model.getAge());
            ps.setDate(3, ConversionFunctions.toSqlDate(model.getBirthday()));
            ps.setString(4, model.getEmail());
            ps.setString(5, model.getPassword());
            ps.setDouble(6, model.getWallet());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }finally {
            if(ps != null) try { ps.close(); } catch (SQLException e) { e.printStackTrace(); }
            if(con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace();}
        }
    }

    @Override
    public void update(User model) {

    }

    @Override
    public void delete(User model) {

    }

    @Override
    public User get(User model) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = ConnectionDataBase.getConnection();
            ps = con.prepareStatement(GET);
            ps.setString(1, model.getEmail());
            ps.setString(2, model.getPassword());
            rs = ps.executeQuery();
            if(rs.next()) {
                model.setEmail(rs.getString("email"));
                model.setPassword(rs.getString("password"));
                model.setAge(rs.getInt("age"));
                model.setName(rs.getString("name"));
                model.setWallet(rs.getDouble("wallet"));
                LocalDate localDate = LocalDate.parse(rs.getString("birthday"));
                model.setBirthday(localDate);
            }

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
        return model;
    }
}

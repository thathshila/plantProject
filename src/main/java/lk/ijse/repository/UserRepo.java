package lk.ijse.repository;

import javafx.scene.control.Alert;
import lk.ijse.db.DbConnection;
import lk.ijse.model.User;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepo {
    public static List<User> getAll() throws SQLException {
        String sql = "SELECT * FROM User";

        PreparedStatement pstm = DbConnection.getInstance().getConnection()
                .prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();

        List<User> userList = new ArrayList<>();

        while (resultSet.next()) {
            String User_id = resultSet.getString(1);
            String User_name = resultSet.getString(2);
            Date date = Date.valueOf(resultSet.getString(3));
            String Password = resultSet.getString(4);

            User user = new User(User_id, User_name, date,Password);

            userList.add(user);
        }
        return userList;
    }


    public static void RegisterNow(String userId, String userName, Date date, String password) throws SQLException {
        String sql = "INSERT INTO User VALUES (?, ? ,?, ? )";
        PreparedStatement pstm = DbConnection.getInstance().getConnection().prepareStatement(sql);
        pstm.setObject(1, userId);
        pstm.setObject(2, userName);
        pstm.setObject(3, date);
        pstm.setObject(4, password);

        int effectedRows = pstm.executeUpdate();
        if (effectedRows > 0) {
            new Alert(Alert.AlertType.CONFIRMATION, "Register successfully!!!").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Can't register this user").show();
        }

    }
}



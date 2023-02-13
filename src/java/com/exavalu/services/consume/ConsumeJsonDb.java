/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services.consume;

import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class ConsumeJsonDb {
    public static boolean insertData(int userId,int id,String title,boolean completed) {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();

        String sql ="INSERT INTO consumedata(userId,id,title,completed)"
                + "VALUES(?,?,?,?)";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, id);
            preparedStatement.setString(3, title);
            preparedStatement.setBoolean(4, completed);

            int rs = preparedStatement.executeUpdate();

            if (rs != 0) {
                result = true;
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return result;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;

import com.exavalu.models.User;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class UserService {
    public static boolean doSignup(User emp)
    {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();
        
        String sql="INSERT INTO users(emailAddress,password,firstName,lastName,status,countryCode,stateCode,districtCode)"
                + "VALUES(? ,? ,? ,? ,?,?,?,?);";
        
        try {
            
            PreparedStatement preparedStatement=con.prepareStatement(sql);
            preparedStatement.setString(1, emp.getEmailAddress());
            preparedStatement.setString(2, emp.getPassword());
            preparedStatement.setString(3, emp.getFirstName());
            preparedStatement.setString(4, emp.getLastName());
            preparedStatement.setInt(5, 1);
            preparedStatement.setString(6, emp.getCountryCode());
            preparedStatement.setString(7, emp.getStateCode());
            preparedStatement.setString(8, emp.getDistrictCode());
            
            int rs = preparedStatement.executeUpdate();

            if(rs!=0)
            {
                result=true;
            }
            
            
        } catch (SQLException ex) {
            
            ex.printStackTrace();
            
        }
        
        return result;
    }

    public static ArrayList getCountries() {
        ArrayList countList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "Select * from countries";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setCountryCode(rs.getString("countryCode"));
                user.setCountryName(rs.getString("countryName"));

                countList.add(user);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return countList;
    }

    public static ArrayList getState(String cid) {
        ArrayList stateList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "Select * from states where countryCode = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, cid);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setStateCode(rs.getString("stateCode"));
                user.setStateName(rs.getString("stateName"));

                stateList.add(user);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return stateList;
    }

    public static ArrayList getDistrict(String stateCode) {
        ArrayList districtList = new ArrayList();
        try {

            Connection con = JDBCConnectionManager.getConnection();

            String sql = "Select * from districts where stateCode = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, stateCode);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setDistrictCode(rs.getString("districtCode"));
                user.setDistrictName(rs.getString("districtName"));
                districtList.add(user);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return districtList;
    }
}

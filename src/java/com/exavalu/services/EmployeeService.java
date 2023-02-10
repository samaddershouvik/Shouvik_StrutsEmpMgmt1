/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.services;


import com.exavalu.models.Employee;
import com.exavalu.utils.JDBCConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class EmployeeService {
    
    public static EmployeeService employeeService = null;
    
    public static EmployeeService getInstance()
    {
        if(employeeService==null)
        {
            return new EmployeeService();
        }
        else
        {
            return employeeService;
        }
    }
    
    public ArrayList getAllEmployees()
    {
        ArrayList empList = new ArrayList();
        String sql = "Select * from employees e,department d,role r where e.deptId=d.departmentId and e.roleId=r.roleId order by employeeId";
        try {
            Connection con = JDBCConnectionManager.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Employee emp = new Employee();
                
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setName(rs.getString("Name"));
                emp.setPhone(rs.getString("phoneNumber"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentId(rs.getString("deptId"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleId(rs.getString("roleId"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllaowance(rs.getString("carAllowance"));
                
                empList.add(emp);
            }
            
            
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.err.println("Total rows:"+empList.size());
        return empList;
    }
    
    public static Employee getEmployee(String employeeId) {
        Employee emp = new Employee();

        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e, department d, role r "
                    + "where e.deptId=d.departmentId and e.roleId=r.roleId and  e.employeeId =?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, employeeId);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {

                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setName(rs.getString("Name"));
                emp.setPhone(rs.getString("phoneNumber"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentId(rs.getString("deptId"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleId(rs.getString("roleId"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllaowance(rs.getString("carAllowance"));
                
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(emp.getEmployeeId());
        return emp;
    }
    
    public static Boolean editEmployee(Employee emp) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE employees SET Name = ? , phoneNumber = ? , address = ? , gender = ? , age = ? ,"
                    + " basicSalary = ?, carAllowance = ?, deptId = ?, roleId = ? WHERE employeeId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getPhone());
            preparedStatement.setString(3, emp.getAddress());
            preparedStatement.setString(4, emp.getGender());
            preparedStatement.setString(5, emp.getAge());
            preparedStatement.setString(6, emp.getBasicSalary());
            preparedStatement.setString(7, emp.getCarAllaowance());
            preparedStatement.setString(8, emp.getDepartmentId());
            preparedStatement.setString(9, emp.getRoleId());

            preparedStatement.setString(10, emp.getEmployeeId());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static boolean updateEmployee(Employee emp) {
        boolean result = false;
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "UPDATE employees SET Name = ? , phoneNumber = ? , address = ? , gender = ? , age = ? ,"
                    + " basicSalary = ?, carAllowance = ?, deptId = ?, roleId = ? WHERE employeeId = ?";

            PreparedStatement preparedStatement = con.prepareStatement(sql);

            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getPhone());
            preparedStatement.setString(3, emp.getAddress());
            preparedStatement.setString(4, emp.getGender());
            preparedStatement.setString(5, emp.getAge());
            preparedStatement.setString(6, emp.getBasicSalary());
            preparedStatement.setString(7, emp.getCarAllaowance());
            preparedStatement.setString(8, emp.getDepartmentId());
            preparedStatement.setString(9, emp.getRoleId());

            preparedStatement.setString(10, emp.getEmployeeId());

            int row = preparedStatement.executeUpdate();

            if (row == 1) {
                result = true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }
    
    public static boolean insertEmployee(Employee emp) {
        boolean result = false;
        Connection con = JDBCConnectionManager.getConnection();

        String sql ="INSERT INTO employees(Name,phoneNumber,address,gender,age,deptId,roleId,basicSalary,carAllowance)"
                + "VALUES(?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, emp.getName());
            preparedStatement.setString(2, emp.getPhone());
            preparedStatement.setString(3, emp.getAddress());
            preparedStatement.setString(4, emp.getGender());
            preparedStatement.setString(5, emp.getAge());
            preparedStatement.setString(6, emp.getDepartmentId());
            preparedStatement.setString(7, emp.getRoleId());
            preparedStatement.setString(8, emp.getBasicSalary());
            preparedStatement.setString(9, emp.getCarAllaowance());

            int rs = preparedStatement.executeUpdate();

            if (rs != 0) {
                result = true;
            }

        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        return result;
    }
    
    public static ArrayList searchEmployee(Employee semp) {
        ArrayList empList = new ArrayList();
        try {
            Connection con = JDBCConnectionManager.getConnection();
            String sql = "select * from employees e, department d, role r where e.deptId=d.departmentId and e.roleId=r.roleId "
                    + "having Name like ?"
                    + "and gender like ?"
                    + "and deptId like ?"
                    + "and age like ?"
                    + "and phoneNumber like ?"
                    + "and e.roleId like ? order by employeeId";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, semp.getName() + "%");
            preparedStatement.setString(2, semp.getGender() + "%");
            preparedStatement.setString(3, semp.getDepartmentId() + "%");
            preparedStatement.setString(4, semp.getAge() + "%");
            preparedStatement.setString(5, semp.getPhone() + "%");
            preparedStatement.setString(6, semp.getRoleId() + "%");
            System.out.println("Prepared statement = " + preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Employee emp = new Employee();
                emp.setAddress(rs.getString("address"));
                emp.setEmployeeId(rs.getString("employeeId"));
                emp.setName(rs.getString("Name"));
                emp.setPhone(rs.getString("phoneNumber"));
                emp.setGender(rs.getString("gender"));
                emp.setAge(rs.getString("age"));
                emp.setDepartmentId(rs.getString("deptId"));
                emp.setDepartmentName(rs.getString("departmentName"));
                emp.setRoleId(rs.getString("roleId"));
                emp.setRoleName(rs.getString("roleName"));
                emp.setBasicSalary(rs.getString("basicSalary"));
                emp.setCarAllaowance(rs.getString("carAllowance"));

                empList.add(emp);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println("Number of employees = " + empList.size());
        return empList;
    }
}

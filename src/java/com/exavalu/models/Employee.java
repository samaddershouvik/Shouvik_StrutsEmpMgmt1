/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;


import com.exavalu.services.DepartmentService;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.RoleService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Avijit Chattopadhyay
 */
public class Employee extends ActionSupport{

    private String employeeId;
    private String name ;
    private String phone ;
    private String address ;
    private String gender ;
    private String age ;
    private String departmentId ;
    private String roleId ;
    private String basicSalary ;
    private String carAllaowance;
    private String departmentName ;
    
    private Map<String, Object> sessionMap = ActionContext.getContext().getSession();
    
//    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();
//
//    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();
//
//    @Override
//    public void setApplication(Map<String, Object> application){
//        map = (ApplicationMap) application;
//    }
//
//    @Override
//    public void setSession(Map<String, Object> session) {
//        sessionMap = (SessionMap) session;
//    }
    
    public String getAllEmp() throws Exception {
        String result = "FAILURE";
        ArrayList empListnew = EmployeeService.getInstance().getAllEmployees();
        boolean success = false;
        if(empListnew!=null)
            success = true;
        if (success) {
            System.out.println("returning Success from getAllEmp method");
            result = "SUCCESS";
            sessionMap.put("EmpList",empListnew);
            
        } else {
            System.out.println("returning Failure from getAllEmp method");
        }

        return result;
    }
    
    public String doEdit() throws Exception {
        String result = "FAILURE";
        String id=this.employeeId;
        System.out.println(id);
        Employee emp = EmployeeService.getEmployee(this.employeeId);
        boolean success = false;
        if(emp.getName()!=null)
            success = true;
        if (success) {
            System.out.println("returning Success from doEdit method");
            result = "SUCCESS";
            sessionMap.put("Emp",emp);
            ArrayList deptList = DepartmentService.getAllDepartment();
            sessionMap.put("DeptList",deptList);
            ArrayList roleList = RoleService.getAllRoles();
            sessionMap.put("RoleList",roleList);
            
        } else {
            System.out.println("returning Failure from doEdit method");
        }

        return result;
    }
    
    public String doSave() throws Exception {
        String result = "FAILURE";
//        Employee emp = (Employee) sessionMap.get("Emp");
        boolean success = EmployeeService.updateEmployee(this);
        if (success) {
            System.out.println("returning Success from doSave method");
            result = "SUCCESS";
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("EmpList",empList);
            ArrayList deptList = DepartmentService.getAllDepartment();
            sessionMap.put("DeptList",deptList);
            ArrayList roleList = RoleService.getAllRoles();
            sessionMap.put("RoleList",roleList);
            
        } else {
            System.out.println("returning Failure from doSave method");
        }

        return result;
    }
    
    public String insertEmp() throws Exception {
        String result = "FAILURE";
        System.out.print(this.name);
        boolean success = EmployeeService.insertEmployee(this);

        if (success) {
            System.out.println("returning Success from doLogin method");
            result = "SUCCESS";
            sessionMap.put("InsertError","Inserted successfully");
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("EmpList",empList);
            ArrayList deptList = DepartmentService.getAllDepartment();
            sessionMap.put("DeptList",deptList);
            ArrayList roleList = RoleService.getAllRoles();
            sessionMap.put("RoleList",roleList);
            
        } else {
            System.out.println("returning Failure from doLogin method");
            sessionMap.put("InsertError","Could not Insert");
        }

        return result;
    }
    
    public String doSearch() throws Exception {
        String result = "FAILURE";
//        Employee emp = (Employee) sessionMap.get("Emp");
        ArrayList empListnew = EmployeeService.searchEmployee(this);
        boolean success = false;
        if(empListnew!=null)
            success = true;
        if (success) {
            System.out.println("returning Success from doSave method");
            result = "SUCCESS";
            sessionMap.put("EmpList",empListnew);
            ArrayList deptList = DepartmentService.getAllDepartment();
            sessionMap.put("DeptList",deptList);
            ArrayList roleList = RoleService.getAllRoles();
            sessionMap.put("RoleList",roleList);
            
        } else {
            System.out.println("returning Failure from doSave method");
        }

        return result;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    private String roleName ;

 

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

 

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

 

    /**
     * @return the firstName
     */
    public String getName() {
        return name;
    }

 

    /**
     * @param firstName the firstName to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

 

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

 

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

 

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

 

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

 

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

 

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

 

    /**
     * @param age the age to set
     */
    public void setAge(String age) {
        this.age = age;
    }

 

    /**
     * @return the departmentId
     */
    public String getDepartmentId() {
        return departmentId;
    }

 

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

 

    /**
     * @return the roleId
     */
    public String getRoleId() {
        return roleId;
    }

 

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

 

    /**
     * @return the basicSalary
     */
    public String getBasicSalary() {
        return basicSalary;
    }

 

    /**
     * @param basicSalary the basicSalary to set
     */
    public void setBasicSalary(String basicSalary) {
        this.basicSalary = basicSalary;
    }

 

    /**
     * @return the carAllaowance
     */
    public String getCarAllaowance() {
        return carAllaowance;
    }

 

    /**
     * @param carAllaowance the carAllaowance to set
     */
    public void setCarAllaowance(String carAllaowance) {
        this.carAllaowance = carAllaowance;
    }
}

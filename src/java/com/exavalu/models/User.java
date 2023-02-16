/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.exavalu.models;

import com.exavalu.services.DepartmentService;
import com.exavalu.services.EmployeeService;
import com.exavalu.services.LoginService;
import com.exavalu.services.RoleService;
import com.exavalu.services.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.dispatcher.ApplicationMap;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Admin
 */
public class User extends ActionSupport implements ApplicationAware, SessionAware, Serializable {
    static Logger log = Logger.getLogger(User.class.getName());
    private String emailAddress;
    private String password;
    private String firstName;
    private String lastName;
    private String status;
    private String countryCode,countryName,stateCode,stateName,districtCode,districtName;
    
    private SessionMap<String, Object> sessionMap = (SessionMap) ActionContext.getContext().getSession();

    private ApplicationMap map = (ApplicationMap) ActionContext.getContext().getApplication();

    @Override
    public void setApplication(Map<String, Object> application) {
        map = (ApplicationMap) application;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        sessionMap = (SessionMap) session;
    }
    
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }
    
    public String doLogin() throws Exception {
        String result = "FAILURE";

        boolean success = LoginService.getInstance().doLogin(this);

        if (success) {
            System.out.println("returning Success from doLogin method");
            result = "SUCCESS";
            sessionMap.put("Loggedin",this);
            ArrayList empList = EmployeeService.getInstance().getAllEmployees();
            sessionMap.put("EmpList",empList);
            ArrayList deptList = DepartmentService.getAllDepartment();
            sessionMap.put("DeptList",deptList);
            ArrayList roleList = RoleService.getAllRoles();
            sessionMap.put("RoleList",roleList);
            
        } else {
            System.out.println("returning Failure from doLogin method");
            log.error("Wrong User Data inputted");
        }

        return result;
    }
    
    public String doSignup() throws Exception {
        String result = "FAILURE";

        boolean success = UserService.doSignup(this);

        if (success) {
            System.out.println("returning Success from doSignup method");
            result = "SUCCESS";
            
        } else {
            System.out.println("returning Failure from doSignup method");
        }

        return result;
    }
    
    public String doPreSignup() throws Exception {
        String result = "SUCCESS";
        ArrayList countryList = UserService.getCountries();
        sessionMap.put("CountList", countryList);
        if (this.countryCode != null) {
            System.out.println("In state");
            ArrayList stateList = UserService.getState(this.countryCode);
            sessionMap.put("ProvinceList", stateList);
            sessionMap.put("emp", this);
            result = "STATE";
        }
        if (this.stateCode != null) {
            System.out.println("In district");
            ArrayList districtList = UserService.getDistrict(this.stateCode);
            sessionMap.put("DistrictList", districtList);
            sessionMap.put("emp", this);
            System.out.println(this.districtCode);
            result = "DISTRICT";
        }
        return result;
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}

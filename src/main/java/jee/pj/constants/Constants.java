/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.pj.constants;

/**
 *
 * @author willi
 */
public class Constants {
    
    /* Error messages */
    public final static String ERR_MESSAGE = "Connection failed ! Verify your login/password and try again";
    public final static String ERR_LOGIN_PWD = "You must enter values in both fields";
    public final static String ERR_SELECTION = "Please select an employee";
    public final static String ERR_ADD = "Action not allowed";
    public final static String ERR_EMP = "The company has no employee !";
    public final static String ERR_EMAIL = "The email is not correct !";
    public final static String ERR_WORKPHONE = "Phone work phone number is not correct !";
    public final static String ERR_MOBPHONE = "Phone mobile phone number is not correct !";
    public final static String ERR_HOMEPHONE = "Phone home phone number is not correct !";
    
    /* JSP Pages */
    public final static String JSP_HOME = "/WEB-INF/JSP/home.jsp";
    public final static String JSP_HOMEPAGE = "/WEB-INF/JSP/homePage.jsp";
    public final static String JSP_HOMEPAGE_EMPL = "/WEB-INF/JSP/homePage_emp.jsp";
    public final static String JSP_DETAILS = "/WEB-INF/JSP/details.jsp";
    public final static String JSP_DETAILS_EMPL = "/WEB-INF/JSP/details_emp.jsp";
    public final static String JSP_LOGOUT = "/WEB-INF/JSP/logout.jsp";
    public final static String JSP_HOMEPAGE_NOEMP = "/WEB-INF/JSP/noEmployees_homePage.jsp";
    public final static String JSP_HOMEPAGE_NOEMP_EMPL = "/WEB-INF/JSP/noEmployees_homePage_emp.jsp";
    public final static String JSP_GOODBYE = "/WEB-INF/JSP/goodbye.jsp";
    
    /* Properties file*/
    public final static String PROP_DB = "/WEB-INF/db.properties";
    
    /* Form attributes */
    public final static String FRM_LOGIN = "username";
    public final static String FRM_PWD = "password";
    public final static String FRM_SUBMIT = "submit_btn";
    public final static String FRM_SELECT = "selection";
    public final static String FRM_ACTION = "action";
    public final static String FRM_DETAILACTION = "detailAction";
    public final static String FRM_LOG = "actionConnect";
    
    /* SQL Requests */
    public final static String SQL_USERS = "SELECT * FROM USERS";
    public final static String SQL_ADDEMP = "INSERT INTO EMPLOYEES (LASTNAME, FIRSTNAME, HOMEPHONE, MOBILEPHONE, WORKPHONE, ADDRESS, POSTALCODE, CITY, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public final static String SQL_UPDATEEMP = "UPDATE EMPLOYEES SET LASTNAME = ?, FIRSTNAME =?, HOMEPHONE = ?, WORKPHONE =? , MOBILEPHONE = ?, ADDRESS =?,POSTALCODE =?, CITY =?, EMAIL=?  WHERE IDEMP = ?";
    public final static String SQL_DELEMP = "DELETE FROM EMPLOYEES WHERE IDEMP = ?";
    public final static String SQL_GETEMP = "SELECT * FROM EMPLOYEES";
}
    
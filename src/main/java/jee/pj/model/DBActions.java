/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.pj.model;

import java.sql.*;
import java.util.ArrayList;
import jee.pj.beans.Employee;
import jee.pj.beans.User;
import static jee.pj.constants.Constants.*;


/**
 *
 * @author willi
 */
public class DBActions {
    
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private boolean test;
    
    private ArrayList<User> tableUsers;
    private ArrayList<Employee> tableEmployees;
    
       
    
//    public DBActions(String url, String login, String password) throws ClassNotFoundException, SQLException
//    {
//       Class.forName("com.mysql.jdbc.Driver");
//        conn = DriverManager.getConnection(url, login, password);
//    }


    public Statement getStatement() throws SQLException
    {
        stmt = conn.createStatement();
        return stmt;
    }
    
    public PreparedStatement getPStatement(String PQuery) throws SQLException
    {
        pstmt = conn.prepareStatement(PQuery);
        return pstmt;
    }
    
    public ResultSet getResultSet(String SQLQuery) throws SQLException
    {
        stmt = getStatement();
        rs = stmt.executeQuery(SQLQuery);
        return rs;
    }

    
    public ArrayList<Employee> getEmployee() throws SQLException
    {

        tableEmployees = new ArrayList<Employee>();
     
        rs = getResultSet(SQL_GETEMP);

        while(rs.next())
        {
            Employee employee = new Employee();
            
            employee.setId(rs.getInt("IDEMP"));
            employee.setFirst_name(rs.getString("FIRSTNAME"));
            employee.setName(rs.getString("LASTNAME"));
            employee.setHome_phone(rs.getString("HOMEPHONE"));
            employee.setMobile_phone(rs.getString("MOBILEPHONE"));
            employee.setWork_phone(rs.getString("WORKPHONE"));
            employee.setAddress(rs.getString("ADDRESS"));
            employee.setPostal_code(rs.getString("POSTALCODE"));
            employee.setCity(rs.getString("CITY"));
            employee.setEmail(rs.getString("EMAIL"));

            tableEmployees.add(employee);

        }

        return tableEmployees;
    }
    
    
    public Employee searchEmployeeById(int employeeId) throws SQLException
    {
        tableEmployees = getEmployee();
        
        for(Employee employee : tableEmployees)
        {
            if(employeeId == employee.getId())
                return employee;
        }
        return null;
    }
    
    public void deleteEmployee(Employee employee) throws SQLException
    {
        tableEmployees = getEmployee();
        pstmt = getPStatement(SQL_DELEMP);
        for(Employee emp : tableEmployees)
        {
            if(emp.getId()== employee.getId())
            {
                pstmt.setInt(1, emp.getId());
                pstmt.executeUpdate();
            }
        }

    }
    
    public boolean checkEmployee(Employee employee) throws SQLException
    {
        tableEmployees = getEmployee();
        test = false;
        for(Employee emp : tableEmployees)
        {
            if(employee.getId() == emp.getId())  
                test = true;
        }
        return test;
    }
    
    public void updateEmployee(Employee updateEmp) throws SQLException
    {
        pstmt = getPStatement(SQL_UPDATEEMP);
        
        pstmt.setString(1, updateEmp.getName());
        pstmt.setString(2, updateEmp.getFirst_name());
        pstmt.setString(3, updateEmp.getHome_phone());
        pstmt.setString(4, updateEmp.getWork_phone());
        pstmt.setString(5, updateEmp.getMobile_phone());
        pstmt.setString(6, updateEmp.getAddress());
        pstmt.setString(7, updateEmp.getPostal_code());
        pstmt.setString(8, updateEmp.getCity());
        pstmt.setString(9, updateEmp.getEmail());
        pstmt.setInt(10, updateEmp.getId());
        pstmt.executeUpdate();

    }
    
    public void addEmployee(Employee employee) throws SQLException
    {
        pstmt = getPStatement(SQL_ADDEMP);
        pstmt.setString(1, employee.getName());
        pstmt.setString(2, employee.getFirst_name());
        pstmt.setString(3, employee.getHome_phone());
        pstmt.setString(4, employee.getMobile_phone());
        pstmt.setString(5, employee.getWork_phone());
        pstmt.setString(6, employee.getAddress());
        pstmt.setString(7, employee.getPostal_code());
        pstmt.setString(8, employee.getCity());
        pstmt.setString(9, employee.getEmail());
        pstmt.executeUpdate();
    }
           
    
    public boolean valideEmployeeEmail(Employee employee)
    {
        test = true;
        if(!employee.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$"))
        {
            test = false;
        }
        return test;
    }
    
    public boolean valideEmployeeWorkPhone(Employee employee)
    {
        test = true;
        if(!employee.getWork_phone().matches("^\\d+$"))
        {
            test = false;
        }
        return test;
    }
    
    public boolean valideEmployeeMobPhone(Employee employee)
    {
        test = true;
        if(!employee.getMobile_phone().matches("^\\d+$"))
        {
            test = false;
        }
        return test;
    }
    
    public boolean valideEmployeeHomePhone(Employee employee)
    {
        test = true;
        if(!employee.getHome_phone().matches("^\\d+$"))
        {
            test = false;
        }
        return test;
    }
    
}

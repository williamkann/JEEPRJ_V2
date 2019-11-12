/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.pj.beans;

import jee.pj.entities.Employees;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



/**
 *
 * @author willi
 */
@Stateless
public class empBean {


    @PersistenceContext(unitName="jee.pj_JEEPRJ_V2_war_1.0PU")
    EntityManager em;
    
    boolean test;
     /**
     *
     * @return employees
     */
    public List<Employees> getEmployees()
    {
        Query q = em.createNamedQuery("Employees.findAll");
        return q.getResultList();
    }
    
    /**
     *
     * @param employeeId id of the employee we are searching for
     * @return employee with the id requested
     */
    public Employees searchEmployeeById(int employeeId)
    {
        Query q = em.createNamedQuery("Employees.findByIdemp").setParameter("idemp", employeeId);
        Employees emp = (Employees)q.getSingleResult();
        return emp;
    }
    
    /**
     *
     * @param employee employee to remove
     */
    public void deleteEmployees(Employees employee)
    {
        Employees emp = em.find(Employees.class, employee.getIdemp());
        em.remove(emp);
    }
    
    /**
     *
     * @param employee employee to check if he exists
     * @return true if employee found
     */
    public boolean checkEmployee(Employees employee)
    {
        test = false;
        for(Employees emp : getEmployees())
        {
            if(emp.getIdemp() == employee.getIdemp())
                test = true;
        }
        return test;
    }
    
        
    /**
     *
     * @param updateEmp employee we want to update information 
     */
    public void updateEmployee(Employees updateEmp)
    {
  
        Employees emp = em.find(Employees.class, updateEmp.getIdemp());
        emp.setFirstname(updateEmp.getFirstname());
        emp.setLastname(updateEmp.getLastname());
        emp.setHomephone(updateEmp.getWorkphone());
        emp.setWorkphone(updateEmp.getWorkphone());
        emp.setMobilephone(updateEmp.getMobilephone());
        emp.setAddress(updateEmp.getAddress());
        emp.setPostalcode(updateEmp.getPostalcode());
        emp.setEmail(updateEmp.getEmail());
        emp.setCity(updateEmp.getCity());
        
        em.persist(emp);
    }
    
    /**
     *
     * @param employee employee to add to the list
     */
    public void addEmployee(Employees employee)
    {
        Employees newEmployee = employee;
        em.persist(newEmployee);
    }
           
    /**
     *
     * @param employee employee's mail we want to check
     * @return return true if the field is correctly filled
     */
    public boolean valideEmployeeEmail(Employees employee)
    {
        test = true;
        if(!employee.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            test = false;
        
        return test;
    }
    
    
    /**
     *
     * @param employee employee's work phone we want to check
     * @return return true if the field is correctly filled
     */
    public boolean valideEmployeeWorkPhone(Employees employee)
    {
        test = true;
        if(!employee.getWorkphone().matches("^\\d+$"))
            test = false;
        
        return test;
    }
    
    
    /**
     *
     * @param employee employee's mobile phone we want to check
     * @return return true if the field is correctly filled
     */
    public boolean valideEmployeeMobPhone(Employees employee)
    {
        test = true;
        if(!employee.getMobilephone().matches("^\\d+$"))
            test = false;
        
        return test;
    }
    
    /**
     *
     * @param employee employee's home phone we want to check
     * @return return true if the field is correctly filled
     */
    public boolean valideEmployeeHomePhone(Employees employee)
    {
        test = true;
        if(!employee.getHomephone().matches("^\\d+$"))
            test = false;
        
        return test;
    }

    
    
    
    
}

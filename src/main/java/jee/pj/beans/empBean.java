/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.pj.beans;

import jee.pj.entities.Employees;
import java.util.List;
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
    
    public List<Employees> getEmployees()
    {
        Query q = em.createNamedQuery("Employees.findAll");
        return q.getResultList();
    }
    
    public Employees searchEmployeeById(int employeeId)
    {
        Query q = em.createNamedQuery("Employees.findByIdemp").setParameter("idemp", employeeId);
        Employees emp = (Employees)q.getSingleResult();
        return emp;
    }
    
    public void deleteEmployees(Employees employee)
    {
        Employees emp = em.find(Employees.class, employee.getIdemp());
        em.remove(emp);
    }
    
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
    
    public void addEmployee(Employees employee)
    {
        Employees newEmployee = employee;
        em.persist(newEmployee);
    }
           
    
    public boolean valideEmployeeEmail(Employees employee)
    {
        test = true;
        if(!employee.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$"))
            test = false;
        
        return test;
    }
    
    public boolean valideEmployeeWorkPhone(Employees employee)
    {
        test = true;
        if(!employee.getWorkphone().matches("^\\d+$"))
            test = false;
        
        return test;
    }
    
    public boolean valideEmployeeMobPhone(Employees employee)
    {
        test = true;
        if(!employee.getMobilephone().matches("^\\d+$"))
            test = false;
        
        return test;
    }
    
    public boolean valideEmployeeHomePhone(Employees employee)
    {
        test = true;
        if(!employee.getHomephone().matches("^\\d+$"))
            test = false;
        
        return test;
    }
    
}

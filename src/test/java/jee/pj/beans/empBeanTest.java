/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.pj.beans;

import java.util.Arrays;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import jee.pj.entities.Employees;
import static org.hamcrest.CoreMatchers.hasItems;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author willi
 */
public class empBeanTest {
    
    public empBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEmployees method, of class empBean.
     */
    @Test
    public void testGetEmployees() throws Exception {
        System.out.println("getEmployees");
       
        List<Employees> result = Arrays.asList(
                new Employees(1,"willi","kann"),
                new Employees(2,"nico","thong")
        );
        List<Employees> tresult = Arrays.asList(
                new Employees(1,"willi","kan"),
                new Employees(2,"nico","thong")
        );
        assertThat(result, hasItems(
                new Employees(1,"willi","azer"),
                new Employees(2,"nico","thong")
        ));
    }

    /**
     * Test of searchEmployeeById method, of class empBean.
     */
    @Test
    public void testSearchEmployeeById() throws Exception {
        System.out.println("searchEmployeeById");
        int employeeId = 0;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        empBean instance = (empBean)container.getContext().lookup("java:global/classes/empBean");
        Employees expResult = null;
        Employees result = instance.searchEmployeeById(employeeId);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEmployees method, of class empBean.
     */
    @Test
    public void testDeleteEmployees() throws Exception {
        System.out.println("deleteEmployees");
        Employees employee = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        empBean instance = (empBean)container.getContext().lookup("java:global/classes/empBean");
        instance.deleteEmployees(employee);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkEmployee method, of class empBean.
     */
    @Test
    public void testCheckEmployee() throws Exception {
        System.out.println("checkEmployee");
        Employees employee = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        empBean instance = (empBean)container.getContext().lookup("java:global/classes/empBean");
        boolean expResult = false;
        boolean result = instance.checkEmployee(employee);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateEmployee method, of class empBean.
     */
    @Test
    public void testUpdateEmployee() throws Exception {
        System.out.println("updateEmployee");
        Employees updateEmp = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        empBean instance = (empBean)container.getContext().lookup("java:global/classes/empBean");
        instance.updateEmployee(updateEmp);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addEmployee method, of class empBean.
     */
    @Test
    public void testAddEmployee() throws Exception {
        System.out.println("addEmployee");
        Employees employee = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        empBean instance = (empBean)container.getContext().lookup("java:global/classes/empBean");
        instance.addEmployee(employee);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valideEmployeeEmail method, of class empBean.
     */
    @Test
    public void testValideEmployeeEmail() throws Exception {
        System.out.println("valideEmployeeEmail");
        Employees employee = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        empBean instance = (empBean)container.getContext().lookup("java:global/classes/empBean");
        boolean expResult = false;
        boolean result = instance.valideEmployeeEmail(employee);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valideEmployeeWorkPhone method, of class empBean.
     */
    @Test
    public void testValideEmployeeWorkPhone() throws Exception {
        System.out.println("valideEmployeeWorkPhone");
        Employees employee = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        empBean instance = (empBean)container.getContext().lookup("java:global/classes/empBean");
        boolean expResult = false;
        boolean result = instance.valideEmployeeWorkPhone(employee);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valideEmployeeMobPhone method, of class empBean.
     */
    @Test
    public void testValideEmployeeMobPhone() throws Exception {
        System.out.println("valideEmployeeMobPhone");
        Employees employee = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        empBean instance = (empBean)container.getContext().lookup("java:global/classes/empBean");
        boolean expResult = false;
        boolean result = instance.valideEmployeeMobPhone(employee);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of valideEmployeeHomePhone method, of class empBean.
     */
    @Test
    public void testValideEmployeeHomePhone() throws Exception {
        System.out.println("valideEmployeeHomePhone");
        Employees employee = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        empBean instance = (empBean)container.getContext().lookup("java:global/classes/empBean");
        boolean expResult = false;
        boolean result = instance.valideEmployeeHomePhone(employee);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

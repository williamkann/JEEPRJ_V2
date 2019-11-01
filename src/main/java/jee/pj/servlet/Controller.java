/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.pj.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jee.pj.beans.User;
import jee.pj.model.DBActions;
import jee.pj.entities.Employees;
import jee.pj.beans.empBean;
import static jee.pj.constants.Constants.*;

/**
 *
 * @author willi
 */
public class Controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
//    String url;
//    String login;
//    String password;
//    InputStream input;
    static boolean btn;
//    Employee employee;
//    private DBActions dba;
    
    @EJB
    public empBean empbean;
    
    Employees employee;
    
    public static String CON_DETAILS;
    public static String CON_HOMEPAGE;
    public static String CON_HOMEPAGE_NOEMP;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        
//        Properties prop = new Properties();
//        input = getServletContext().getResourceAsStream(PROP_DB);
//        prop.load(input); 
//
//        url = prop.getProperty("dbUrl");
//        login = prop.getProperty("dbLogin");
//        password = prop.getProperty("dbPassword");
//        DBActions dba = new DBActions(url, login, password);

        employee = new Employees();

        
        String submit_btn = request.getParameter(FRM_SUBMIT);
        String selection = request.getParameter(FRM_SELECT);
        String action = request.getParameter(FRM_ACTION);
        String detailAction = request.getParameter(FRM_DETAILACTION);
        String loginAction = request.getParameter(FRM_LOG);

        if(submit_btn == null && action == null && detailAction == null && loginAction == null)
            btn = false;

        //If it's not the first time we load the home.jsp file
        if(btn != false && submit_btn != null)   
        {

            User userInput = new User();
            userInput.setLogin(request.getParameter(FRM_LOGIN));
            userInput.setPassword(request.getParameter(FRM_PWD));
            
            ServletContext ctx = this.getServletContext();
            String pwdAdmin = ctx.getInitParameter("passwordAdmin"); // See what is in password variable set in the web.xml
            String lgnAdmin = ctx.getInitParameter("loginAdmin");
            
            String pwdEmpl = ctx.getInitParameter("passwordEmpl"); // See what is in password variable set in the web.xml
            String lgnEmpl = ctx.getInitParameter("loginEmpl");

            if((userInput.getLogin().equals(lgnAdmin) && userInput.getPassword().equals(pwdAdmin)) || (userInput.getLogin().equals(lgnEmpl) && userInput.getPassword().equals(pwdEmpl)))
            {
                HttpSession session = request.getSession();
                session.setAttribute("user", userInput);
                
                User u = (User)session.getAttribute("user");
                
                //Adaptation of the JSPs if it's an employee or an admin
                if(u.getLogin().equals("admin"))
                {
                    CON_HOMEPAGE = JSP_HOMEPAGE;
                    CON_HOMEPAGE_NOEMP = JSP_HOMEPAGE_NOEMP;
                    CON_DETAILS = JSP_DETAILS;
                }
                else if(u.getLogin().equals("empl"))
                {
                    CON_HOMEPAGE = JSP_HOMEPAGE_EMPL;
                    CON_HOMEPAGE_NOEMP = JSP_HOMEPAGE_NOEMP_EMPL;
                    CON_DETAILS = JSP_DETAILS_EMPL;
                }
                
                //Display of the table empty / not empty
                if(empbean.getEmployees().isEmpty())
                {
                    request.setAttribute("ERR_EMP", ERR_EMP);
                    request.getRequestDispatcher(CON_HOMEPAGE_NOEMP).forward(request, response);
                }
                else
                {    
                    request.setAttribute("EmployeeTable", empbean.getEmployees());
                    request.getRequestDispatcher(CON_HOMEPAGE).forward(request, response);
                }
                
            }
            else if(userInput.getLogin() != null && userInput.getPassword() != null)
            {
                if(userInput.getLogin().trim().isEmpty() || userInput.getPassword().trim().isEmpty())
                {
                    request.setAttribute("ERR_LOGIN_PWD", ERR_LOGIN_PWD);
                    request.getRequestDispatcher(JSP_HOME).forward(request, response);
                }
                else
                {
                    request.setAttribute("ERR_MESSAGE", ERR_MESSAGE);
                    request.getRequestDispatcher(JSP_HOME).forward(request, response);
                }
            }
        }
        //If we load the page for the first time
        else if(submit_btn == null && btn == false)
        {
            btn = true;
            request.getRequestDispatcher(JSP_HOME).forward(request, response);
        }
        
        
        /**
         * 
         * Actions on the homePage file (Add / Delete / Details)
         * 
         */

//        else if(action != null)
//        {
//            //we check if a radio button is selected and if the employee selected is in the table
//            if(selection != null && dba.searchEmployeeById(Integer.parseInt(selection)) != null)
//            {
//                employee = dba.searchEmployeeById(Integer.parseInt(selection));
//
//                if(action.equals("Details"))
//                {
//                    request.setAttribute("employee", employee);
//                    request.getRequestDispatcher(CON_DETAILS).forward(request, response);
//                }
//                else if(action.equals("Delete"))
//                {
//                    dba.deleteEmployee(employee);
//
//                    if(dba.getEmployee().isEmpty())
//                    {
//                        request.setAttribute("ERR_EMP", ERR_EMP);
//                        request.getRequestDispatcher(CON_HOMEPAGE_NOEMP).forward(request, response);
//                    }
//                    else
//                    {   
//                        request.setAttribute("EmployeeTable", dba.getEmployee());
//                        request.getRequestDispatcher(CON_HOMEPAGE).forward(request, response);
//                    }
//                }
//                //if a radio button is selected but we clicked on add
//                else if(action.equals("Add"))
//                {
//                    request.setAttribute("EmployeeTable", dba.getEmployee());   
//                    request.setAttribute("ERR_ADD", ERR_ADD);
//                    request.getRequestDispatcher(CON_HOMEPAGE).forward(request, response);
//                }
//                else if(action.equals("Logout"))
//                {
//                    HttpSession session = request.getSession();
//
//                    session.invalidate();
//                    
//                    request.getRequestDispatcher(JSP_GOODBYE).forward(request, response);
//                }
//
//            }
//       
//            //if we click on add without selecting a radio button, we will send it to the detail page
//            else if(selection == null)
//            {   
//                if(action.equals("Add"))
//                {
//                  
//                    Employee emp = new Employee();
//                    emp.setName("");
//                    emp.setFirst_name("");
//                    emp.setHome_phone("");
//                    emp.setMobile_phone("");
//                    emp.setWork_phone("");
//                    emp.setPostal_code("");
//                    emp.setAddress("");
//                    emp.setCity("");
//                    emp.setEmail("");
//
//                    request.setAttribute("employee", emp);
//                    request.getRequestDispatcher(CON_DETAILS).forward(request, response);
//                }
//                else if ((action.equals("Delete") || action.equals("Details")) && dba.getEmployee().isEmpty())
//                {
//                    request.setAttribute("ERR_EMP", ERR_EMP);
//                    request.getRequestDispatcher(CON_HOMEPAGE_NOEMP).forward(request, response);
//                }
//                else if(action.equals("Logout"))
//                {
//                    
//                    HttpSession session = request.getSession();
//                    
//                    session.invalidate();
//
//                    request.getRequestDispatcher(JSP_GOODBYE).forward(request, response);
//                }
//                else
//                { 
//                    request.setAttribute("EmployeeTable", dba.getEmployee());
//                    request.setAttribute("ERR_SELECTION", ERR_SELECTION);
//                    request.getRequestDispatcher(CON_HOMEPAGE).forward(request, response);
//                }
//
//            }
//  
//            
//        }
//        
//        
//        /**
//         * 
//         * Actions on the detail page (Save or Cancel buttons)
//         * 
//         * 
//         */
//        
//        else if(detailAction != null)
//        {
//            if(detailAction.equals("Save"))
//            {              
//                employee = new Employee();
//                String id = request.getParameter("id");
//                String name = request.getParameter("name");
//                String first_name = request.getParameter("first_name");
//                String home_phone = request.getParameter("homePhone");
//                String work_phone = request.getParameter("workPhone");
//                String mobile_phone = request.getParameter("mobilePhone");
//                String address = request.getParameter("address");
//                String postal_code = request.getParameter("postalCode");
//                String city = request.getParameter("city");
//                String email = request.getParameter("email");
//
//
//                employee.setId(Integer.parseInt(id));
//                employee.setName(name);
//                employee.setFirst_name(first_name);
//                employee.setHome_phone(home_phone);
//                employee.setMobile_phone(mobile_phone);
//                employee.setWork_phone(work_phone);
//                employee.setAddress(address);
//                employee.setPostal_code(postal_code);
//                employee.setCity(city);
//                employee.setEmail(email);
//
//                if(dba.valideEmployeeEmail(employee) && dba.valideEmployeeWorkPhone(employee) && dba.valideEmployeeHomePhone(employee) && dba.valideEmployeeMobPhone(employee))
//                {
//                     if(dba.checkEmployee(employee) == false)
//                     {
//                         dba.addEmployee(employee);
//                         request.setAttribute("EmployeeTable", dba.getEmployee());
//                         request.getRequestDispatcher(CON_HOMEPAGE).forward(request, response);
//                     }
//                     else
//                     {
//                         dba.updateEmployee(employee);
//                         request.setAttribute("EmployeeTable", dba.getEmployee());
//                         request.getRequestDispatcher(CON_HOMEPAGE).forward(request, response);
//                     }
//                }
//                else
//                {
//                    if(!dba.valideEmployeeEmail(employee))
//                        request.setAttribute("ERR_EMAIL", ERR_EMAIL);
//
//                    if(!dba.valideEmployeeWorkPhone(employee))
//                        request.setAttribute("ERR_WORKPHONE", ERR_WORKPHONE);
//
//                    if(!dba.valideEmployeeMobPhone(employee))
//                        request.setAttribute("ERR_MOBPHONE", ERR_MOBPHONE);
//
//                    if(!dba.valideEmployeeHomePhone(employee))
//                        request.setAttribute("ERR_HOMEPHONE", ERR_HOMEPHONE);
//
//
//                    request.setAttribute("employee", employee);
//                    request.getRequestDispatcher(CON_DETAILS).forward(request, response);
//                }    
//            }
//            else if(detailAction.equals("Cancel"))
//            {
//                 if(dba.getEmployee().isEmpty())
//                 {
//                     request.setAttribute("ERR_EMP", ERR_EMP);
//                     request.getRequestDispatcher(CON_HOMEPAGE_NOEMP).forward(request, response);
//                 }
//                 else
//                 {
//                     request.setAttribute("EmployeeTable", dba.getEmployee());
//                     request.getRequestDispatcher(CON_HOMEPAGE).forward(request, response);
//                 }
//
//            }
//        }
//        
//        else if(loginAction.equals("Connect"))
//        {
//            response.sendRedirect("temp.jsp");
//        }
    }
   


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

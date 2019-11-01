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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method"
    @PersistenceContext(unitName="jee.pj_JEEPRJ_V2_war_1.0PU")
    EntityManager em;
    public List<Employees> getEmployees()
    {
        Query q = em.createNamedQuery("Employees.findAll");
        return q.getResultList();
    }
}

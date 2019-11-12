/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee.pj.beans;

/**
 *
 * @author willi
 */
public class User {
    
    private String login;
    private String password;
   
    /**
     *
     * @return login
     */
    public String getLogin() {
        return login;
    }
    
    /**
     *
     * @param login String we want to set the login of the user with
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }
    
    /**
     *
     * @param password String we want to set the password of the user with
     */
    public void setPassword(String password) {
        this.password = password;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author dudu
 */
public class Authentication {
    private long id_auth;
    private String password;  
    private String recoveredkey;
    
    private boolean active;

    public Authentication() {
    }

    public Authentication(long id_auth, String password, String recoveredkey) {
        this.id_auth = id_auth;
        this.password = password;
        this.recoveredkey = recoveredkey;
    }

    public long getId_auth() {
        return id_auth;
    }

    public void setId_auth(long id_auth) {
        this.id_auth = id_auth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRecoveredkey() {
        return recoveredkey;
    }

    public void setRecoveredkey(String recoveredkey) {
        this.recoveredkey = recoveredkey;
    }
    
}

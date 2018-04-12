/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author HP
 */
public class User {
    private int id ;
    
    private String password;
    private String nom;
    private String Roles;
     private String email;
    private int  num_tel;
private String username;
    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return Roles;
    }

    public void setRoles(String Roles) {
        this.Roles = Roles;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String Roles) {
        this.username = username;
        this.password = password;
        this.Roles = Roles;
    }

    public User(String username) {
        this.username = username;
    }

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, String password, String nom, String Roles, String username) {
        this.id = id;
        this.password = password;
        this.nom = nom;
        this.Roles = Roles;
        this.username = username;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public User(int id, String password, String nom, String Roles, String email, int num_tel, String username) {
        this.id = id;
        this.password = password;
        this.nom = nom;
        this.Roles = Roles;
        this.email = email;
        this.num_tel = num_tel;
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNum_tel() {
        return num_tel;
    }

    public void setNum_tel(int num_tel) {
        this.num_tel = num_tel;
    }
    
    
}

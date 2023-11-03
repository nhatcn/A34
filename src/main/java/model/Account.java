/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author trinh
 */
public class Account {

    private String avarta;

    private String user;
    private String pass;
    private String fullName;
    private int isSell;
    private int isAdmin;
    private String BD;
    private String gender;

    public Account() {
    }

    public Account(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public Account(String avarta, String user, String pass, String fullName, int isSell, int isAdmin) {
        this.avarta = avarta;
        this.user = user;
        this.pass = pass;
        this.fullName = fullName;
        this.isSell = isSell;
        this.isAdmin = isAdmin;
    }

    public Account(String avarta, String user, String pass, String fullName, String gender, String BD) {
        this.avarta = avarta;
        this.user = user;
        this.pass = pass;
        this.fullName = fullName;
        this.BD = BD;
        this.gender = gender;
    }

    public String getBD() {
        return BD;
    }

    public void setBD(String BD) {
        this.BD = BD;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAvarta() {
        return avarta;
    }

    public void setAvarta(String avarta) {
        this.avarta = avarta;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

/**
 *
 * @author pc
 */
public class Usuario {

    private int id;

    private String email;

    private String password;

    private String nombre;

    private int edad;

    public Usuario(int id, String email, String password, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.edad = edad;
    }

    @Override
    public boolean equals(Object obj) {
        if(super.equals(obj))
            return true;
        else {
            Usuario usu = (Usuario) obj;
            return usu.getId() == this.getId() &&
                    (usu.getEmail() == null ? this.getEmail() == null 
                    : usu.getEmail().equals(this.getEmail()));
        }
    }
    
    /**
     * Get the value of edad
     *
     * @return the value of edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Set the value of edad
     *
     * @param edad new value of edad
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}

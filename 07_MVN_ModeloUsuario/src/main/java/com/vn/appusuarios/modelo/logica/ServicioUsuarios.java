/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo.logica;

import com.vn.appusuarios.modelo.Usuario;
import com.vn.appusuarios.modelo.dao.UsuariosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Equipo 13
 */
public class ServicioUsuarios {
    
    UsuariosDAO daoUsu;
    ChivatoServicios chivato;
    
    public ServicioUsuarios() {
        daoUsu = new UsuariosDAO();
        
    }
    
    public void setChivatoListener(ChivatoServicios chivato) {
        this.chivato = chivato;
    }

    /**
     * Función para validar usuarios: primero comprobar que ninguno de los
     * parámetros es nulo, segundo comprobar que tienen una longitud mínima
     * despues comprobar con expresiones regulares por ultimo comprobar que edad
     * sea mayor que 12
     *
     * @param email
     * @param password
     * @param nombre
     * @param edad
     * @return
     */
    public Usuario crearUsuarioValido(String email, String password, String nombre, String edad) {
        
        if (email != null && password != null && nombre != null && edad != null) {
            if (email.length() >= 3
                    && nombre.length() > 1
                    && 3 < password.length()
                    && !"".equals(edad)) {
                String regexEmail = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";
                Pattern patternEmail = Pattern.compile(regexEmail);
                
                Pattern patternNombre = Pattern
                        .compile("^[A-Z][a-z0-9]+ ?[A-Za-z0-9]*$");
                Matcher matherEmail = patternEmail.matcher(email);
                Matcher matherNombre = patternNombre.matcher(nombre);
                if (matherEmail.find() == false) {
                    notificarError("Debe tener formato de correo electrónico");
                    return null;
                } else if (matherNombre.find() == false) {
                    notificarError("El nombre solo admite caracteres alfabéticos");
                    return null;
                } else {
                    try {
                        int iEdad = Integer.parseInt(edad);
                        if (iEdad >= 12) {
                            Usuario usuario = new Usuario(-1, email, password, nombre, iEdad);
                            return usuario;
                        } else {
                            return null;
                        }
                    } catch (NumberFormatException e) {
                        notificarError("La edad no se puede parsear a int: " + edad + 
                                " error: " + e.getMessage());
                        return null;
                    }
                }
            } else {
                notificarError("Hay un campo que no cumple la longitud");
                return null;
            }
        } else {
            notificarError("No admite NULOS");
            return null;
        }
    }    

    void notificarError(String mensajeError) {
        System.out.println("Error ServicioUsuario: " + mensajeError);
        if (chivato != null) {
            chivato.notificarError(mensajeError);
            
        }
    }

    /**
     *
     * @param email
     * @param password
     * @param nombre
     * @param edad
     * @return
     * @throws Exception
     */
    public Usuario crear(String email, String password, String nombre, String edad) {
        Usuario nuevoUsu = crearUsuarioValido(email, password, nombre, edad);
        if (nuevoUsu != null) {
            try {
                nuevoUsu = daoUsu.crear(nuevoUsu);
            } catch (Exception ex) {
                Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                notificarError(ex.getMessage());
                return null;
            }
            return nuevoUsu;
        }
        return null;
    }
    
    public Usuario leerUno(int id) {
        try {
            return daoUsu.obtenerPorId(id);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Usuario leerUno(String email) {
        try {
            return daoUsu.obtenerPorEmail(email);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Usuario modificar(int id, String email, String password, String nombre, String edad) {
        Usuario usuMod = crearUsuarioValido(email, password, nombre, edad);
        if (usuMod != null) {
            usuMod.setId(id);
            try {
                usuMod = daoUsu.modificar(usuMod);
            } catch (Exception ex) {
                Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
                notificarError(ex.getMessage());
            }
            return usuMod;
        }
        return null;
    }
    
    public boolean eliminar(int id) {
        try {
            return daoUsu.eliminar(id);
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public ArrayList<Usuario> leerTodos() {
        try {
            return daoUsu.obtenerTodos();
        } catch (SQLException ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ServicioUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

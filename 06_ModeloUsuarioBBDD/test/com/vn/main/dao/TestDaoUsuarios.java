/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.main.dao;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestDaoUsuarios {

    private ServicioUsuarios srvUsu;

    public TestDaoUsuarios() {
        srvUsu = new ServicioUsuarios();
    }

    @Test
    public void crearUsuariosInvalidos() throws Exception {
        Usuario u1 = srvUsu.crear(null, "", null, "");
        Usuario u2 = srvUsu.crear("", "a1", "Nom", "");
        Usuario u3 = srvUsu.crear("b@a.a", "a1", "", "");
        Usuario u4 = srvUsu.crear("b@a.a", "1234", "Nom 2", "SIN EDAD");
        Usuario u5 = srvUsu.crear("b@a.a", "1234", "Nom 2", "10");
        assertNull(u1);
        assertNull(u2);
        assertNull(u3);
        assertNull(u4);
        assertNull(u5);
        assertNull(srvUsu.leerUno("b@a.a"));
    }

    @Test
    public void crearUsuariosValidos() throws Exception {
        Usuario u1 = srvUsu.crear("zaira7@zaira.a", "1234", "Zaira", "20");
        Usuario u2 = srvUsu.crear("aurea7@aurea.com", "4321", "Aurea", "30");
        Usuario u3 = srvUsu.crear("german7@german.com", "5678", "German", "35");
        Usuario u4 = srvUsu.crear("nombre7@nombre.com", "8765", "Nombre", "67");
        Usuario u5 = srvUsu.crear("pepito7@pepito.com", "9876", "Pepito", "55");

        assertTrue(srvUsu.leerUno("zaira7@zaira.a").getId() > 0);
        assertEquals("Aurea", srvUsu.leerUno("aurea7@aurea.com").getNombre());
        assertEquals("German", srvUsu.leerUno(u3.getId()).getNombre());
        assertEquals("8765", srvUsu.leerUno("nombre7@nombre.com").getPassword());
        assertEquals(55, srvUsu.leerUno("pepito7@pepito.com").getEdad());

        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
        srvUsu.eliminar(u3.getId());
        srvUsu.eliminar(u4.getId());
        srvUsu.eliminar(u5.getId());
    }

    @Test
    public void modificarUsuariosInvalidos() throws Exception {
        Usuario u1 = srvUsu.crear("zaira3@zaira.a", "1234", "Zaira", "20");
        Usuario u2 = srvUsu.crear("aurea3@aurea.com", "4321", "Aurea", "30");
        Usuario u3 = srvUsu.crear("german3@german.com", "5678", "German", "35");
        Usuario u4 = srvUsu.crear("nombre3@nombre.com", "8765", "Nombre", "67");
        Usuario u5 = srvUsu.crear("pepito3@pepito.com", "9876", "Pepito", "55");

        srvUsu.modificar(u1.getId(), u1.getEmail(), u1.getPassword(), u1.getNombre(), "10");
        assertEquals(20, srvUsu.leerUno("zaira3@zaira.a").getEdad());

        srvUsu.modificar(u2.getId(), "aureamene.es", u2.getPassword(), u2.getNombre(), "26");
        assertEquals(u2.getId(), srvUsu.leerUno("aurea3@aurea.com").getId());

        srvUsu.modificar(u3.getId(), u3.getEmail(), "abc", u3.getNombre(), "40");
        assertEquals("5678", srvUsu.leerUno(u3.getId()).getPassword());

        srvUsu.modificar(u4.getId(), u4.getEmail(), u4.getPassword(), "t", "60");
        assertEquals("German", srvUsu.leerUno("german3@german.com").getNombre());

        srvUsu.modificar(u5.getId(), "german3@german.com", u5.getPassword(), u5.getNombre(), "28");
        assertEquals(u5.getId(), srvUsu.leerUno("pepito3@pepito.com").getId());

        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
        srvUsu.eliminar(u3.getId());
        srvUsu.eliminar(u4.getId());
        srvUsu.eliminar(u5.getId());
    }

    @Test
    public void modificarUsuariosValidos() throws Exception {
        Usuario u1 = srvUsu.crear("zaira2@zaira.a", "1234", "Zaira", "20");
        Usuario u2 = srvUsu.crear("aurea2@aurea.com", "4321", "Aurea", "30");
        Usuario u3 = srvUsu.crear("german2@german.com", "5678", "German", "35");
        Usuario u4 = srvUsu.crear("nombre2@nombre.com", "8765", "Nombre", "67");
        Usuario u5 = srvUsu.crear("pepito2@pepito.com", "9876", "Pepito", "55");

        srvUsu.modificar(u1.getId(), u1.getEmail(), u1.getPassword(), u1.getNombre(), "28");
        assertEquals(28, srvUsu.leerUno("zaira2@zaira.a").getEdad());

        srvUsu.modificar(u2.getId(), "aurea2@mene.es", u2.getPassword(), u2.getNombre(), "26");
        assertEquals(u2.getId(), srvUsu.leerUno("aurea2@mene.es").getId());
        assertEquals(26, srvUsu.leerUno("aurea2@mene.es").getEdad());

        srvUsu.modificar(u3.getId(), "german2@caballero", "abcd", "German Caballero", "40");
        assertEquals("abcd", srvUsu.leerUno(u3.getId()).getPassword());
        assertEquals("German Caballero", srvUsu.leerUno("german2@caballero").getNombre());
        assertEquals(40, srvUsu.leerUno("german2@caballero").getEdad());

        srvUsu.modificar(u4.getId(), u4.getEmail(), "33345", u4.getNombre(), "60");
        assertEquals("33345", srvUsu.leerUno(u4.getId()).getPassword());
        assertEquals(60, srvUsu.leerUno("nombre2@nombre.com").getEdad());

        srvUsu.modificar(u5.getId(), u5.getEmail(), u5.getPassword(), "Pepito Grillo", "28");
        assertEquals("Pepito Grillo", srvUsu.leerUno("pepito2@pepito.com").getNombre());
        assertEquals(28, srvUsu.leerUno("pepito2@pepito.com").getEdad());

        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
        srvUsu.eliminar(u3.getId());
        srvUsu.eliminar(u4.getId());
        srvUsu.eliminar(u5.getId());
    }

    @Test
    public void eliminarUsuarios() throws Exception {
        Usuario u1 = srvUsu.crear("zaira5@zaira.a", "1234", "Zaira", "20");
        Usuario u2 = srvUsu.crear("aurea5@aurea.com", "4321", "Aurea", "30");
        Usuario u3 = srvUsu.crear("german5@german.com", "5678", "German", "35");
        Usuario u4 = srvUsu.crear("nombre5@nombre.com", "8765", "Nombre", "67");
        Usuario u5 = srvUsu.crear("pepito5@pepito.com", "9876", "Pepito", "55");

        boolean b1 = srvUsu.eliminar(u1.getId());
        boolean b2 = srvUsu.eliminar(u2.getId());
        boolean b3 = srvUsu.eliminar(u3.getId());
        boolean b4 = srvUsu.eliminar(u4.getId());
        boolean b5 = srvUsu.eliminar(u5.getId());

        assertNull(srvUsu.leerUno("zaira5@zaira.a"));
        assertNull(srvUsu.leerUno(u2.getId()));
        assertNull(srvUsu.leerUno("aurea5@aurea.com"));
        assertNull(srvUsu.leerUno(u4.getId()));
        assertTrue(b1 && b2 && b3 && b4 && b5);
    }

    @Test
    public void listarTodos() throws Exception {
        ArrayList<Usuario> listaCreados = new ArrayList<>();

        listaCreados.add(srvUsu.crear("zaira22@zaira.a", "1234", "Zaira", "20"));
        listaCreados.add(srvUsu.crear("aurea22@aurea.com", "4321", "Aurea", "30"));
        listaCreados.add(srvUsu.crear("german22@german.com", "5678", "German", "35"));

        ArrayList<Usuario> listaTotal = srvUsu.leerTodos();

        for (Usuario usuario1 : listaCreados) {

            if (usuario1 != null && listaTotal.contains(usuario1)) {
                srvUsu.eliminar(usuario1.getId());
            } else {
                fail("No se ha añadido o no se ha encontrado en listaTotal");
            }

        }

    }
}

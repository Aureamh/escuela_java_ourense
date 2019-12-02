package com.vn.ejemplospring.demospring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vn.ejemplospring.demospring.modelo.CuentaBanc;
import com.vn.ejemplospring.demospring.modelo.CuentasDAOpanama;


@RestController
@CrossOrigin(origins = "*")
public class ServicioBancarioREST {
	
	//Nosotros no instanciamos, lo hace Spring.
	//Nosotros no gestionamos la dependencia, lo hace Spring.
	//Nosotros no asignamos el valor, lo hace Spring.
	//ESTO ES LA INYECCIÓN DE DEPENDENCIAS
	@Autowired
	private CuentasDAOpanama repo;
	
	//Nos permite capturar varios métodos HTTP
	@RequestMapping (path = "/cuentas", method = RequestMethod.POST)
	//Solo el método POST
	//@PostMapping
	public  CuentaBanc crearCuentaAingenuo(@RequestBody CuentaBanc cuenta) {
		
		System.out.println(">>> CuentaBanc recibida!" + cuenta.toString());
		return repo.save(cuenta);	
	}
	
	@RequestMapping (path = "/cuentas", method = RequestMethod.GET)
	public List<CuentaBanc> obtenerTodas() {
		System.out.println(">>> GET todas cuentas");
		return repo.findAll();
	}
	
	@DeleteMapping("/cuentas/{id}") //http://localhost:8080/cuentas/2
	public void eliminarCuenta(@PathVariable Integer id) {
		repo.deleteById(id);
		System.out.println(">>> DELETE " +  id);
	}
	
	@PutMapping("/cuentas/{id}")
	public void modificarCuenta(
			@PathVariable Integer id,
			@RequestBody CuentaBanc cuentaModif) {
		if(cuentaModif.getId()== id) {
			repo.save(cuentaModif);
			System.out.println(">>> PUT/Modificar " + id);	
		} else {
			System.out.println(">>>PUT/Modificar " + id
					+ " e " + cuentaModif.getId() + " no son iguales");
		}
	}
	
}

package com.vn.ejemplospring.demospring.modelo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentasDAOpanama 
	extends JpaRepository<CuentaBanc, Integer> {
	
	//List<CuentaBanc> findByIban();

}

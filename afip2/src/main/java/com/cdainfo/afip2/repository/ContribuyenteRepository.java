package com.cdainfo.afip2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdainfo.afip2.dominio.Contribuyente;


public interface ContribuyenteRepository extends JpaRepository<Contribuyente, Long> {
	
	List<Contribuyente> findAllByClaveFiscalLike(Integer claveFiscal);

	List<Contribuyente> findAllByClaveFiscal(Integer claveFiscal);
}

package com.cdainfo.afip2.controller;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdainfo.afip2.dominio.Contribuyente;
import com.cdainfo.afip2.dominio.Impuesto;
import com.cdainfo.afip2.repository.ContribuyenteRepository;
import com.cdainfo.afip2.repository.ImpuestoRepository;


@RestController
public class afipController {
	
	@Autowired
    ImpuestoRepository impuestoRepository;
	
	 @Autowired
		ContribuyenteRepository contribuyenteRepository;
	
	@GetMapping("/impuesto/{id}")
    public Optional<Impuesto> getAllImpuestos(@PathVariable Long id){
        return impuestoRepository.findById(id);
    }
/* Crear las fechas de liquidacion de dichos impuestos pasando las fechas como parametros a los servicios*/	
	 @PostMapping("/impuesto/add")
	 public Impuesto createImpuesto(@RequestBody Impuesto body) {
     return impuestoRepository.save(body);
   }

	 
/* Consultar las fechas de liquidacion de los impuestos pasando una fecha desde hasta una fecha hasta	*/ 
	 @GetMapping("/impuesto/search2/{fecha1}/{fecha2}")
   public List<Impuesto> getImpuestosByFecha(@PathVariable Date fecha1 ,@PathVariable Date fecha2 ) {
       return impuestoRepository.findAllByFechaBetween(fecha1, fecha2);
   }	 
	 	 
	  
/* Listar todos los impuestos por clave fiscal */	 
	 @GetMapping("/contribuyente/claveFiscal")
	    public List<Contribuyente> getClaveFiscal(Integer claveFiscal) {
	    	return contribuyenteRepository.findAllByClaveFiscal(claveFiscal);
	    } 
/* TERMINAR!!
	@PostMapping("/contribuyente/vincular/{clave}/{impuesto}")
	public Contribuyente asociarConImpuesto(@PathVariable Long clave, Long impuesto) {
		//Contribuyente contribuyente = this
	}
	 	*/ 
	
  /*  @GetMapping("/impuesto")
    public Optional<Impuesto> getAllImpuestos(@PathVariable Integer idimpuesto) {
        return impuestoRepository.findAllById(idimpuesto);
   
    
    
    @GetMapping("/impuesto/{idimpuesto}") // muestra impuesto por id
    public Optional<Impuesto> getAllById(@PathVariable Integer idimpuesto) {
        return impuestoRepository.findAllById(idimpuesto);
    }
    
//     */
//    @PostMapping("/impuesto/add")
//    public Impuesto createImpuesto(@RequestBody Impuesto body) {
//      return impuestoRepository.save(body);
//    }
//    
//   
//    @GetMapping("/impuestos/search2/{fecha1}/{fecha2}")
//    public List<Impuesto> getImpuestosByFecha(@PathVariable Date fecha1 ,@PathVariable Date fecha2 ) {
//        return impuestoRepository.findAllByFechaBetween(fecha1, fecha2);
//    }
    
    
    
   /* 
    @GetMapping("/impuestos/claveFiscal")
    public List<ImpuestoClaveFiscalDto> getClaveFiscalContribuyente() {
    	return impuestoRepository.findAllByClaveFiscalContribuyente();
    }
   */
	

}

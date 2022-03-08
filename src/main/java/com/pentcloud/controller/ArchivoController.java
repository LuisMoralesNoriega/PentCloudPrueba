package com.pentcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pentcloud.dto.ArchivoDTO;
import com.pentcloud.service.IArchivoService;

@RestController
@RequestMapping("/archivo")
public class ArchivoController {

	@Autowired
	private IArchivoService service;
	
	//Metodo POST para guardar Archivos
	@PostMapping(value = "/guardarArchivo", produces = "application/json")
	public ResponseEntity<ArchivoDTO> guardarArchivo(@RequestBody ArchivoDTO parchivo ){		
		return new ResponseEntity<ArchivoDTO>(this.service.guardarArchivo(parchivo), HttpStatus.OK);
	}
	
	//Metodo Get para listar los archivos
	@GetMapping(value = "/listarArchivos", produces = "application/json")
	public ResponseEntity<List<ArchivoDTO>> listarArchivo(){
		return new ResponseEntity<List<ArchivoDTO>>(this.service.listarArchivo(), HttpStatus.OK);
	}
	
	
	
	
}

package com.pentcloud.service;

import java.util.List;

import com.pentcloud.dto.ArchivoDTO;

public interface IArchivoService {

	//Metodo para guardar un arthivo
	public ArchivoDTO guardarArchivo(ArchivoDTO parchivo);
	
	//Metodo para listar los archivos
	public List<ArchivoDTO> listarArchivo();
	
}

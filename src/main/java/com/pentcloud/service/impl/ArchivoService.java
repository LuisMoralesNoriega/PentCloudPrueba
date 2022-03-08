package com.pentcloud.service.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.pentcloud.dto.ArchivoDTO;
import com.pentcloud.service.IArchivoService;

@Service
public class ArchivoService implements IArchivoService{
	
	//Variable de la ruta en el archivo application.properties
	@Value("${ruta}")
	private String ruta;

	//Metodo para guardar Archivo
	@Override
	public ArchivoDTO guardarArchivo(ArchivoDTO parchivo) {
				
		try {
            File file = new File(this.ruta + "\\" + parchivo.filename + ".txt");
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(parchivo.text);
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return this.obtenerArchivoId(parchivo.filename + ".txt");
	}
	
	
	// Metodo para listar archivos
	@Override
	public List<ArchivoDTO> listarArchivo() {		
		
		List<ArchivoDTO> lista = new ArrayList<ArchivoDTO>();						
		File carpeta = new File(this.ruta);
		
		for (File file : carpeta.listFiles()) {
			ArchivoDTO ar = this.obtenerArchivoId(file.getName());
			lista.add(ar);
		}
		
		return lista;
	}

	//Metodo para obtener archivo por Nombre
	public ArchivoDTO obtenerArchivoId(String name) {
		
		String contenido = "";
		
		try {
            Scanner input = new Scanner(new File(this.ruta + "\\" + name));            
            while (input.hasNextLine()) {
                String line = input.nextLine();
                contenido = contenido + " " + line;
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
		ArchivoDTO res = new ArchivoDTO();
		res.filename = this.ruta + "\\" + name;
		res.text = contenido; 
		
		return res;
	}
	
	
}

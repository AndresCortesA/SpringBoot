package com.bolsadeideas.springboot.di.app.models.service;

//import org.springframework.stereotype.Component;

//@Component("miServicioComplejo")
public class MiServicioComplejo implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algún proceso importante complicado...";
	}
	
}

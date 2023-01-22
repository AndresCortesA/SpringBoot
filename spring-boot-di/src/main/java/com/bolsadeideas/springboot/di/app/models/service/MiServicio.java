package com.bolsadeideas.springboot.di.app.models.service;

//import org.springframework.context.annotation.Primary;
//import org.springframework.stereotype.Component;

//@Primary
//@Component("miServicioSimple")
public class MiServicio implements IServicio{

	@Override
	public String operacion() {
		return "ejecutando algún proceso importante simple ...";
	}
	
}

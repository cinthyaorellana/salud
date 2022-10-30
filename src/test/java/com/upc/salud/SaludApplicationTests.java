package com.upc.salud;

import com.upc.salud.entidades.CentroSalud;
import com.upc.salud.negocio.ICentroSaludNegocio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SaludApplicationTests {

	@Autowired
	private ICentroSaludNegocio centroSaludNegocio;

	@Test
	void contextLoads() {
	}

	@Test
	void testRegistro(){
		CentroSalud centroSalud = new CentroSalud();
		centroSalud.setNombre("CLINICA JESUS DEL NORTE");
		centroSalud.setTipo("CLINICA");
		centroSalud.setCalificacionInfraestructura(85);
		centroSalud.setCalificacionServicios(85);
		centroSalud.setAmbulancia(1);
		centroSaludNegocio.registrar(centroSalud);
	}
}

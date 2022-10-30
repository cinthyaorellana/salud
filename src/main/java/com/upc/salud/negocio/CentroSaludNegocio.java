package com.upc.salud.negocio;

import com.upc.salud.entidades.CentroSalud;
import com.upc.salud.repositorio.ICentroSaludRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentroSaludNegocio implements ICentroSaludNegocio {
    @Autowired
    ICentroSaludRepositorio iCentroSaludRepositorio;

    @Override
    public CentroSalud registrar(CentroSalud centroSalud) {
        return iCentroSaludRepositorio.save(centroSalud);
    }

    @Override
    public double calcularCalificacion(CentroSalud centroSalud) {
        return centroSalud.getCalificacionInfraestructura()*0.35+centroSalud.getCalificacionServicios()*0.65;
    }

    @Override
    public String obtenerResultadoFinal(CentroSalud centroSalud) {
        double calificacion = calcularCalificacion(centroSalud);
        String resultado = "DESAPROBADO";
        if (calificacion >= 80) {
            resultado="APROBADO";
        }
        return resultado;
    }

    @Override
    public List<CentroSalud> listado() {
        return iCentroSaludRepositorio.findAll();
    }

    @Override
    public List<CentroSalud> listadoConCalificaciones() {
        return iCentroSaludRepositorio.findAll();
    }

    @Override
    public String obtenerResultadoFinal(Long codigoCentro) throws Exception {
        CentroSalud centroSalud = buscar(codigoCentro);
        return obtenerResultadoFinal(centroSalud);
    }

    @Override
    public CentroSalud buscar(Long codigoCentro) throws Exception {
        return iCentroSaludRepositorio.findById(codigoCentro).orElseThrow(
                () -> new Exception("No se encontró entidad"));
    }

    @Override
    public CentroSalud actualizarSalud(CentroSalud centroSalud) throws Exception {
        buscar(centroSalud.getCodigo());
        return iCentroSaludRepositorio.save(centroSalud);
    }
}

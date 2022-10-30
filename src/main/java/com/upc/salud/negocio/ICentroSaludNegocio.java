package com.upc.salud.negocio;

import com.upc.salud.entidades.CentroSalud;

import java.util.List;

public interface ICentroSaludNegocio {
    public CentroSalud registrar(CentroSalud centroSalud);
    public double calcularCalificacion(CentroSalud centroSalud);
    public String obtenerResultadoFinal(CentroSalud centroSalud) throws Exception ;
    public List<CentroSalud> listado();
    public List<CentroSalud> listadoConCalificaciones();
    public String obtenerResultadoFinal(Long codigoCentro) throws Exception;
    public CentroSalud buscar(Long codigoCentro) throws Exception;
    public CentroSalud actualizarSalud(CentroSalud centroSalud) throws Exception;
}

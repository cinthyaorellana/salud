package com.upc.salud.repositorio;

import com.upc.salud.entidades.CentroSalud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICentroSaludRepositorio extends JpaRepository<CentroSalud,Long> {

}

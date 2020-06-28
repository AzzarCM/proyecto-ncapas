package com.uca.capas.proyecto.repositories;

import com.uca.capas.proyecto.domain.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpedienteRepo extends JpaRepository<Expediente, Integer> {
}

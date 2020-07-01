package com.uca.capas.proyecto.repositories;

import com.uca.capas.proyecto.domain.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepo extends JpaRepository<Departamento, Integer> {
}

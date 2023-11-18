// RegistroVehiculoRepositorio.java
package com.vehiculos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vehiculos.modelo.RegistroVehiculo;

@Repository
public interface RegistroVehiculoRepositorio extends JpaRepository<RegistroVehiculo, Long> {

}

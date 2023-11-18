package com.vehiculos.servicio;

import java.util.List;

import com.vehiculos.modelo.RegistroVehiculo;

public interface RegistroVehiculoServicio {

    List<RegistroVehiculo> listarRegistros();

    RegistroVehiculo obtenerRegistro(Long id);

    void guardarRegistro(RegistroVehiculo registro);

    void actualizarRegistro(RegistroVehiculo registro);

    void eliminarRegistro(Long id);
}

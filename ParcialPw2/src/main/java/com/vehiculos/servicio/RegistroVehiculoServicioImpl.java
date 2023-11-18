package com.vehiculos.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vehiculos.modelo.RegistroVehiculo;
import com.vehiculos.repositorio.RegistroVehiculoRepositorio;

@Service
public class RegistroVehiculoServicioImpl implements RegistroVehiculoServicio {

    @Autowired
    private RegistroVehiculoRepositorio registroRepositorio;

    @Override
    public List<RegistroVehiculo> listarRegistros() {
        return registroRepositorio.findAll();
    }

    @Override
    public RegistroVehiculo obtenerRegistro(Long id) {
        return registroRepositorio.findById(id).orElse(null);
    }

    @Override
    public void guardarRegistro(RegistroVehiculo registro) {
        registroRepositorio.save(registro);
    }

    @Override
    public void actualizarRegistro(RegistroVehiculo registro) {
        // Implementa la lógica para actualizar el registro
        registroRepositorio.save(registro);
    }

    @Override
    public void eliminarRegistro(Long id) {
        registroRepositorio.deleteById(id);
    }
}

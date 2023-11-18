package com.vehiculos.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vehiculos.modelo.RegistroVehiculo;
import com.vehiculos.servicio.RegistroVehiculoServicio;

@Controller
@RequestMapping("/registros")
public class RegistroVehiculoControlador {

    @Autowired
    private RegistroVehiculoServicio registroServicio;

    @ModelAttribute("registro")
    public RegistroVehiculo retornarNuevoRegistroVehiculo() {
        return new RegistroVehiculo();
    }

    @GetMapping
    public String mostrarRegistros(Model modelo) {
        List<RegistroVehiculo> registros = registroServicio.listarRegistros();
        modelo.addAttribute("registros", registros);
        return "registros";
    }

    @GetMapping("/{id}")
    public String verDetalleRegistro(@PathVariable Long id, Model modelo) {
        RegistroVehiculo registro = registroServicio.obtenerRegistro(id);
        modelo.addAttribute("registro", registro);
        return "detalleRegistro";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoRegistro() {
        return "formularioRegistro";
    }

    @PostMapping("/nuevo")
    public String guardarNuevoRegistro(@ModelAttribute("registro") RegistroVehiculo registro) {
        registroServicio.guardarRegistro(registro);
        return "redirect:/registros";
    }

    @GetMapping("/{id}/editar")
    public String mostrarFormularioEditarRegistro(@PathVariable Long id, Model modelo) {
        RegistroVehiculo registro = registroServicio.obtenerRegistro(id);
        modelo.addAttribute("registro", registro);
        return "formularioRegistro";
    }

    @PostMapping("/{id}/editar")
    public String actualizarRegistro(@PathVariable Long id, @ModelAttribute("registro") RegistroVehiculo registro) {
        registro.setId(id);
        registroServicio.actualizarRegistro(registro);
        return "redirect:/registros";
    }

    @GetMapping("/{id}/eliminar")
    public String eliminarRegistro(@PathVariable Long id) {
        registroServicio.eliminarRegistro(id);
        return "redirect:/registros";
    }
}

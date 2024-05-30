package com.ejemplo.demo.thymeleaf.saludo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// Controlador de interfaz de usuario
// - Recibe la solicitud del usuario
// - Invoca servicios de lógica de negocio
// - Obtiene / Construye el modelo que se intercambia con la Vista
// - Selecciona la vista a mostar

@Controller
public class SaludoController {

    @GetMapping("/saludo")
    public String Saludo(Model model, @RequestParam(defaultValue="Mundo") String nombre) {

        // invoca servicios de lógica de negocio
        // N/A

        // construye el modelo
        model.addAttribute("nombre", nombre);

        // selecciona la vista a mostrar
        return "/saludo/index";
    }

}
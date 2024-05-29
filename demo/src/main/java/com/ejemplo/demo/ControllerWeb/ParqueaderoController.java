package com.ejemplo.demo.ControllerWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ejemplo.demo.modelo.Parqueadero;
import com.ejemplo.demo.dataAccess.ParqueaderoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/parqueaderos")
public class ParqueaderoController {

    @Autowired
    private ParqueaderoRepository parqueaderoRepository;

    @GetMapping()
    public List<Parqueadero> obtenerTodos() {
        return parqueaderoRepository.findAll();
    }

    @PostMapping()
    public Parqueadero agregarParqueadero(@RequestBody Parqueadero parqueadero) {
        return parqueaderoRepository.save(parqueadero);
    }

    @GetMapping("/{id}")
    public Parqueadero obtenerPorId(@PathVariable Integer id) {
        return parqueaderoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Parqueadero actualizarParqueadero(@PathVariable Integer id, @RequestBody Parqueadero parqueadero) {
        parqueadero.setId(id);
        return parqueaderoRepository.save(parqueadero);
    }

    @DeleteMapping("/{id}")
    public void eliminarParqueadero(@PathVariable Integer id) {
        parqueaderoRepository.deleteById(id);
    }
}

package com.ejemplo.demo.ControllerWeb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ejemplo.demo.modelo.Evento;
import com.ejemplo.demo.dataAccess.EventoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/eventos")
public class EventoRestController {

    @Autowired
    private EventoRepository eventoRepository;

    @GetMapping()
    public List<Evento> obtenerTodos() {
        return eventoRepository.findAll();
    }

    @PostMapping()
    public Evento agregarEvento(@RequestBody Evento evento) {
        return eventoRepository.save(evento);
    }

    @GetMapping("/{id}")
    public Evento obtenerPorId(@PathVariable Integer id) {
        return eventoRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Evento actualizarEvento(@PathVariable Integer id, @RequestBody Evento evento) {
        evento.setId(id);
        return eventoRepository.save(evento);
    }

    @DeleteMapping("/{id}")
    public void eliminarEvento(@PathVariable Integer id) {
        eventoRepository.deleteById(id);
    }
}

package sis414.peliculas_api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sis414.peliculas_api.model.Pelicula;
import sis414.peliculas_api.service.PeliculaService;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    @Autowired
    private PeliculaService service;

    @GetMapping
    public List<Pelicula> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Optional<Pelicula> buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Pelicula guardar(@RequestBody Pelicula pelicula) {
        return service.guardar(pelicula);
    }

    @PutMapping("/{id}")
    public Pelicula actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
        pelicula.setId(id);
        return service.guardar(pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}
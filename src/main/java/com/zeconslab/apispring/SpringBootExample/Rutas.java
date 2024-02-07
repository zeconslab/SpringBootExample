package com.zeconslab.apispring.SpringBootExample;

import com.zeconslab.apispring.SpringBootExample.models.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Rutas {

    private final Logger log = LoggerFactory.getLogger(Rutas.class);
    @GetMapping("/welcome")
    String welcome(){
        log.info("Entro a la pagina de bienvenida");
        return "Pagina de bienvenida";
    }

    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leerLibro(@PathVariable int id, @PathVariable String editorial){
        log.info("Se leyo el Libro: [{}] de la Editorial [{}]", id, editorial );
        return "Leyendo libro con el ID: " + id + " de la Editorial: " + editorial;
    }

    @GetMapping("/libro/{id}")
    String leerLibro2(@PathVariable int id, @RequestParam String params){
        log.info("Se leyo el Libro: [{}], con Params [{}]", id, params);
        return "Leyendo libro con el ID: " + id + " con Params" + params;
    }

    @PostMapping("/libro")
    String guardarLibro (@RequestBody Libro libro) {
        log.debug("Se lee Libro [{}] de Editorial [{}]", libro.nombre , libro.editorial);
        return "Libro guardado";
    }
}

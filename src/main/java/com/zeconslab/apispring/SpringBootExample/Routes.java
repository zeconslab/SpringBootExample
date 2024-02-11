package com.zeconslab.apispring.SpringBootExample;

import com.zeconslab.apispring.SpringBootExample.models.Libro;
import com.zeconslab.apispring.SpringBootExample.models.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Routes {

    private final Logger log = LogManager.getLogger(Routes.class);
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

    @GetMapping("/animal/{id}")
    public ResponseEntity<String> obtenerAnimal(@PathVariable String id) {
        int i = Integer.parseInt(id);
        if (i == 0 ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Lamentamos informar que su solicitud no es posible");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Respuesta Ok");
    }

    @GetMapping("/calcular/{numero}")
    public int getCalculo (@PathVariable int numero){
        throw new NullPointerException("Error el calcular el numero");
    }

    @GetMapping("/userData")
    public ResponseEntity<String> getUserData() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .header("Content-Type", "application/json")
                .body("{\"name\" : \"mary \"}");
    }

    @GetMapping("/userData/v2")
    public Map<String, Map<String, Object>> getUserDatav2 () {
        return Map.of("User", Map.of("Name", "Mary", "age", 25));
    }

    @GetMapping("/userData/v3/{edad}")
    public Map<String , UserData> getUserDatav3(@PathVariable int edad) {
        return Map.of("User", new UserData("Marry", edad));
    }

}

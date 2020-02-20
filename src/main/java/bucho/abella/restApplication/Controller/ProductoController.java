package bucho.abella.restApplication.Controller;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import bucho.abella.restApplication.Model.Producto;
import bucho.abella.restApplication.Model.ProductoRepositorio;

/**
 * ProductoController
 */
@RestController // devuelve JSON (GetMapping)
@RequestMapping(value = "/api/productos/") // A partir de esta ruta sacaremos todo lo que queremos hacer de productos

public class ProductoController {

    @Autowired // Inyecto La Interface ( Clase)
    ProductoRepositorio pr;

    @GetMapping("/listar")
    @ResponseBody // cuando devuelvo String puro
    public Iterable<Producto> getAllProductos() { // devuelve un (iterator) colección de <Productos>
        return pr.findAll(); // select * from productos Devuelve un JSON con todos los productos
    }

    @GetMapping("{id}/")
    public Producto getProducto(@PathVariable("id") Long id) {
        /*
         * @PathVariable Anotación que indica que un parámetro de método debe estar
         * vinculado a una variable de plantilla URI. Compatible con los métodos de
         * manejador anotado RequestMapping.
         * 
         */

        try {
            return pr.findById(id).get();
        } catch (NoSuchElementException e) {
            return null;
        }

    }

    @PostMapping("/")
    @ResponseBody // cuando devuelvo String puro
    public Object createProduct(@RequestBody Producto p) { // devuelve un (iterator) colección de <Productos>

        p = pr.save(p);// El save de la Interface CrudRepository

        System.out.println(p);

        return p; // select * from productos
    }

    @GetMapping("/js")
    @ResponseBody // cuando devuelvo String puro
    public String getProductosjs() {
        return String.valueOf(pr.count());

    }

}

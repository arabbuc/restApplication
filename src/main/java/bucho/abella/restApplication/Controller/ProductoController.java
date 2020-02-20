package bucho.abella.restApplication.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

import bucho.abella.restApplication.Model.ProductoRepositorio;

/**
 * ProductoController
 */
@RestController //devuelve JSON (GetMapping)
public class ProductoController {

    @Autowired //Inyecto La Interface
    ProductoRepositorio pr;
    
    @GetMapping("/productos") 
    @ResponseBody // cuando devuelvo String puro
    public String getProductos() {
        return String.valueOf(pr.count()) ;
    }
        @GetMapping("/productos_js") 
        @ResponseBody // cuando devuelvo String puro
        public String getProductosjs() {
            return String.valueOf(pr.count()) ;
    
        }

    
}

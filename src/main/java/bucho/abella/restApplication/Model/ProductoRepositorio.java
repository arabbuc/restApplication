 package bucho.abella.restApplication.Model;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.data.repository.CrudRepository;

public interface ProductoRepositorio extends CrudRepository<Producto,Id>{

  
}
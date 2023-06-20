package cl.awakelab.apirest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import cl.awakelab.apirest.models.entity.Cliente;
import cl.awakelab.apirest.models.services.IClienteService;

@RestController
@RequestMapping("/api") 
public class ClienteRestController {

  @Autowired
  private IClienteService clienteService;
  
  // localhost:8080/api/clientes
  @GetMapping("/clientes")
  @ResponseStatus(HttpStatus.OK)
  public List<Cliente> index() {
    return clienteService.findAll();
  }
  
  //localhost:8080/api/clientes/1
  // Por id
  
  @GetMapping("/clientes/{id}")
  public Optional<Cliente> show(@PathVariable Long id) {
    Optional<Cliente> optionalCliente = clienteService.findById(id);
    
    if(!optionalCliente.isPresent()) throw new ClienteNotFoundException("No existe un cliente con ese id: " +  id);
    
    return optionalCliente;
  }
  
  //localhost:8080/api/clientes
  @PostMapping("/clientes")
  @ResponseStatus(HttpStatus.CREATED)
  public Cliente create(@RequestBody Cliente cliente) {
    return clienteService.save(cliente);
  }

}

class ClienteNotFoundException extends RuntimeException {
 
  public ClienteNotFoundException(String message) {
    super(message);
  }
}

package com.ks.factura.controller;

import com.ks.factura.entity.Cliente;
import com.ks.factura.entity.Sucursal;
import com.ks.factura.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;
    @GetMapping
    public ResponseEntity<?> getAllCliente()
    {
        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> saveCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<>(clienteService.save(cliente),
                HttpStatus.CREATED);
    }

    @DeleteMapping("{clienteId}")
    public ResponseEntity<?> deleteCliente(@PathVariable Long clienteId){
        clienteService.delete(clienteId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @GetMapping("/{clienteid}")
    public Cliente findByClienteId(@PathVariable("clienteid") Long clienteid) {
        return clienteService.findClienteByid(clienteid);
    }

    @GetMapping("/sucursal/{clienteid}")
    public List<Sucursal> findByClienteSucursalId(@PathVariable("clienteid") Long clienteid) {
        return clienteService.findClienteBySucursalesid(clienteid);
    }





}

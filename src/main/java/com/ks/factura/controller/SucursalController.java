package com.ks.factura.controller;

import com.ks.factura.entity.Sucursal;
import com.ks.factura.service.SucursalService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sucursales")
public class SucursalController {

    @Autowired
    public SucursalService sucursalService;

    @GetMapping(name = "/list")
    public ResponseEntity<List<Sucursal>> getSucursales(){
        var sucursales= sucursalService.findAll();
        return new ResponseEntity<>(sucursales, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Sucursal> saveDepartment(@RequestBody Sucursal sucursal) {
        var sucursalSaved = sucursalService.save(sucursal);
        return new ResponseEntity<>(sucursalSaved, HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<Sucursal> deleteDepartment(@RequestBody Sucursal sucursal) {
        sucursalService.delete(sucursal);
        return new ResponseEntity<>(sucursal, HttpStatus.OK);
    }

}

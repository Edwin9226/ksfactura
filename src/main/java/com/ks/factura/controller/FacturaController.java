package com.ks.factura.controller;

import com.ks.factura.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(name = "/factura")
public class FacturaController {


    @Autowired
    private ClienteService clienteService;



    
}

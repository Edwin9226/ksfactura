package com.ks.factura;

import com.ks.factura.entity.Cliente;
import com.ks.factura.entity.Factura;
import com.ks.factura.entity.Sucursal;
import com.ks.factura.repository.ClienteRepository;
import com.ks.factura.repository.SucursalRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

@SpringBootTest
public class SucursalRepositoryTest {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void testSaveSucursal() throws ParseException {

        Date myDate = new Date();


        Cliente cliente = new Cliente();
        cliente.setTipo_id("DNI");
        cliente.setNumero_id("1003863691");
        cliente.setNombre("Edwin");
        cliente.setApellido("Pinchao");
        cliente.setEmail("miguepinchaop1992@gmail.com");
        cliente.setCelular("0967179713");
        cliente.setCreateAt(myDate);
        Sucursal sucursal1 = new Sucursal();
        sucursal1.setProvincia("Imbabura");
        sucursal1.setCiudad("Ibarra");
        sucursal1.setDireccion("5 de junio");

        cliente.add(sucursal1);

        Sucursal sucursal2 = new Sucursal();
        sucursal2.setProvincia("Carchi");
        sucursal2.setCiudad("Mira");
        sucursal2.setDireccion("via ");
        cliente.add(sucursal2);

        Factura factura= new Factura();

        clienteRepository.save(cliente);
    }
}

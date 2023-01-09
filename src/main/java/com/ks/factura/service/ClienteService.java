package com.ks.factura.service;

import com.ks.factura.entity.Cliente;
import com.ks.factura.entity.Factura;
import com.ks.factura.entity.Producto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    public List<Cliente> findAll();

    public Page<Cliente> findAll(Pageable pageable);

    void save(Cliente cliente);

    public Optional<Cliente> findOne(Long id);

    public void delete(Long id);

    public List<Producto> findByNombre(String term);

    public void saveFactura(Factura factura);

    public Producto findProductoByid(Long id);

    public Factura findFacturaById(Long id);

    public void deleteFactura(Long id);

    public Factura fetchByIdWithItemFacturaWithProducto(Long id);

    public Cliente fetchByIdWithFacturas(Long id);
}
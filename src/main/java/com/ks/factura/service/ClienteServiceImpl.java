package com.ks.factura.service;

import com.ks.factura.entity.Cliente;
import com.ks.factura.entity.Factura;
import com.ks.factura.entity.Producto;
import com.ks.factura.entity.Sucursal;
import com.ks.factura.repository.ClienteRepository;
import com.ks.factura.repository.FacturaRepository;
import com.ks.factura.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl  implements  ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private FacturaRepository facturaRepository;


    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Page<Cliente> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> findOne(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public List<Producto> findByNombre(String term) {
        return productoRepository.findByNombre(term);
    }

    @Override
    public void saveFactura(Factura factura) {
        facturaRepository.save(factura);
    }


    @Override
    public Cliente findClienteByid(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public List<Sucursal> findClienteBySucursalesid(Long id) {
        Optional<Cliente> client= clienteRepository.findById(id);

        return client.get().getSucursales();
    }
    @Override
    public Producto findProductoByid(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Factura findFacturaById(Long id) {
        return facturaRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public Factura fetchByIdWithItemFacturaWithProducto(Long id) {
        return facturaRepository.fetchByIdWithItemFacturaWithProducto(id);
    }

    @Override
    public Cliente fetchByIdWithFacturas(Long id) {
        return clienteRepository.fetchByIdWithFacturas(id);
    }
}

package com.ks.factura.service;

import com.ks.factura.entity.Sucursal;
import com.ks.factura.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SucursalServiceImpl implements SucursalService{

    @Autowired
    private SucursalRepository sucursalRepository;
    @Override
    public List<Sucursal> findAll() {
        return sucursalRepository.findAll();
    }

    @Override
    public Sucursal findById(Long id) {
        return sucursalRepository.findById(id).orElseThrow();
    }

    @Override
    public Sucursal save(Sucursal sucursal) {
        return sucursalRepository.save(sucursal);
    }

    @Override
    public void delete(Sucursal sucursal) {
        sucursalRepository.delete(sucursal);
    }
}

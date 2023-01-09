package com.ks.factura.service;

import com.ks.factura.entity.Sucursal;

import java.util.List;

public interface SucursalService {

    public List<Sucursal> findAll();
    public Sucursal findById(Long id);
    public Sucursal save (Sucursal sucursal);
    public void delete(Sucursal sucursal);




}

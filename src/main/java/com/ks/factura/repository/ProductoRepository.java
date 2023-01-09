package com.ks.factura.repository;

import com.ks.factura.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository  extends JpaRepository<Producto, Long> {


    @Query("SELECT p FROM Producto p WHERE p.nombre like %?1%")
    public List<Producto> findByNombre(String term);

}

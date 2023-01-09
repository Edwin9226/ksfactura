package com.ks.factura.repository;

import com.ks.factura.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
    @Query("SELECT f FROM Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto p WHERE f.id=?1")
    public Factura fetchByIdWithItemFacturaWithProducto(Long id);
}


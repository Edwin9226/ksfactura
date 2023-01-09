package com.ks.factura.repository;

import com.ks.factura.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("select c from Cliente c left join fetch c.facturas f where c.id = ?1")
    public Cliente fetchByIdWithFacturas(Long id);
}

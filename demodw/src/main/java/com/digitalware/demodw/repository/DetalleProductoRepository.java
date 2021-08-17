package com.digitalware.demodw.repository;


import com.digitalware.demodw.models.Detalle_Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleProductoRepository extends JpaRepository<Detalle_Producto, Integer> {}

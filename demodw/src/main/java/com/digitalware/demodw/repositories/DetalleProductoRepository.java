package com.digitalware.demodw.repositories;


import com.digitalware.demodw.models.Detalle_Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DetalleProductoRepository extends JpaRepository<Detalle_Producto, Integer> {
    
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM Detalle_Producto d WHERE d.id =:id")
    public int deletesById(@Param("id") int id);
}

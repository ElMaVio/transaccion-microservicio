package com.transaccion_services.transaccion_services.repositories;


import com.transaccion_services.transaccion_services.models.entities.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaccionRepository extends JpaRepository<Transaccion,Integer> {

}

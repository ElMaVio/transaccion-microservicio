package com.transaccion_services.transaccion_services.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Transaccion")
public class Transaccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transaccion;

    @Column(nullable = false)
    private int id_billetera;

    @Column(nullable = false)
    private int id_apuesta;

    @Column(nullable = false)
    private String tipo_transaccion;

    @Column(nullable = false)
    private double monto;

    @Column(nullable = false)
    private double saldo_anterior;

    @Column(nullable = false)
    private double saldo_posterior;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String metodo_pago;

    @Column(nullable = false)
    private Date fecha_creacion;




}

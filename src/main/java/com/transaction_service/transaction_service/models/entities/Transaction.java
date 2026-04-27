package com.transaction_service.transaction_service.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Transaccion")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_transaccion;

    @Column(nullable = false)
    private int billeteras_id_billetera;

    @Column(nullable = false)
    private int apuestas_id_apuesta;

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
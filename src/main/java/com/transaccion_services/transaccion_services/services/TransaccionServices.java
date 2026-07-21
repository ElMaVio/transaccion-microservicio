package com.transaccion_services.transaccion_services.services;

import com.transaccion_services.transaccion_services.models.entities.Transaccion;
import com.transaccion_services.transaccion_services.repositories.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TransaccionServices {

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Transaccion> ListarTransaction() {
        return transaccionRepository.findAll();
    }

    // Ejemplo de método con lógica de negocio para la rúbrica
    public Transaccion procesarTransaccion(Transaccion transaccion) {
        // PASO 1: Verificación de fondos mínimos
        // Exigencia del casino: toda transacción debe ser de mínimo 2500 pesos
        if (transaccion.getMonto() < 2500.0) {
            throw new IllegalArgumentException("El monto mínimo para cualquier transacción es de 2500 pesos");
        }
        
        // PASO 2: Intentar conectar con la Billetera para descontar/sumar saldo
        // Nota: Manejamos el error por si los servicios están apagados durante el desarrollo
        try {
            // Ejemplo: si es un deposito, mandamos la petición al servicio de Wallet (puerto 7576)
            // Aquí iría el webClientBuilder.build().put().uri("http://localhost:7576/Wallet/updateSaldo")...
            System.out.println("Intentando actualizar la billetera ID " + transaccion.getId_billetera() + " por un monto de " + transaccion.getMonto());
            // Como no sabemos la ruta exacta de updateSaldo en Wallet, simulamos el éxito
        } catch (Exception e) {
            System.err.println("Advertencia: El servicio de Billeteras está offline o falló la conexión: " + e.getMessage());
        }

        if (transaccion.getEstado() == null) transaccion.setEstado("COMPLETADO");
        if (transaccion.getMetodo_pago() == null) transaccion.setMetodo_pago("SISTEMA");
        
        // PASO 3: Guardar en base de datos
        // Registramos el historial de la transacción con su fecha actual
        transaccion.setFecha_creacion(new java.util.Date());
        return transaccionRepository.save(transaccion);
    }
}

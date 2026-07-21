package com.transaccion_services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.transaccion_services.transaccion_services.services.TransaccionServices;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.transaccion_services.transaccion_services.models.entities.Transaccion;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TransaccionServicesTest {

    // Usamos @Mock para simular dependencias (como Repositorios).
    // Esto crea un objeto falso ("mock") de la dependencia para que no toquemos la base de datos real.
    @Mock
    private com.transaccion_services.transaccion_services.repositories.TransaccionRepository transaccionRepository;

    // Usamos @InjectMocks para crear una instancia real del servicio que vamos a testear.
    // Mockito automáticamente inyectará los @Mock que definimos arriba dentro de este servicio.
    @InjectMocks
    private TransaccionServices transaccionServices;

    // Usamos @BeforeEach para indicar que este método debe ejecutarse ANTES de cada @Test.
    // Sirve para inicializar los mocks y preparar el entorno (ej: limpiar datos o configurar comportamientos).
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testProcesarTransaccionMontoMinimo() {
        // PASO 1: Configuramos un mock (simulación) de una transacción
        Transaccion transaccion = new Transaccion();
        transaccion.setMonto(1000.0); // Monto menor al mínimo exigido

        // PASO 2: Intentamos procesarla y capturamos el error
        Exception exception = org.junit.jupiter.api.Assertions.assertThrows(
            IllegalArgumentException.class, 
            () -> transaccionServices.procesarTransaccion(transaccion)
        );

        // PASO 3: Verificamos que el mensaje de error sea correcto y entendible
        org.junit.jupiter.api.Assertions.assertEquals(
            "El monto mínimo para cualquier transacción es de 2500 pesos", 
            exception.getMessage(),
            "El servicio debería rechazar transacciones menores a 2500 pesos."
        );
    }
}

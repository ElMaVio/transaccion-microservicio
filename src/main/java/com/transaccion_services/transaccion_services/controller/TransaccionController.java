package com.transaccion_services.transaccion_services.controller;

import com.transaccion_services.transaccion_services.models.entities.Transaccion;
import com.transaccion_services.transaccion_services.services.TransaccionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Transaccion")
@org.springframework.web.bind.annotation.CrossOrigin(origins = "*")
public class TransaccionController {

    @Autowired
    private TransaccionServices TransaccionServices;

    @GetMapping
    public List<Transaccion> ListarTransaccion() {
        return TransaccionServices.ListarTransaction();
    }

    @PostMapping
    public Transaccion crearTransaccion(@RequestBody Transaccion nuevaTransaccion) {
        return TransaccionServices.procesarTransaccion(nuevaTransaccion);
    }
}

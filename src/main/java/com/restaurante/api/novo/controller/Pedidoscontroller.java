package com.restaurante.api.novo.controller;

import com.restaurante.api.novo.mapper.Pedidomapper;
import com.restaurante.api.novo.service.Pedidoservices;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Pedidoscontroller {

    private final Pedidoservices services;
    private final Pedidomapper mapper;

    public Pedidoscontroller(Pedidoservices services, Pedidomapper mapper) {
        this.services = services;
        this.mapper = mapper;
    }
}

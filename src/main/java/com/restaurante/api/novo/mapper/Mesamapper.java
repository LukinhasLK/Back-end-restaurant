package com.restaurante.api.novo.mapper;
import com.restaurante.api.novo.dto.response.MesaResponse;
import com.restaurante.api.novo.model.MesaModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mesamapper {

    public MesaResponse toResponse(MesaModel mesa) {

        return new MesaResponse(mesa.getId(), mesa.getNumero(), mesa.getCapacidade(), mesa.getStatusMesa());
    }

    public List<MesaResponse> toResponselist(List<MesaModel> mesa) {

        return mesa.stream().map(this::toResponse).toList();
    }
}

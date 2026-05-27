package com.restaurante.api.novo.service;

import com.restaurante.api.novo.dto.request.MesaRequest;
import com.restaurante.api.novo.enuns.StatusMesa;
import com.restaurante.api.novo.model.MesaModel;
import com.restaurante.api.novo.repository.MesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaServices {

    private final MesaRepository repository;

    public MesaServices(MesaRepository repository) {
        this.repository = repository;
    }

    public List<MesaModel> list() {
        return repository.findAll();
    }

    public MesaModel mesaByid(Long id) {

        return repository.findById(id).orElseThrow(() -> new RuntimeException("mesa não encontrada"));
    }

    public MesaModel cadastrar(MesaRequest dto) {

        MesaModel mesa = new MesaModel();

        mesa.setNumero(dto.numero());
        mesa.setCapacidade(dto.capacidade());
        mesa.setStatusMesa(StatusMesa.LIVRE);

        return repository.save(mesa);
    }

    public MesaModel alterar(Long id, MesaRequest dto) {

        MesaModel mesa = repository.findById(id).orElseThrow(() -> new RuntimeException("mesa nao encontrada"));


        mesa.setNumero(dto.numero());
        mesa.setCapacidade(dto.capacidade());

        return repository.save(mesa);
    }

    public MesaModel livre(Long id) {

        MesaModel mesa = repository.findById(id).orElseThrow(() -> new RuntimeException("mesa nao encontrada"));

        mesa.setStatusMesa(StatusMesa.LIVRE);

        return repository.save(mesa);
    }


    public MesaModel ocupado(Long id) {

        MesaModel mesa = repository.findById(id).orElseThrow(() -> new RuntimeException("mesa nao encontrada"));

        mesa.setStatusMesa(StatusMesa.OCUPADO);

        return repository.save(mesa);
    }

    public void deletar(Long id) {

        MesaModel mesa = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("mesa nao encontrada"));

        repository.delete(mesa);

    }
}

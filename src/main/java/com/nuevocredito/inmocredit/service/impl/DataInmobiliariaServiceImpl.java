package com.nuevocredito.inmocredit.service.impl;

import com.nuevocredito.inmocredit.entities.DataInmobiliaria;
import com.nuevocredito.inmocredit.repository.IDataInmobiliariaRepository;
import com.nuevocredito.inmocredit.service.IDataInmobiliarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class DataInmobiliariaServiceImpl implements IDataInmobiliarioService {

    private final IDataInmobiliariaRepository dataInmobiliariaRepository;

    public DataInmobiliariaServiceImpl(IDataInmobiliariaRepository dataInmobiliariaRepository) {
        this.dataInmobiliariaRepository = dataInmobiliariaRepository;
    }


    @Override
    public DataInmobiliaria save(DataInmobiliaria dataInmobiliaria) throws Exception {
        return dataInmobiliariaRepository.save(dataInmobiliaria);
    }

    @Override
    public void delete(Long id) throws Exception {
        dataInmobiliariaRepository.deleteById(id);
    }

    @Override
    public List<DataInmobiliaria> getAll() throws Exception {
        return dataInmobiliariaRepository.findAll();
    }

    @Override
    public Optional<DataInmobiliaria> getById(Long id) throws Exception {
        return dataInmobiliariaRepository.findById(id);
    }
}

package com.nuevocredito.inmocredit.service.impl;

import com.nuevocredito.inmocredit.entities.EntidadFinanciera;
import com.nuevocredito.inmocredit.repository.IEntidadFinancieraRepository;
import com.nuevocredito.inmocredit.service.IEntidadFinancieraService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class EntidadFinancieraImpl implements IEntidadFinancieraService {
    private final IEntidadFinancieraRepository entidadFinancieraRepository;

    public EntidadFinancieraImpl(IEntidadFinancieraRepository entidadFinancieraRepository) {
        this.entidadFinancieraRepository = entidadFinancieraRepository;
    }

    @Override
    @Transactional
    public EntidadFinanciera save(EntidadFinanciera entidadFinanciera) throws Exception {
        return entidadFinancieraRepository.save(entidadFinanciera);
    }

    @Override
    @Transactional
    public void delete(Long id) throws Exception {
        entidadFinancieraRepository.deleteById(id);
    }

    @Override
    public List<EntidadFinanciera> getAll() throws Exception {
        return entidadFinancieraRepository.findAll();
    }

    @Override
    public Optional<EntidadFinanciera> getById(Long id) throws Exception {
        return entidadFinancieraRepository.findById(id);
    }
}

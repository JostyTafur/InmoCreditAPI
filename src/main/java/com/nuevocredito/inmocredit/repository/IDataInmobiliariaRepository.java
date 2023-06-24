package com.nuevocredito.inmocredit.repository;

import com.nuevocredito.inmocredit.entities.DataInmobiliaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDataInmobiliariaRepository extends JpaRepository<DataInmobiliaria, Long> {

}

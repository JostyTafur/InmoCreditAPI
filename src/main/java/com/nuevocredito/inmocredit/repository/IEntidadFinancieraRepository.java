package com.nuevocredito.inmocredit.repository;

import com.nuevocredito.inmocredit.entities.EntidadFinanciera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEntidadFinancieraRepository extends JpaRepository<EntidadFinanciera, Long> {

}

package com.nuevocredito.inmocredit.dto;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
public class entidadfinancieraDTO {
    @NotNull
    private String nombreEntidad;
    @NotNull
    private String tipoTasa;

    private String tipoTasaNominal;

    private String tipoCapitalizacion;
    @NotNull
    private Float valorTasa;
    @NotNull
    private Integer plazo;
    @NotNull
    private Float segDesgravamen;
    @NotNull
    private Float segInmueble;
}

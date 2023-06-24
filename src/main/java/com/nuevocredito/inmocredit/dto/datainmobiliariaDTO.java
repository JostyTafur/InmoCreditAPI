package com.nuevocredito.inmocredit.dto;

import lombok.Data;


import javax.validation.constraints.NotNull;

@Data
public class datainmobiliariaDTO {
    @NotNull
    private Float valorInmueble;
    @NotNull
    private String moneda;
    @NotNull
    private Float cuotaInicial;
    @NotNull
    private String apoyoHabitacional;
    private String sostenibilidad;
    @NotNull
    private Float totalBBP;
    private Integer perTotal;
    private Integer perParcial;
    @NotNull
    private String username;
    @NotNull
    private entidadfinancieraDTO entidadFinanciera;
}

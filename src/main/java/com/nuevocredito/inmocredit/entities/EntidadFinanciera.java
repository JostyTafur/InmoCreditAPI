package com.nuevocredito.inmocredit.entities;

import io.cucumber.java.zh_tw.並且;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "entidad_financiera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntidadFinanciera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nombre_entidad", nullable = false)
    private String nombreEntidad;
    @Column(name = "tipo_tasa", nullable = false)
    private String tipoTasa;
    @Column(name = "tipo_tasa_nominal", nullable = true)
    private String tipoTasaNominal;
    @Column(name = "tipo_capitalizacion", nullable = true)
    private String tipoCapitalizacion;
    @Column(name = "valor_tasa", nullable = false)
    private Float valorTasa;
    @Column(name = "plazo", nullable = false)
    private Integer plazo;
    @Column(name = "seguro_desgravamen", nullable = false)
    private Float segDesgravamen;
    @Column(name = "seguro_inmueble", nullable = false)
    private Float segInmueble;

    public EntidadFinanciera(String nombreEntidad, String tipoTasa, String tipoTasaNominal, String tipoCapitalizacion, Float valorTasa, Integer plazo, Float segDesgravamen, Float segInmueble) {
        this.nombreEntidad = nombreEntidad;
        this.tipoTasa = tipoTasa;
        this.tipoTasaNominal = tipoTasaNominal;
        this.tipoCapitalizacion = tipoCapitalizacion;
        this.valorTasa = valorTasa;
        this.plazo = plazo;
        this.segDesgravamen = segDesgravamen;
        this.segInmueble = segInmueble;
    }
}

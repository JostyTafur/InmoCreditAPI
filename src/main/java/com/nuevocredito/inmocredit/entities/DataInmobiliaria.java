package com.nuevocredito.inmocredit.entities;

import com.nuevocredito.inmocredit.security.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "data_inmobiliaria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataInmobiliaria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "valor_inmueble", nullable = false)
    private Float valorInmueble;
    @Column(name = "moneda", nullable = false)
    private String moneda;
    @Column(name="cuota_inicial",nullable = false)
    private Float cuotaInicial;
    @Column(name = "apoyo_habitacional", nullable = false)
    private String apoyoHabitacional;
    @Column(name = "sostenibilidad", nullable = true)
    private String sostenibilidad;
    @Column(name = "total_bbp", nullable = true)
    private Float totalBBP;
    @Column(name = "periodo_total", nullable = true)
    private Integer perTotal;
    @Column(name = "periodo_parcial", nullable = true)
    private Integer perParcial;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "entidad_financiera_id")
    private EntidadFinanciera entidadFinanciera;
}

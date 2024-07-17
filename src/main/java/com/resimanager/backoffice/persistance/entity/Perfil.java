package com.resimanager.backoffice.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
@Table(name = "Perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PrfID", nullable = false)
    private Integer id;

    @Size(max = 80)
    @NotNull
    @Column(name = "PrfNombre", nullable = false, length = 80)
    private String prfNombre;

    @Size(max = 120)
    @Column(name = "PrfDescrip", length = 120)
    private String prfDescrip;

    @Size(max = 1)
    @NotNull
    @Column(name = "PrfSts", nullable = false, length = 1)
    private String prfSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Prf_UsrCrea", nullable = false)
    private Persona prfUsrcrea;

    @NotNull
    @Column(name = "PrfFchHorCrea", nullable = false)
    private OffsetDateTime prfFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "PrfEstCrea", nullable = false, length = 40)
    private String prfEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Prf_UsrMod", nullable = false)
    private Persona prfUsrmod;

    @NotNull
    @Column(name = "PrfFchHorMod", nullable = false)
    private OffsetDateTime prfFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "PrfEstMod", nullable = false, length = 40)
    private String prfEstMod;

}
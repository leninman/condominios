package com.resimanager.backoffice.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@Table(name = "Opcion")
public class Opcion {
    @EmbeddedId
    private OpcionId id;

    @Size(max = 80)
    @NotNull
    @Column(name = "OpcNombre", nullable = false, length = 80)
    private String opcNombre;

    @Size(max = 120)
    @NotNull
    @Column(name = "OpcDescrip", nullable = false, length = 120)
    private String opcDescrip;

    @Size(max = 1)
    @NotNull
    @Column(name = "OpcSts", nullable = false, length = 1)
    private String opcSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Opc_UsrCrea", nullable = false)
    private Persona opcUsrcrea;

    @NotNull
    @Column(name = "OpcFchHorCrea", nullable = false)
    private OffsetDateTime opcFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "OpcEstCrea", nullable = false, length = 40)
    private String opcEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Opc_UsrMod", nullable = false)
    private Persona opcUsrmod;

    @NotNull
    @Column(name = "OpcFchHorMod", nullable = false)
    private OffsetDateTime opcFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "OpcEstMod", nullable = false, length = 40)
    private String opcEstMod;

}
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
@Table(name = "Accion")
public class Accion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccID", nullable = false)
    private Integer id;

    @Size(max = 80)
    @NotNull
    @Column(name = "AccNombre", nullable = false, length = 80)
    private String accNombre;

    @Size(max = 120)
    @NotNull
    @Column(name = "AccDescrip", nullable = false, length = 120)
    private String accDescrip;

    @Size(max = 1)
    @NotNull
    @Column(name = "AccSts", nullable = false, length = 1)
    private String accSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Acc_UsrCrea", nullable = false)
    private Persona accUsrcrea;

    @NotNull
    @Column(name = "AccFchHorCrea", nullable = false)
    private OffsetDateTime accFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "AccEstCrea", nullable = false, length = 40)
    private String accEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Acc_UsrMod", nullable = false)
    private Persona accUsrmod;

    @NotNull
    @Column(name = "AccFchHorMod", nullable = false)
    private OffsetDateTime accFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "AccEstMod", nullable = false, length = 40)
    private String accEstMod;

}
package com.resimanager.backoffice.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
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
@Table(name = "PersConjunto")
public class PersConjunto {
    @EmbeddedId
    private PersConjuntoId id;

    @MapsId("pcPerid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PC_PerID", nullable = false)
    private Persona pcPerid;

    @NotNull
    @Column(name = "PCID", nullable = false)
    private Integer pcid;

    @Size(max = 1)
    @NotNull
    @Column(name = "PCSts", nullable = false, length = 1)
    private String pCSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PC_UsrCrea", nullable = false)
    private Persona pcUsrcrea;

    @NotNull
    @Column(name = "PCFchHorCrea", nullable = false)
    private OffsetDateTime pCFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "PCEstCrea", nullable = false, length = 40)
    private String pCEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PC_UsrMod", nullable = false)
    private Persona pcUsrmod;

    @NotNull
    @Column(name = "PCFchHorMod", nullable = false)
    private OffsetDateTime pCFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "PCEstMod", nullable = false, length = 40)
    private String pCEstMod;

}
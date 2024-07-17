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
@Table(name = "PerfPersConjunto")
public class PerfPersConjunto {
    @EmbeddedId
    private PerfPersConjuntoId id;

    @MapsId("ppcPrfid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PPC_PrfID", nullable = false)
    private Perfil ppcPrfid;

    @NotNull
    @Column(name = "PPCID", nullable = false)
    private Integer ppcid;

    @Size(max = 1)
    @NotNull
    @Column(name = "PPCSts", nullable = false, length = 1)
    private String pPCSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PPC_UsrCrea", nullable = false)
    private Persona ppcUsrcrea;

    @NotNull
    @Column(name = "PPCFchHorCrea", nullable = false)
    private OffsetDateTime pPCFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "PPCEstCrea", nullable = false, length = 40)
    private String pPCEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PPC_UsrMod", nullable = false)
    private Persona ppcUsrmod;

    @NotNull
    @Column(name = "PPCFchHorMod", nullable = false)
    private OffsetDateTime pPCFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "PPCEstMod", nullable = false, length = 40)
    private String pPCEstMod;

    @NotNull
    @Column(name = "PPC_PFCID", nullable = false)
    private Integer ppcPfcid;

}
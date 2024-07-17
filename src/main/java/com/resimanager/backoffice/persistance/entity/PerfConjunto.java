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
@Table(name = "PerfConjunto")
public class PerfConjunto {
    @EmbeddedId
    private PerfConjuntoId id;

    @MapsId("pfcPrfid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PFC_PrfID", nullable = false)
    private Perfil pfcPrfid;

    @NotNull
    @Column(name = "PFCID", nullable = false)
    private Integer pfcid;

    @Size(max = 1)
    @NotNull
    @Column(name = "PFCSts", nullable = false, length = 1)
    private String pFCSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PFC_UsrCrea", nullable = false)
    private Persona pfcUsrcrea;

    @NotNull
    @Column(name = "PFCFchHorCrea", nullable = false)
    private OffsetDateTime pFCFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "PFCEstCrea", nullable = false, length = 40)
    private String pFCEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PFC_UsrMod", nullable = false)
    private Persona pfcUsrmod;

    @NotNull
    @Column(name = "PFCFchHorMod", nullable = false)
    private OffsetDateTime pFCFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "PFCEstMod", nullable = false, length = 40)
    private String pFCEstMod;

}
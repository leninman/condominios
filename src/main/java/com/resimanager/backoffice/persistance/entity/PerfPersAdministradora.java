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
@Table(name = "PerfPersAdministradora")
public class PerfPersAdministradora {
    @EmbeddedId
    private PerfPersAdministradoraId id;

    @MapsId("ppaPrfid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PPA_PrfID", nullable = false)
    private Perfil ppaPrfid;

    @NotNull
    @Column(name = "PPAID", nullable = false)
    private Integer ppaid;

    @Size(max = 1)
    @NotNull
    @Column(name = "PPASts", nullable = false, length = 1)
    private String pPASts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PPA_UsrCrea", nullable = false)
    private Persona ppaUsrcrea;

    @NotNull
    @Column(name = "PPAFchHorCrea", nullable = false)
    private OffsetDateTime pPAFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "PPAEstCrea", nullable = false, length = 40)
    private String pPAEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PPA_UsrMod", nullable = false)
    private Persona ppaUsrmod;

    @NotNull
    @Column(name = "PPAFchHorMod", nullable = false)
    private OffsetDateTime pPAFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "PPAEstMod", nullable = false, length = 40)
    private String pPAEstMod;

    @NotNull
    @Column(name = "PPA_PFAID", nullable = false)
    private Integer ppaPfaid;

}
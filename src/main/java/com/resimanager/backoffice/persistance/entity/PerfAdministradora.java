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
@Table(name = "PerfAdministradora")
public class PerfAdministradora {
    @EmbeddedId
    private PerfAdministradoraId id;

    @MapsId("pfaPrfid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PFA_PrfID", nullable = false)
    private Perfil pfaPrfid;

    @NotNull
    @Column(name = "PFAID", nullable = false)
    private Integer pfaid;

    @Size(max = 1)
    @NotNull
    @Column(name = "PFASts", nullable = false, length = 1)
    private String pFASts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PFA_UsrCrea", nullable = false)
    private Persona pfaUsrcrea;

    @NotNull
    @Column(name = "PFAFchHorCrea", nullable = false)
    private OffsetDateTime pFAFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "PFAEstCrea", nullable = false, length = 40)
    private String pFAEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PFA_UsrMod", nullable = false)
    private Persona pfaUsrmod;

    @NotNull
    @Column(name = "PFAFchHorMod", nullable = false)
    private OffsetDateTime pFAFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "PFAEstMod", nullable = false, length = 40)
    private String pFAEstMod;

}
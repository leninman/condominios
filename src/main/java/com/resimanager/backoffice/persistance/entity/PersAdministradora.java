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
@Table(name = "PersAdministradora")
public class PersAdministradora {
    @EmbeddedId
    private PersAdministradoraId id;

    @MapsId("paPerid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PA_PerID", nullable = false)
    private Persona paPerid;

    @NotNull
    @Column(name = "PAID", nullable = false)
    private Integer paid;

    @Size(max = 1)
    @NotNull
    @Column(name = "PASts", nullable = false, length = 1)
    private String pASts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PA_UsrCrea", nullable = false)
    private Persona paUsrcrea;

    @NotNull
    @Column(name = "PAFchHorCrea", nullable = false)
    private OffsetDateTime pAFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "PAEstCrea", nullable = false, length = 40)
    private String pAEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "PA_UsrMod", nullable = false)
    private Persona paUsrmod;

    @NotNull
    @Column(name = "PAFchHorMod", nullable = false)
    private OffsetDateTime pAFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "PAEstMod", nullable = false, length = 40)
    private String pAEstMod;

}
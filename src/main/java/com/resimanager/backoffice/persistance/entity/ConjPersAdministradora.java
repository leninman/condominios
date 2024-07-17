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
@Table(name = "ConjPersAdministradora")
public class ConjPersAdministradora {
    @EmbeddedId
    private ConjPersAdministradoraId id;

    @MapsId("cpaConjid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "CPA_ConjID", nullable = false)
    private Conjunto cpaConjid;

    @NotNull
    @Column(name = "CPAID", nullable = false)
    private Integer cpaid;

    @Size(max = 1)
    @NotNull
    @Column(name = "CPASts", nullable = false, length = 1)
    private String cPASts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "CPA_UsrCrea", nullable = false)
    private Persona cpaUsrcrea;

    @NotNull
    @Column(name = "CPAFchHorCrea", nullable = false)
    private OffsetDateTime cPAFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "CPAEstCrea", nullable = false, length = 40)
    private String cPAEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "CPA_UsrMod", nullable = false)
    private Persona cpaUsrmod;

    @NotNull
    @Column(name = "CPAFchHorMod", nullable = false)
    private OffsetDateTime cPAFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "CPAEstMod", nullable = false, length = 40)
    private String cPAEstMod;

}
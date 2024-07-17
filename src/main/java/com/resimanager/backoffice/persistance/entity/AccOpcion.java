package com.resimanager.backoffice.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
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
@Table(name = "AccOpcion")
public class AccOpcion {
    @EmbeddedId
    private AccOpcionId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "AO_ModID", referencedColumnName = "Opc_ModID", nullable = false),
            @JoinColumn(name = "AO_OpcID", referencedColumnName = "OpcID", nullable = false)
    })
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Opcion opcion;

    @MapsId("aoAccid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "AO_AccID", nullable = false)
    private Accion aoAccid;

    @NotNull
    @Column(name = "AOID", nullable = false)
    private Integer aoid;

    @NotNull
    @Column(name = "AOCodSeg", nullable = false)
    private Integer aOCodSeg;

    @Size(max = 1)
    @NotNull
    @Column(name = "AOSts", nullable = false, length = 1)
    private String aOSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "AO_UsrCrea", nullable = false)
    private Persona aoUsrcrea;

    @NotNull
    @Column(name = "AOFchHorCrea", nullable = false)
    private OffsetDateTime aOFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "AOEstCrea", nullable = false, length = 40)
    private String aOEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "AO_UsrMod", nullable = false)
    private Persona aoUsrmod;

    @NotNull
    @Column(name = "AOFchHorMod", nullable = false)
    private OffsetDateTime aOFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "AOEstMod", nullable = false, length = 40)
    private String aOEstMod;

}
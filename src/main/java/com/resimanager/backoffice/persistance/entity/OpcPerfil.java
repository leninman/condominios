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
@Table(name = "OpcPerfil")
public class OpcPerfil {
    @EmbeddedId
    private OpcPerfilId id;

    @MapsId("id")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumns({
            @JoinColumn(name = "OP_ModID", referencedColumnName = "Opc_ModID", nullable = false),
            @JoinColumn(name = "OP_OpcID", referencedColumnName = "OpcID", nullable = false)
    })
    @OnDelete(action = OnDeleteAction.RESTRICT)
    private Opcion opcion;

    @NotNull
    @Column(name = "OPID", nullable = false)
    private Integer opid;

    @Size(max = 1)
    @NotNull
    @Column(name = "OPSts", nullable = false, length = 1)
    private String oPSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "OP_UsrCrea", nullable = false)
    private Persona opUsrcrea;

    @NotNull
    @Column(name = "OPFchHorCrea", nullable = false)
    private OffsetDateTime oPFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "OPEstCrea", nullable = false, length = 40)
    private String oPEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "OP_UsrMod", nullable = false)
    private Persona opUsrmod;

    @NotNull
    @Column(name = "OPFchHorMod", nullable = false)
    private OffsetDateTime oPFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "OPEstMod", nullable = false, length = 40)
    private String oPEstMod;

}
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
@Table(name = "ModPerfil")
public class ModPerfil {
    @EmbeddedId
    private ModPerfilId id;

    @MapsId("mpPrfid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "MP_PrfID", nullable = false)
    private Perfil mpPrfid;

    @MapsId("mpModid")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "MP_ModID", nullable = false)
    private Modulo mpModid;

    @NotNull
    @Column(name = "MPID", nullable = false)
    private Integer mpid;

    @Size(max = 1)
    @NotNull
    @Column(name = "MPSts", nullable = false, length = 1)
    private String mPSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "MP_UsrCrea", nullable = false)
    private Persona mpUsrcrea;

    @NotNull
    @Column(name = "MPFchHorCrea", nullable = false)
    private OffsetDateTime mPFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "MPEstCrea", nullable = false, length = 40)
    private String mPEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "MP_UsrMod", nullable = false)
    private Persona mpUsrmod;

    @NotNull
    @Column(name = "MPFchHorMod", nullable = false)
    private OffsetDateTime mPFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "MPEstMod", nullable = false, length = 40)
    private String mPEstMod;

}
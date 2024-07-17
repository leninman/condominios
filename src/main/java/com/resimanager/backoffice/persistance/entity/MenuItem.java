package com.resimanager.backoffice.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "MenuItem")
public class MenuItem {
    @EmbeddedId
    private MenuItemId id;

    @Size(max = 80)
    @NotNull
    @Column(name = "MItNombre", nullable = false, length = 80)
    private String mItNombre;

    @Size(max = 1)
    @NotNull
    @Column(name = "MItTipo", nullable = false, length = 1)
    private String mItTipo;

    @NotNull
    @Column(name = "MItItemPadre", nullable = false)
    private Integer mItItemPadre;

    @NotNull
    @Column(name = "MItOrden", nullable = false)
    private Integer mItOrden;

    @Size(max = 20)
    @Column(name = "MItControlador", length = 20)
    private String mItControlador;

    @Size(max = 20)
    @Column(name = "MItMetodo", length = 20)
    private String mItMetodo;

    @Size(max = 1)
    @NotNull
    @Column(name = "MItSts", nullable = false, length = 1)
    private String mItSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "MIt_UsrCrea", nullable = false)
    private Persona mitUsrcrea;

    @NotNull
    @Column(name = "MItFchHorCrea", nullable = false)
    private OffsetDateTime mItFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "MItEstCrea", nullable = false, length = 40)
    private String mItEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "MIt_UsrMod", nullable = false)
    private Persona mitUsrmod;

    @NotNull
    @Column(name = "MItFchHorMod", nullable = false)
    private OffsetDateTime mItFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "MItEstMod", nullable = false, length = 40)
    private String mItEstMod;

}
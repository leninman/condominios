package com.resimanager.backoffice.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MenuID", nullable = false)
    private Integer id;

    @Size(max = 80)
    @NotNull
    @Column(name = "MenuNombre", nullable = false, length = 80)
    private String menuNombre;

    @Size(max = 120)
    @NotNull
    @Column(name = "MenuDescrip", nullable = false, length = 120)
    private String menuDescrip;

    @Size(max = 1)
    @NotNull
    @Column(name = "MenuSts", nullable = false, length = 1)
    private String menuSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Menu_UsrCrea", nullable = false)
    private Persona menuUsrcrea;

    @NotNull
    @Column(name = "MenuFchHorCrea", nullable = false)
    private OffsetDateTime menuFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "MenuEstCrea", nullable = false, length = 40)
    private String menuEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Menu_UsrMod", nullable = false)
    private Persona menuUsrmod;

    @NotNull
    @Column(name = "MenuFchHorMod", nullable = false)
    private OffsetDateTime menuFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "MenuEstMod", nullable = false, length = 40)
    private String menuEstMod;

    @Size(max = 1)
    @NotNull
    @Column(name = "MenuPosicion", nullable = false, length = 1)
    private String menuPosicion;

}
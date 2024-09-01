package com.resimanager.backoffice.persistance.entity;

import jakarta.persistence.*;
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
@Table(name = "menu_item")
public class MenuItem {
    @EmbeddedId
    private MenuItemId id;

    @Size(max = 80)
    @NotNull
    @Column(name = "mit_nombre", nullable = false, length = 80)
    private String mItNombre;

    @Size(max = 1)
    @NotNull
    @Column(name = "mit_tipo", nullable = false, length = 1)
    private String mItTipo;

    @NotNull
    @Column(name = "mit_item_padre", nullable = false)
    private Integer mItItemPadre;

    @NotNull
    @Column(name = "mit_orden", nullable = false)
    private Integer mItOrden;

    @Size(max = 20)
    @Column(name = "mit_controlador", length = 20)
    private String mItControlador;

    @Size(max = 20)
    @Column(name = "mit_metodo", length = 20)
    private String mItMetodo;

    @Size(max = 1)
    @NotNull
    @Column(name = "mit_sts", nullable = false, length = 1)
    private String mItSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "mit_usr_crea", nullable = false)
    private Persona mitUsrcrea;

    @NotNull
    @Column(name = "mit_fch_hor_crea", nullable = false)
    private OffsetDateTime mItFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "mit_est_crea", nullable = false, length = 40)
    private String mItEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "mit_usr_mod", nullable = false)
    private Persona mitUsrmod;

    @NotNull
    @Column(name = "mit_fch_hor_mod", nullable = false)
    private OffsetDateTime mItFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "mit_est_mod", nullable = false, length = 40)
    private String mItEstMod;


    @ManyToOne()
    @JoinColumn(name = "mit_modid",insertable=false, updatable=false)
    private Modulo modulo;


    @ManyToOne()
    @JoinColumn(name = "mit_accionid" )
    private Accion accion;

    @ManyToOne()
    @JoinColumns({
            @JoinColumn(name = "mit_opcionid",referencedColumnName = "opcid"),
            @JoinColumn(name="mit_modid",referencedColumnName = "opc_modid")
    })
    private Opcion opcion;



}
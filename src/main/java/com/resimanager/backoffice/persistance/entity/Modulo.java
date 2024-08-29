package com.resimanager.backoffice.persistance.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Modulo")
public class Modulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ModID", nullable = false)
    private Integer modId;

    @Size(max = 80)
    @NotNull
    @Column(name = "mod_nombre", nullable = false, length = 80)
    private String modNombre;

    @Size(max = 120)
    @Column(name = "ModDescrip", length = 120)
    private String modDescrip;

    @Size(max = 1)
    @NotNull
    @Column(name = "ModSts", nullable = false, length = 1)
    private String modSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Mod_UsrCrea", nullable = false)
    private Persona modUsrcrea;

    @NotNull
    @Column(name = "ModFchHorCrea", nullable = false)
    private OffsetDateTime modFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "ModEstCrea", nullable = false, length = 40)
    private String modEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Mod_UsrMod", nullable = false)
    private Persona modUsrmod;

    @NotNull
    @Column(name = "ModFchHorMod", nullable = false)
    private OffsetDateTime modFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "ModEstMod", nullable = false, length = 40)
    private String modEstMod;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mItModId")
    private List<MenuItem> menuItems;

}
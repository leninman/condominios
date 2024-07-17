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
@Table(name = "Conjunto")
public class Conjunto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ConjID", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "ConjDocIdent", nullable = false, length = 20)
    private String conjDocIdent;

    @Size(max = 80)
    @NotNull
    @Column(name = "ConjNombre", nullable = false, length = 80)
    private String conjNombre;

    @Size(max = 15)
    @NotNull
    @Column(name = "ConjTelefono", nullable = false, length = 15)
    private String conjTelefono;

    @Size(max = 80)
    @NotNull
    @Column(name = "ConjEMail", nullable = false, length = 80)
    private String conjEMail;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Conj_PersContacto", nullable = false)
    private Persona conjPerscontacto;

    @Size(max = 1)
    @NotNull
    @Column(name = "ConjSts", nullable = false, length = 1)
    private String conjSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Conj_UsrCrea", nullable = false)
    private Persona conjUsrcrea;

    @NotNull
    @Column(name = "ConjFchHorCrea", nullable = false)
    private OffsetDateTime conjFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "ConjEstCrea", nullable = false, length = 40)
    private String conjEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Conj_UsrMod", nullable = false)
    private Persona conjUsrmod;

    @NotNull
    @Column(name = "ConjFchHorMod", nullable = false)
    private OffsetDateTime conjFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "ConjEstMod", nullable = false, length = 40)
    private String conjEstMod;

}
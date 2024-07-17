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
@Table(name = "Persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PerID", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "PerDocIdent", nullable = false, length = 20)
    private String perDocIdent;

    @Size(max = 80)
    @NotNull
    @Column(name = "PerNombre", nullable = false, length = 80)
    private String perNombre;

    @Size(max = 80)
    @NotNull
    @Column(name = "PerApellido", nullable = false, length = 80)
    private String perApellido;

    @Size(max = 15)
    @NotNull
    @Column(name = "PerTlfCel", nullable = false, length = 15)
    private String perTlfCel;

    @Size(max = 80)
    @NotNull
    @Column(name = "PerEMail", nullable = false, length = 80)
    private String perEMail;

    @Size(max = 80)
    @Column(name = "PerUsuario", length = 80)
    private String perUsuario;

    @Size(max = 80)
    @Column(name = "PerClave", length = 80)
    private String perClave;

    @Size(max = 1)
    @NotNull
    @Column(name = "PerSts", nullable = false, length = 1)
    private String perSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Per_UsrCrea", nullable = false)
    private Persona perUsrcrea;

    @NotNull
    @Column(name = "PerFchHorCrea", nullable = false)
    private OffsetDateTime perFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "PerEstCrea", nullable = false, length = 40)
    private String perEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Per_UsrMod", nullable = false)
    private Persona perUsrmod;

    @NotNull
    @Column(name = "PerFchHorMod", nullable = false)
    private OffsetDateTime perFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "PerEstMod", nullable = false, length = 40)
    private String perEstMod;

}
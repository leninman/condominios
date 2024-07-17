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
@Table(name = "Administradora")
public class Administradora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AdmID", nullable = false)
    private Integer id;

    @Size(max = 20)
    @NotNull
    @Column(name = "AdmDocIdent", nullable = false, length = 20)
    private String admDocIdent;

    @Size(max = 80)
    @NotNull
    @Column(name = "AdmNombre", nullable = false, length = 80)
    private String admNombre;

    @Size(max = 15)
    @NotNull
    @Column(name = "AdmTelefono", nullable = false, length = 15)
    private String admTelefono;

    @Size(max = 80)
    @NotNull
    @Column(name = "AdmEMail", nullable = false, length = 80)
    private String admEMail;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Adm_PersContacto", nullable = false)
    private Persona admPerscontacto;

    @Size(max = 1)
    @NotNull
    @Column(name = "AdmSts", nullable = false, length = 1)
    private String admSts;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Adm_UsrCrea", nullable = false)
    private Persona admUsrcrea;

    @NotNull
    @Column(name = "AdmFchHorCrea", nullable = false)
    private OffsetDateTime admFchHorCrea;

    @Size(max = 40)
    @NotNull
    @Column(name = "AdmEstCrea", nullable = false, length = 40)
    private String admEstCrea;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.RESTRICT)
    @JoinColumn(name = "Adm_UsrMod", nullable = false)
    private Persona admUsrmod;

    @NotNull
    @Column(name = "AdmFchHorMod", nullable = false)
    private OffsetDateTime admFchHorMod;

    @Size(max = 40)
    @NotNull
    @Column(name = "AdmEstMod", nullable = false, length = 40)
    private String admEstMod;

}
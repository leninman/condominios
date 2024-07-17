package com.resimanager.backoffice.persistance.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class PropiedadId implements Serializable {
    private static final long serialVersionUID = 4504204011196107589L;
    @NotNull
    @Column(name = "PpdID", nullable = false)
    private Integer ppdID;

    @NotNull
    @Column(name = "Ppd_ConjID", nullable = false)
    private Integer ppdConjid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PropiedadId entity = (PropiedadId) o;
        return Objects.equals(this.ppdConjid, entity.ppdConjid) &&
                Objects.equals(this.ppdID, entity.ppdID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ppdConjid, ppdID);
    }

}
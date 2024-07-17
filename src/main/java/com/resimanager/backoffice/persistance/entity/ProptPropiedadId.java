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
public class ProptPropiedadId implements Serializable {
    private static final long serialVersionUID = -2780907301203063122L;
    @NotNull
    @Column(name = "PP_PpdID", nullable = false)
    private Integer ppPpdid;

    @NotNull
    @Column(name = "PP_ConjID", nullable = false)
    private Integer ppConjid;

    @NotNull
    @Column(name = "PP_PerID", nullable = false)
    private Integer ppPerid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ProptPropiedadId entity = (ProptPropiedadId) o;
        return Objects.equals(this.ppConjid, entity.ppConjid) &&
                Objects.equals(this.ppPerid, entity.ppPerid) &&
                Objects.equals(this.ppPpdid, entity.ppPpdid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ppConjid, ppPerid, ppPpdid);
    }

}
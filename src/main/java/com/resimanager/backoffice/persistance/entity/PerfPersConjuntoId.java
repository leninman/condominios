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
public class PerfPersConjuntoId implements Serializable {
    private static final long serialVersionUID = 4578922579186688746L;
    @NotNull
    @Column(name = "PPC_ConjID", nullable = false)
    private Integer ppcConjid;

    @NotNull
    @Column(name = "PPC_PerID", nullable = false)
    private Integer ppcPerid;

    @NotNull
    @Column(name = "PPC_PrfID", nullable = false)
    private Integer ppcPrfid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PerfPersConjuntoId entity = (PerfPersConjuntoId) o;
        return Objects.equals(this.ppcPerid, entity.ppcPerid) &&
                Objects.equals(this.ppcPrfid, entity.ppcPrfid) &&
                Objects.equals(this.ppcConjid, entity.ppcConjid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ppcPerid, ppcPrfid, ppcConjid);
    }

}
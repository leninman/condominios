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
public class PerfPersAdministradoraId implements Serializable {
    private static final long serialVersionUID = -8050277157679631153L;
    @NotNull
    @Column(name = "PPA_AdmID", nullable = false)
    private Integer ppaAdmid;

    @NotNull
    @Column(name = "PPA_PerID", nullable = false)
    private Integer ppaPerid;

    @NotNull
    @Column(name = "PPA_PrfID", nullable = false)
    private Integer ppaPrfid;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        PerfPersAdministradoraId entity = (PerfPersAdministradoraId) o;
        return Objects.equals(this.ppaAdmid, entity.ppaAdmid) &&
                Objects.equals(this.ppaPerid, entity.ppaPerid) &&
                Objects.equals(this.ppaPrfid, entity.ppaPrfid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ppaAdmid, ppaPerid, ppaPrfid);
    }

}
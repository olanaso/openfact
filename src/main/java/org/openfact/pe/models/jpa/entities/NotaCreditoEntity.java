package org.openfact.pe.models.jpa.entities;

import org.openfact.core.models.jpa.entities.OrganizationEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "nota_credito_pe")
@NamedQueries(value = {

})
public class NotaCreditoEntity implements Serializable {

    @Id
    @Column(name = "id")
    private String id;

    @NotNull
    @Column(name = "id_asignado")
    private String idAsignado;

    @Embedded
    private ClienteEntity cliente;

    @OneToOne
    @MapsId
    private OrganizationEntity organizacion;

    @Version
    @Column(name = "version")
    private int version;

    @Override
    public String toString() {
        String result = getClass().getSimpleName() + " ";
        if (id != null)
            result += "id: " + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NotaCreditoEntity)) {
            return false;
        }
        NotaCreditoEntity other = (NotaCreditoEntity) obj;
        if (id != null) {
            if (!id.equals(other.id)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdAsignado() {
        return idAsignado;
    }

    public void setIdAsignado(String idAsignado) {
        this.idAsignado = idAsignado;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public OrganizationEntity getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(OrganizationEntity organizacion) {
        this.organizacion = organizacion;
    }

    public ClienteEntity getCliente() {
        return cliente;
    }

    public void setCliente(ClienteEntity cliente) {
        this.cliente = cliente;
    }
}
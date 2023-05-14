/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mariangel.lab3;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Administrador
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "TBL_CITAS")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Citas.findAll", query = "SELECT c FROM Citas c"),
    @javax.persistence.NamedQuery(name = "Citas.findByCitaDia", query = "SELECT c FROM Citas c WHERE c.citaDia = :citaDia"),
    @javax.persistence.NamedQuery(name = "Citas.findByCitaHora", query = "SELECT c FROM Citas c WHERE c.citaHora = :citaHora"),
    @javax.persistence.NamedQuery(name = "Citas.findByCitaId", query = "SELECT c FROM Citas c WHERE c.citaId = :citaId")})
public class Citas implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Column(name = "CITA_DIA")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date citaDia;
    @javax.persistence.Column(name = "CITA_HORA")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date citaHora;
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "CITA_ID")
    private Integer citaId;
    @javax.persistence.JoinColumn(name = "CITA_CEDUPAC", referencedColumnName = "PAC_CEDULA")
    @javax.persistence.ManyToOne(optional = false)
    private Pacientes citaCedupac;

    public Citas() {
    }

    public Citas(Integer citaId) {
        this.citaId = citaId;
    }

    public Date getCitaDia() {
        return citaDia;
    }

    public void setCitaDia(Date citaDia) {
        this.citaDia = citaDia;
    }

    public Date getCitaHora() {
        return citaHora;
    }

    public void setCitaHora(Date citaHora) {
        this.citaHora = citaHora;
    }

    public Integer getCitaId() {
        return citaId;
    }

    public void setCitaId(Integer citaId) {
        this.citaId = citaId;
    }

    public Pacientes getCitaCedupac() {
        return citaCedupac;
    }

    public void setCitaCedupac(Pacientes citaCedupac) {
        this.citaCedupac = citaCedupac;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (citaId != null ? citaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Citas)) {
            return false;
        }
        Citas other = (Citas) object;
        if ((this.citaId == null && other.citaId != null) || (this.citaId != null && !this.citaId.equals(other.citaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mariangel.lab3.Citas[ citaId=" + citaId + " ]";
    }
    
}

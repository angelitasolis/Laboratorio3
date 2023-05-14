/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mariangel.lab3;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Administrador
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "TBL_PACIENTES")
@javax.persistence.NamedQueries({
    @javax.persistence.NamedQuery(name = "Pacientes.findAll", query = "SELECT p FROM Pacientes p"),
    @javax.persistence.NamedQuery(name = "Pacientes.findByPacCedula", query = "SELECT p FROM Pacientes p WHERE p.pacCedula = :pacCedula"),
    @javax.persistence.NamedQuery(name = "Pacientes.findByPacNombre", query = "SELECT p FROM Pacientes p WHERE p.pacNombre = :pacNombre"),
    @javax.persistence.NamedQuery(name = "Pacientes.findByPacPapellido", query = "SELECT p FROM Pacientes p WHERE p.pacPapellido = :pacPapellido"),
    @javax.persistence.NamedQuery(name = "Pacientes.findByPacSapellido", query = "SELECT p FROM Pacientes p WHERE p.pacSapellido = :pacSapellido"),
    @javax.persistence.NamedQuery(name = "Pacientes.findByPacDirec", query = "SELECT p FROM Pacientes p WHERE p.pacDirec = :pacDirec"),
    @javax.persistence.NamedQuery(name = "Pacientes.findByPacFecnac", query = "SELECT p FROM Pacientes p WHERE p.pacFecnac = :pacFecnac")})
public class Pacientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @javax.persistence.Id
    @javax.persistence.Basic(optional = false)
    @javax.persistence.Column(name = "PAC_CEDULA")
    private String pacCedula;
    @javax.persistence.Column(name = "PAC_NOMBRE")
    private String pacNombre;
    @javax.persistence.Column(name = "PAC_PAPELLIDO")
    private String pacPapellido;
    @javax.persistence.Column(name = "PAC_SAPELLIDO")
    private String pacSapellido;
    @javax.persistence.Column(name = "PAC_DIREC")
    private String pacDirec;
    @javax.persistence.Column(name = "PAC_FECNAC")
    @javax.persistence.Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date pacFecnac;
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL, mappedBy = "citaCedupac")
    private Collection<Citas> citasCollection;

    public Pacientes() {
    }

    public Pacientes(String pacCedula) {
        this.pacCedula = pacCedula;
    }

    public String getPacCedula() {
        return pacCedula;
    }

    public void setPacCedula(String pacCedula) {
        this.pacCedula = pacCedula;
    }

    public String getPacNombre() {
        return pacNombre;
    }

    public void setPacNombre(String pacNombre) {
        this.pacNombre = pacNombre;
    }

    public String getPacPapellido() {
        return pacPapellido;
    }

    public void setPacPapellido(String pacPapellido) {
        this.pacPapellido = pacPapellido;
    }

    public String getPacSapellido() {
        return pacSapellido;
    }

    public void setPacSapellido(String pacSapellido) {
        this.pacSapellido = pacSapellido;
    }

    public String getPacDirec() {
        return pacDirec;
    }

    public void setPacDirec(String pacDirec) {
        this.pacDirec = pacDirec;
    }

    public Date getPacFecnac() {
        return pacFecnac;
    }

    public void setPacFecnac(Date pacFecnac) {
        this.pacFecnac = pacFecnac;
    }

    public Collection<Citas> getCitasCollection() {
        return citasCollection;
    }

    public void setCitasCollection(Collection<Citas> citasCollection) {
        this.citasCollection = citasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pacCedula != null ? pacCedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacientes)) {
            return false;
        }
        Pacientes other = (Pacientes) object;
        if ((this.pacCedula == null && other.pacCedula != null) || (this.pacCedula != null && !this.pacCedula.equals(other.pacCedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mariangel.lab3.Pacientes[ pacCedula=" + pacCedula + " ]";
    }
    
}

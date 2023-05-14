/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mariangel.lab3;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Administrador
 */
public class PacienteService {

   public Respuesta eliminarPaciente(String cedula) {
    EntityManager em = getEntityManager();
    EntityTransaction et = null;
    try {
        et = em.getTransaction();
        et.begin();
        Pacientes paciente;
        if (cedula != null && !cedula.isEmpty()) {
            TypedQuery<Pacientes> query = em.createQuery("SELECT p FROM Pacientes p WHERE p.cedula = :cedula", Pacientes.class);
            query.setParameter("cedula", cedula);
            paciente = query.getSingleResult();
            if (paciente == null) {
                et.rollback();
                return new Respuesta(false, "No se encontró el paciente a eliminar.", "eliminarPaciente NoResultException");
            }
            em.remove(paciente);
        } else {
            et.rollback();
            return new Respuesta(false, "Debe cargar el paciente a eliminar.", "eliminarPaciente NoResultException");
        }
        et.commit();
        return new Respuesta(true, "Paciente eliminado exitosamente", "");
    } catch (Exception ex) {
        if (et != null && et.isActive()) {
            et.rollback();
        }
        if (ex.getCause() != null && ex.getCause().getCause().getClass() == SQLIntegrityConstraintViolationException.class) {
            return new Respuesta(false, "No se puede eliminar el paciente porque tiene relaciones con otros registros.", "eliminarPaciente " + ex.getMessage());
        }
        Logger.getLogger(PacienteService.class.getName()).log(Level.SEVERE, "Ocurrio un error al eliminar el paciente.", ex);
        return new Respuesta(false, "Ocurrio un error al eliminar el paciente.", "eliminarPaciente " + ex.getMessage());
    }
}

    private EntityManager getEntityManager() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public Respuesta modificarGuardarPaciente(Pacientes paciente) {
        EntityManager em = getEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();
            // Buscar al paciente por cedula
            TypedQuery<Pacientes> query = em.createQuery(
                    "SELECT p FROM Pacientes p WHERE p.cedula = :cedula",
                    Pacientes.class);
            query.setParameter("cedula", paciente.getPacCedula());
            List<Pacientes> pacientes = query.getResultList();

            // Si el paciente existe, actualizarlo. Si no, crear uno nuevo.
            if (pacientes.isEmpty()) {
                em.persist(paciente);
                et.commit();
                return new Respuesta(true, "Paciente agregado con éxito", "");
            } else {
                Pacientes existingPaciente = pacientes.get(0);
                existingPaciente.setPacNombre(paciente.getPacNombre());
                existingPaciente.setPacPapellido(paciente.getPacPapellido());
                existingPaciente.setPacSapellido(paciente.getPacSapellido());
                // copia los demás campos...
                em.merge(existingPaciente);
                et.commit();
                return new Respuesta(true, "Paciente existente modificado con éxito", "");
            }
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            Logger.getLogger(PacienteService.class.getName()).log(Level.SEVERE, "Ocurrió un error al agregar o modificar el paciente.", ex);
            return new Respuesta(false, "Ocurrió un error al agregar o modificar el paciente.", "modificarPaciente " + ex.getMessage());
        }
    }
    
     public List<Pacientes> buscarPorCedula(String cedula) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Pacientes p WHERE p.cedula = :cedula");
        query.setParameter("cedula", cedula);
        return query.getResultList();
    }

    public List<Pacientes> buscarPorNombre(String nombre) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Pacientes p WHERE p.nombre LIKE :nombre");
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    public List<Pacientes> buscarPorPrimerApellido(String primerApellido) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Pacientes p WHERE p.primerApellido LIKE :primerApellido");
        query.setParameter("primerApellido", "%" + primerApellido + "%");
        return query.getResultList();
    }

    public List<Pacientes> buscarPorSegundoApellido(String segundoApellido) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("SELECT p FROM Pacientes p WHERE p.segundoApellido LIKE :segundoApellido");
        query.setParameter("segundoApellido", "%" + segundoApellido + "%");
        return query.getResultList();
    }
}

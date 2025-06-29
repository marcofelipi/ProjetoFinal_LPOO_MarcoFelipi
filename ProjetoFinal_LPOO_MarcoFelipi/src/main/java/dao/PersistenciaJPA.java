package dao;

import model.*;
import javax.persistence.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistenciaJPA implements InterfaceBD {

    private EntityManager entity;
    private EntityManagerFactory factory;

    public PersistenciaJPA() {
        factory = Persistence.createEntityManagerFactory("ProjetoFinalPU");
        entity = factory.createEntityManager();
    }

    @Override
    public Boolean conexaoAberta() {
        return entity.isOpen();
    }

    @Override
    public void fecharConexao() {
        if (entity.isOpen()) entity.close();
    }

    public EntityManager getEntityManager() {
        if (entity == null || !entity.isOpen()) {
            entity = factory.createEntityManager();
        }
        return entity;
    }


    
    @Override
    public <T> T find(Class<T> clazz, Object id) {
        try {
            return getEntityManager().find(clazz, id);
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public void persist(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            entity.persist(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            entity.getTransaction().rollback();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw e;
        }
    }

    @Override
    public void remover(Object o) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if (!entity.contains(o)) {
                o = entity.merge(o);
            }
            entity.remove(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            entity.getTransaction().rollback();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw e;
        }
    }

    public <T> T merge(T obj) throws Exception {
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            T merged = entity.merge(obj);
            entity.getTransaction().commit();
            return merged;
        } catch (Exception e) {
            entity.getTransaction().rollback();
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            throw e;
        }
    }

    // === LISTAGENS ===

    public List<Paciente> getPacientes() {
        try {
            return getEntityManager().createQuery("SELECT p FROM Paciente p", Paciente.class).getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<Dentista> getDentistas() {
        try {
            return getEntityManager().createQuery("SELECT d FROM Dentista d", Dentista.class).getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<Agendamento> getAgendamentos() {
        try {
            return getEntityManager().createQuery("SELECT a FROM Agendamento a", Agendamento.class).getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<Prontuario> getProntuarios() {
        try {
            return getEntityManager().createQuery("SELECT p FROM Prontuario p", Prontuario.class).getResultList();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}

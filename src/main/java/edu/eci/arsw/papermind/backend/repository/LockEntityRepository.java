package edu.eci.arsw.papermind.backend.repository;

import edu.eci.arsw.papermind.backend.model.Biblioteca;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;

public abstract class LockEntityRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public Biblioteca findByNombre(String nombre)  {
        return entityManager.find(Biblioteca.class, nombre, LockModeType.PESSIMISTIC_WRITE);
    }

}

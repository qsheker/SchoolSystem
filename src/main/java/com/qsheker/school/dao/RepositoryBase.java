package com.qsheker.school.dao;

import com.qsheker.school.entities.BaseEntity;
import lombok.Cleanup;
import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class RepositoryBase<K extends Serializable, E extends BaseEntity<K>> implements Repository<K,E> {
    private final SessionFactory sessionFactory;
    private final  Class<E> clazz;

    @Override
    public E save(E entity) {
        var session = sessionFactory.getCurrentSession();
        session.save(entity);
        return entity;
    }

    @Override
    public void delete(K id) {
        var session = sessionFactory.getCurrentSession();
        session.delete(id);
        session.flush();
    }

    @Override
    public void update(E entity) {
        var session = sessionFactory.getCurrentSession();
        session.merge(entity);
    }

    @Override
    public Optional<E> findById(K id) {
        var session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.find(clazz, id));
    }

    @Override
    public List<E> findAll() {
        var session = sessionFactory.getCurrentSession();
        var criteria = session.getCriteriaBuilder().createQuery(clazz);
        criteria.from(clazz);
        return session.createQuery(criteria).getResultList();
    }
}

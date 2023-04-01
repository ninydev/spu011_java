package org.itstep.repository;

import org.itstep.repository.exceptions.EntityNotFindException;
import org.itstep.repository.interfaces.IEntity;

import java.util.HashSet;

public abstract class AbstractRepository <TEntity, TId>
{
    public HashSet<TEntity> data = new HashSet<>();

    public void add(TEntity e) {
        data.add(e);
    }
}

package org.itstep.repository.interfaces;

public interface IFindById <TEntity, TId>
{
    TEntity findById(TId id);
}

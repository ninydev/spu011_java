package org.itstep.repository.interfaces;

public interface IFindByEmail<TEntity>
{
    public IEntity<?> findByEmail(String email);

}

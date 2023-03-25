package org.itstep.oop.myRepository.interfaces;

public interface IUpdateRepository<TypeId, TypeEntity>
{
    public void update(TypeEntity item);
}

package org.itstep.oop.MyRepository.Interfaces;

public interface IUpdateRepository<TypeId, TypeEntity>
{
    public void update(TypeEntity item);
}

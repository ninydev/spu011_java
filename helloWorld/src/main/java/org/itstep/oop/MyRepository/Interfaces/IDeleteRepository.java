package org.itstep.oop.MyRepository.Interfaces;

public interface IDeleteRepository<TypeId, TypeEntity>
{
    public void delete(TypeEntity item);
}

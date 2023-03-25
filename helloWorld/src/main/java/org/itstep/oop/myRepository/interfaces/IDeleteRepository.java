package org.itstep.oop.myRepository.interfaces;

public interface IDeleteRepository<TypeId, TypeEntity>
{
    public void delete(TypeEntity item);
}

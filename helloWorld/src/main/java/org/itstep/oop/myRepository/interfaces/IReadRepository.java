package org.itstep.oop.myRepository.interfaces;

import java.util.ArrayList;

public interface IReadRepository<TypeId, TypeEntity>
{
    public ArrayList<TypeEntity> readAll();

    public TypeEntity findById(TypeId id);

    public TypeEntity findByIndex(int index);
}

package org.itstep.oop.MyRepository.Interfaces;

import java.util.ArrayList;

public interface IReadRepository<TypeId, TypeEntity>
{
    public ArrayList<TypeEntity> readAll();

    public TypeEntity findById(TypeId id);

    public TypeEntity findByNum(int num);
}

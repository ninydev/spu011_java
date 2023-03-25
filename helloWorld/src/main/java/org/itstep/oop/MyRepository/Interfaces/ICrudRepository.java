package org.itstep.oop.MyRepository.Interfaces;

public interface ICrudRepository <TypeId, TypeEntity> extends
        ICreateRepository <TypeId, TypeEntity>,
        IReadRepository <TypeId, TypeEntity>,
        IUpdateRepository <TypeId, TypeEntity>,
        IDeleteRepository <TypeId, TypeEntity>
{
}

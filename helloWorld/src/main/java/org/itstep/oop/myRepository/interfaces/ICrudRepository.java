package org.itstep.oop.myRepository.interfaces;

public interface ICrudRepository <TypeId, TypeEntity> extends
        ICreateRepository <TypeId, TypeEntity>,
        IReadRepository <TypeId, TypeEntity>,
        IUpdateRepository <TypeId, TypeEntity>,
        IDeleteRepository <TypeId, TypeEntity>
{
}

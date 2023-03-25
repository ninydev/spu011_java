package org.itstep.oop.MyRepository.Interfaces;

public interface ICreateRepository  <TypeId, TypeEntity>
{
    public void create(TypeEntity item);
}

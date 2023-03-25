package org.itstep.oop.myRepository.interfaces;

public interface ICreateRepository  <TypeId, TypeEntity>
{
    public void create(TypeEntity item);
}

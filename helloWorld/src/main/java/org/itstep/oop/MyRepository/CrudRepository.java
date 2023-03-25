package org.itstep.oop.MyRepository;

import org.itstep.oop.MyRepository.Interfaces.ICrudRepository;

import java.util.ArrayList;

public class CrudRepository <TypeId, TypeEntity>
        extends AbstractRepository <TypeId, TypeEntity>
        implements ICrudRepository  <TypeId, TypeEntity>
{
    @Override
    public void create(TypeEntity item) {
        this.items.add(item);

    }

    @Override
    public void delete(TypeEntity item) {
        this.items.remove(item);
    }

    @Override
    public ArrayList<TypeEntity> readAll() {
        return this.items;
    }

    @Override
    public TypeEntity findById(TypeId typeId) {
        return null;
    }

    @Override
    public TypeEntity findByNum(int num) {
        return this.items.get(num);
    }

    @Override
    public void update(TypeEntity item) {
    }
}

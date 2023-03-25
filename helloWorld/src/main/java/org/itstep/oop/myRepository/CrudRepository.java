package org.itstep.oop.myRepository;

import org.itstep.oop.myRepository.interfaces.ICrudRepository;
import org.itstep.oop.myRepository.interfaces.IEntity;

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
    public TypeEntity findById(TypeId id) {
        for (TypeEntity item: items
             ) {
            try {
                IEntity<TypeId> i = (IEntity<TypeId>) item;
                if(i.getId() == id) {
                    return item;
                }
            } catch (Exception ex) {
                System.out.println(" Err find ");
                System.out.println(ex.getMessage());
                return null;
            }
        }
        return null;
    }

    @Override
    public TypeEntity findByIndex(int index) {
        return this.items.get(index);
    }

    @Override
    public void update(TypeEntity item) {
    }
}

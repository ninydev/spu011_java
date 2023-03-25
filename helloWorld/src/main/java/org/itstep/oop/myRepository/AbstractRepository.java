package org.itstep.oop.myRepository;

import java.util.ArrayList;

public abstract class AbstractRepository <TypeId, TypeEntity>
{
    protected ArrayList<TypeEntity> items = new ArrayList<>();

}

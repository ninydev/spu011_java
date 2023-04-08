package org.itstep.models;


import lombok.*;
import org.itstep.repository.interfaces.IEntity;

import java.util.UUID;

@Data
public class User
{
    public User(){
        this.id = UUID.randomUUID();
    }

    private UUID id;
    private String email;
    private String password;

    private int year;
    private String name;

    @ToString.Exclude
    private Group group;



}

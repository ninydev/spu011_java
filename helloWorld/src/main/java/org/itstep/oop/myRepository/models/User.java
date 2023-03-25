package org.itstep.oop.myRepository.models;

import lombok.Data;
import org.itstep.oop.myRepository.interfaces.IEntity;

import java.util.UUID;

@Data
public class User implements IEntity<UUID>
{
    public User() {
        this.id = UUID.randomUUID();
    }

    public User(String email) {
        this();
        this.email = email;
    }
    private UUID id;

    private String email;
}

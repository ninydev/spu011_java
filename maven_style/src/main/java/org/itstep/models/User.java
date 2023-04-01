package org.itstep.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.itstep.repository.interfaces.IEntity;

import java.util.UUID;

@Data
@AllArgsConstructor
public class User implements IEntity<UUID>
{
    public User(){
        this.id = UUID.randomUUID();
    }

    private UUID id;
    private String email;
    private String password;

}

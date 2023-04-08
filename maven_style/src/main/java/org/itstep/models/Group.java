package org.itstep.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.itstep.repository.interfaces.IEntity;

import java.util.HashSet;
import java.util.UUID;

@Data
public class Group  implements IEntity<UUID>
{
    public Group(){
        this.id = UUID.randomUUID();
    }
    private UUID id;
    private String name;

    private HashSet<User> users = new HashSet<>();
}

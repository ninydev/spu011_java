package org.itstep.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.itstep.repository.interfaces.IEntity;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
public class Group
{
    public Group(){
        this.id = UUID.randomUUID();
    }
    private UUID id;
    private String name;

    private HashSet<User> users = new HashSet<>();
}

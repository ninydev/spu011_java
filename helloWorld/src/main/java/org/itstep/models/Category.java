package org.itstep.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
public class Category
{
    private String name;

    private List<Post> posts =  new ArrayList<>();

}

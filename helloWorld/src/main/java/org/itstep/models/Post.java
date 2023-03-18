package org.itstep.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Post implements Cloneable
{
    private String title;

    private Category category;

    @Override
    public Post clone() throws CloneNotSupportedException {
        Post res = new Post();
        res.setTitle(title);
        return res;
    }
}

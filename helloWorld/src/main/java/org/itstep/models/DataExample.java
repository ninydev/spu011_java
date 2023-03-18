package org.itstep.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DataExample {

    public DataExample(int one) {
        this.myVar = one;
        this.someVar = one;
    }
    private int myVar;

    private int someVar;
}

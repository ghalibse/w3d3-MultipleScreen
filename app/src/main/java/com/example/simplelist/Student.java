
package com.example.simplelist;

        import java.util.Objects;

public class Student {

    public String name;
    public long age;
    public double grade;

    @Override
    public String toString() {
        return  name + "  \t" + age + " \t"+ grade;
    }
}

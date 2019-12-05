package org.izv.psp208.apppspresttwosucessivecalls1920.model.data;

public class Table1 {

    private long id;
    private String name;

    public Table1() {
    }

    public Table1(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Table1 setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Table1 setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Table1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

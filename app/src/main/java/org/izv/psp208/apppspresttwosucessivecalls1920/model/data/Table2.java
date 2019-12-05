package org.izv.psp208.apppspresttwosucessivecalls1920.model.data;

public class Table2 {

    private long id, idtable1;
    private String name;

    public Table2() {
    }

    public Table2(long id, long idtable1, String name) {
        this.id = id;
        this.idtable1 = idtable1;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public Table2 setId(long id) {
        this.id = id;
        return this;
    }

    public long getIdtable1() {
        return idtable1;
    }

    public Table2 setIdtable1(long idtable1) {
        this.idtable1 = idtable1;
        return this;
    }

    public String getName() {
        return name;
    }

    public Table2 setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "Table2{" +
                "id=" + id +
                ", idtable1=" + idtable1 +
                ", name='" + name + '\'' +
                '}';
    }
}

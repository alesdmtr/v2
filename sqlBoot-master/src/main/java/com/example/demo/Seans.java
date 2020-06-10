package com.example.demo;


import java.util.Objects;
import java.util.StringJoiner;

public class Seans {

    private Long id;
    private String zal;
    private String name;
    private String seanstime;

    public Seans() {
    }

    public Seans(Long id, String zal, String name, String seanstime) {
        this.id = id;
        this.zal = zal;
        this.name = name;
        this.seanstime = seanstime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getzal() {
        return zal;
    }

    public void setzal(String zal) {
        this.zal = zal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getseanstime() {
        return seanstime;
    }

    public void setseanstime(String seanstime) {
        this.seanstime = seanstime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seans seans = (Seans) o;
        return seanstime == seans.seanstime &&
                Objects.equals(id, seans.id) &&
                Objects.equals(name, seans.name) &&
                Objects.equals(zal, seans.zal);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, zal, name, seanstime);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Seans.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("zal=" + zal)
                .add("name='" + name + "'")
                .add("seanstime='" + seanstime+ "'")
                .toString();
    }
}
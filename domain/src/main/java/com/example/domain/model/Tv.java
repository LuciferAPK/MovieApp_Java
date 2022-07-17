package com.example.domain.model;

public class Tv {
    private int id;
    private String name;
    private String first_air_date;
    private String poster_path;
    private String type;

    public Tv(int id, String name, String first_air_date, String poster_path, String type) {
        this.id = id;
        this.name = name;
        this.first_air_date = first_air_date;
        this.poster_path = poster_path;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_air_date() {
        return first_air_date;
    }

    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String backdrop_path) {
        this.poster_path = backdrop_path;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Tv{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", first_air_date='" + first_air_date + '\'' +
                ", backdrop_path='" + poster_path + '\'' +
                '}';
    }
}

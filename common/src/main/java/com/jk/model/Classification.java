package com.jk.model;

import java.util.List;

public class Classification {

    private Integer id;
    private String text;
    private Integer petLevel;
    private Integer petPid;
    private List<Classification> nodes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getPetLevel() {
        return petLevel;
    }

    public void setPetLevel(Integer petLevel) {
        this.petLevel = petLevel;
    }

    public Integer getPetPid() {
        return petPid;
    }

    public void setPetPid(Integer petPid) {
        this.petPid = petPid;
    }

    public List<Classification> getNodes() {
        return nodes;
    }

    public void setNodes(List<Classification> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Classification{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", petLevel=" + petLevel +
                ", petPid=" + petPid +
                ", nodes=" + nodes +
                '}';
    }
}

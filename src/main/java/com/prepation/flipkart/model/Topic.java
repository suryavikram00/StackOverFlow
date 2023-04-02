/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.flipkart.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author NMSLAP570
 */
public class Topic {
    
    private String name;
    
    private List<Query> queryList;

    public Topic(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Topic other = (Topic) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Topic{" + "name=" + name + '}';
    }

    public List<Query> addQuery(Query query) {
        if(this.queryList == null){
            this.queryList = new LinkedList<>();
        }
        this.queryList.add(query);
        return queryList;
    }
    
    public List<Query> getQueryList() {
        if(this.queryList == null){
            this.queryList = new LinkedList<>();
        }
        return queryList;
    }

    public String getName() {
        return name;
    }
    
    
    
}

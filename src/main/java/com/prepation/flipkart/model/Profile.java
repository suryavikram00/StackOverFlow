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
public class Profile {
    
    private String name;
    
    private String profession;
    
    private List<Topic> subscribedTopicList;
    
    private Boolean loggedIn;
    
    private List<Query> queryPosted;
       

    public Profile(String name, String profession) {
        this.name = name;
        this.profession = profession;
    }

    public String getName() {
        return name;
    }

    public String getProfession() {
        return profession;
    }
    
    public List<Topic> addSubscribedTopicList(Topic topic) {
        if(this.subscribedTopicList == null){
            this.subscribedTopicList = new LinkedList<>();
        }
        this.subscribedTopicList.add(topic);
        return subscribedTopicList;
    }
    

    public List<Topic> getSubscribedTopicList() {
        if(this.subscribedTopicList == null){
            this.subscribedTopicList = new LinkedList<>();
        }
        return subscribedTopicList;
    }

     public List<Query> addQueryPosted(Query query) {
        if(this.queryPosted == null){
            this.queryPosted = new LinkedList<>();
        }        
        this.queryPosted.add(query);
        return queryPosted;
    }
    
    public List<Query> getQueryPosted() {
        if(this.queryPosted == null){
            this.queryPosted = new LinkedList<>();
        }        
        return queryPosted;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.name);
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
        final Profile other = (Profile) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profile{" + "name=" + name + ", profession=" + profession + '}';
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
    
    
    
}

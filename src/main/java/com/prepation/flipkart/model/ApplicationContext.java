/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.flipkart.model;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public class ApplicationContext {

    private List<Profile> profileList;

    private List<Topic> topicList;
    
    private List<Query> queryList;

    public List<Profile> addProfile(Profile profile) {
        if (this.profileList == null) {
            this.profileList = new LinkedList<>();
        }
        this.profileList.add(profile);
        return this.profileList;
    }

    public List<Profile> getProfileList() {
        if (this.profileList == null) {
            this.profileList = new LinkedList<>();
        }
        return profileList;
    }

    public List<Topic> addTopic(Topic topic) {
        if (this.topicList == null) {
            this.topicList = new LinkedList<>();
        }
        this.topicList.add(topic);
        return this.topicList;

    }

    public List<Topic> getTopicList() {
        if (this.topicList == null) {
            this.topicList = new LinkedList<>();
        }
        return topicList;
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

    public void setQueryList(List<Query> queryList) {
        this.queryList = queryList;
    }

}

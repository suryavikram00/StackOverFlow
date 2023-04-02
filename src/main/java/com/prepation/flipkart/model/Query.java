/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.flipkart.model;

import com.prepation.flipkart.utility.UtilityImpl;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author NMSLAP570
 */
public class Query {
    
    private String question;
    
    private List<Topic> topicList;
    
    private List<Answer> answerList;
    
    private Profile createdUser;
    
    private Integer upvote;

    public Query(String question, List<Topic> topicList) {
        this.question = question;
        this.topicList = topicList;
        this.createdUser = UtilityImpl.loggedInUser();
        this.upvote = 0;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.question);
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
        final Query other = (Query) obj;
        if (!Objects.equals(this.question, other.question)) {
            return false;
        }
        return true;
    }

   public List<Answer> addAnswer(Answer answer) {
        if(this.answerList == null){
            this.answerList = new LinkedList<>();
        }
        this.answerList.add(answer);
        return answerList;
    } 
  

    public List<Answer> getAnswerList() {
        if(this.answerList == null){
            this.answerList = new LinkedList<>();
        }
        return answerList;
    }

    @Override
    public String toString() {
        return "Query{" + "question=" + question + ", topicList=" + topicList + ", answerList=" + answerList + ", createdUser=" + createdUser + ", upvote=" + upvote + '}';
    }

    public Profile getCreatedUser() {
        return createdUser;
    }

    public List<Topic> getTopicList() {
        if(this.topicList == null){
            this.topicList = new LinkedList<>();
        }
        return topicList;
    }

    

   
    
    
}

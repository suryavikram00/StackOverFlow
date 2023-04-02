/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.flipkart.model;

import com.prepation.flipkart.utility.UtilityImpl;
import java.util.Objects;

/**
 *
 * @author NMSLAP570
 */
public class Answer {
    
    private String description;
    
    private Boolean isCorrectAnswer;
    
    private Profile answeredBy;
    
    private Query query;        
    
    private Integer upvote;

    public Answer(String description, Query query) {
        this.description = description;
        this.answeredBy = UtilityImpl.loggedInUser();
        this.query = query;
        this.upvote = 0;
        this.isCorrectAnswer = Boolean.FALSE;
        
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.description);
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
        final Answer other = (Answer) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Answer{" + "description=" + description + ", isCorrectAnswer=" + isCorrectAnswer + ", answeredBy=" + answeredBy + ", upvote=" + upvote + '}';
    }

    public void setIsCorrectAnswer(Boolean isCorrectAnswer) {
        this.isCorrectAnswer = isCorrectAnswer;
    }

    public void setUpvote(Integer upvote) {
        this.upvote = upvote;
    }

    public Integer getUpvote() {
        return upvote;
    }

    
    
}

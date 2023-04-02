/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.prepation.flipkart.service;

import com.prepation.flipkart.model.Answer;
import com.prepation.flipkart.model.Profile;
import com.prepation.flipkart.model.Query;
import com.prepation.flipkart.model.Topic;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public interface IOverFlowService {
    
    public Profile signUp(String name, String profession);
    
    public List<Topic> subscribe(List<String> topic);
    
    public Query addQuery(String question, List<String> topic);
    
    public List<Query> showFeed(List<String> topicList, Boolean answered);
    
    public Query showQuestion(String question);
    
    public Answer answerQuestion(String question, String answer);
    
    public Answer acceptAnswer(String question, String answer);
    
    public Answer upvoteAnswer(String question, String answer);
    
    public Profile showProfile(String name);
    
    
    
}

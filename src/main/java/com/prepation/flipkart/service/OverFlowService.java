/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.flipkart.service;

import com.prepation.flipkart.Driver;
import com.prepation.flipkart.model.Answer;
import com.prepation.flipkart.model.Profile;
import com.prepation.flipkart.model.Query;
import com.prepation.flipkart.model.Topic;
import com.prepation.flipkart.utility.UtilityImpl;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author NMSLAP570
 */
public class OverFlowService implements IOverFlowService {

    @Override
    public Profile signUp(String name, String profession) {
        System.out.println("trying to sign up : " + name);
        Profile profile = new Profile(name, profession);
        Driver.APPLICATION_CONTEXT.addProfile(profile);

        // login the user
        UtilityImpl.login(name);
        System.out.println("signed up & logged in user : " + name);
        return profile;
    }

    @Override
    public List<Topic> subscribe(List<String> topic) {
        for (String topicName : topic) {
            Topic eachTopic = new Topic(topicName);

            // if topic not present then add
            if (!Driver.APPLICATION_CONTEXT.getTopicList().contains(eachTopic)) {
                Driver.APPLICATION_CONTEXT.addTopic(eachTopic);
            }
            // add the topic to the profile
            UtilityImpl.loggedInUser().addSubscribedTopicList(eachTopic);
        }
        System.out.println("User : " + UtilityImpl.loggedInUser() + " has been subscribed to the topics : "
                + Arrays.toString(topic.toArray()));
        return Driver.APPLICATION_CONTEXT.getTopicList();
    }

    @Override
    public Query addQuery(String question, List<String> topicName) {
        System.out.println("Trying to add question : " + question);
        // get the topic object list using topic name
        List<Topic> topicList = new LinkedList<>();
        for (String eachTopicName : topicName) {
            topicList.add(Driver.APPLICATION_CONTEXT.getTopicList().get(
                    Driver.APPLICATION_CONTEXT.getTopicList().indexOf(new Topic(eachTopicName))
            ));
        }

        // create query
        Query query = new Query(question, topicList);

        // against each topic object add the query
        for (Topic eachTopic : topicList) {
            eachTopic.addQuery(query);
        }

        Driver.APPLICATION_CONTEXT.getQueryList().add(query);

        // against profile add the question asked
        UtilityImpl.loggedInUser().addQueryPosted(query);
        System.out.println("Successfully added the question : " + question);
        return query;
    }

    @Override
    public List<Query> showFeed(List<String> topicName, Boolean answered) {

        System.out.println("Generating the feed for user : " + UtilityImpl.loggedInUser().getName());

        // get all the topics
        List<Topic> topicList = Driver.APPLICATION_CONTEXT.getTopicList();

        List<Topic> filteredTopic = new LinkedList<>();
        filteredTopic.addAll(topicList);

        // filter by the topic
        if (!topicName.isEmpty()) {
            for (Topic eachTopic : topicList) {
                if (!topicName.contains(eachTopic.getName())) {
                    filteredTopic.remove(eachTopic);
                }
            }
        }

        // get all the list of queries filtered by topics
        List<Query> filteredQueryList = new LinkedList<>();
        List<Query> queryList = new LinkedList<>();
        for (Topic eachTopic : filteredTopic) {

            for (Query eachQuery : eachTopic.getQueryList()) {
                if (!queryList.contains(eachQuery)) {
                    queryList.add(eachQuery);
                }
            }

        }
        filteredQueryList.addAll(queryList);

        
        
        // filter by the answer flag
        if (answered != null) {
            for (Query eachQuery : queryList) {
                if (answered && eachQuery.getAnswerList().isEmpty()) {
                    filteredQueryList.remove(eachQuery);
                } else if (!answered && !eachQuery.getAnswerList().isEmpty()) {
                    filteredQueryList.remove(eachQuery);
                }
            }
        }
        System.out.println(Arrays.toString(filteredQueryList.toArray()));
        System.out.println("End of the Feed");
        return filteredQueryList;
    }

    @Override
    public Answer answerQuestion(String question, String answer) {
        System.out.println("trying to answer Question : " + question + " with answer : " + answer);
        // get the query
        Query query = Driver.APPLICATION_CONTEXT.getQueryList().get(
                Driver.APPLICATION_CONTEXT.getQueryList().indexOf(new Query(question, null))
        );

        // create a answer
        Answer answerObject = new Answer(answer, query);

        // add the answer to the list of answer in the query object
        query.addAnswer(answerObject);

        System.out.println("Answer has been updated for Question : " + question + " with answer : " + answer);
        return answerObject;
    }

    @Override
    public Answer acceptAnswer(String question, String answer) {
        System.out.println("Trying to accept the answer : " + answer + " | question : " + question);
        Query query = Driver.APPLICATION_CONTEXT.getQueryList().get(
                Driver.APPLICATION_CONTEXT.getQueryList().indexOf(new Query(question, null))
        );

        if (!query.getCreatedUser().equals(UtilityImpl.loggedInUser())) {
            System.out.println("User cannot accept the answer as he haven't posted this question!");
            return null;
        }

        Answer answerObject = query.getAnswerList().get(
                query.getAnswerList().indexOf(new Answer(answer, query))
        );

        answerObject.setIsCorrectAnswer(Boolean.TRUE);
        System.out.println("Successfully accepted the answer : " + answer + " | question : " + question);
        return answerObject;
    }

    @Override
    public Answer upvoteAnswer(String question, String answer) {
        System.out.println("Trying to the upvote the answer : " + answer + " | question : " + question);
        Query query = Driver.APPLICATION_CONTEXT.getQueryList().get(
                Driver.APPLICATION_CONTEXT.getQueryList().indexOf(new Query(question, null))
        );

        // user can upvote an answer only if the user is subscriped to the topic
        List<Topic> queryTopicList = query.getTopicList();

        List<Topic> loggedInUserTopicList = UtilityImpl.loggedInUser().getSubscribedTopicList();

        Boolean isQueryAndUserTopicMatched = Boolean.FALSE;

        // if there no convergence then the user cannot upvote
        for (Topic eachTopic : queryTopicList) {
            if (loggedInUserTopicList.contains(eachTopic)) {
                isQueryAndUserTopicMatched = Boolean.TRUE;
            }
        }

        if (!isQueryAndUserTopicMatched) {
            System.out.println("User cannot upvote as he haven't been subscribed to any of the query's topic");
            return null;
        }

        Answer answerObject = query.getAnswerList().get(
                query.getAnswerList().indexOf(new Answer(answer, query))
        );
        answerObject.setUpvote(answerObject.getUpvote() + 1);
        System.out.println("Sucessfully upvoted the answer : " + answer + " | question : " + question);
        return answerObject;
    }

    @Override
    public Profile showProfile(String name) {
        System.out.println("In show profile : " + name);
        Profile profile = Driver.APPLICATION_CONTEXT.getProfileList().get(
                Driver.APPLICATION_CONTEXT.getProfileList().indexOf(new Profile(name, null))
        );

        System.out.println(profile);

        return profile;
    }

    @Override
    public Query showQuestion(String question) {
        System.out.println("In show question method");
        Query query = Driver.APPLICATION_CONTEXT.getQueryList().get(
                Driver.APPLICATION_CONTEXT.getQueryList().indexOf(new Query(question, null))
        );
        // print the query
        System.out.println(query.toString());
        return query;
    }

}

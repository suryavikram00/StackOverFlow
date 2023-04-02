/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.flipkart;

import com.prepation.flipkart.model.ApplicationContext;
import com.prepation.flipkart.service.IOverFlowService;
import com.prepation.flipkart.service.OverFlowService;
import com.prepation.flipkart.utility.UtilityImpl;
import java.util.Arrays;
import java.util.LinkedList;
import org.junit.Test;

/**
 *
 * @author NMSLAP570
 */
public class Driver {

    public static final ApplicationContext APPLICATION_CONTEXT = new ApplicationContext();

    public static void main(String args[]) {

        IOverFlowService overFlowService = new OverFlowService();

        overFlowService.signUp("Sachin", "Developer");

        // we can user proxy to check the logged in user at every stage
        overFlowService.subscribe(Arrays.asList(new String[]{"java", "hadoop", "jdk"}));
        
        overFlowService.addQuery("What are new open source jdks?", Arrays.asList(new String[]{"java", "jdk"}));
        overFlowService.addQuery("Does Hadoop work on JDK 11?", Arrays.asList(new String[]{"hadoop", "jdk"}));
        
        overFlowService.showFeed(new LinkedList<>(), null);
        overFlowService.showFeed(Arrays.asList(new String[]{"java"}), null);
        overFlowService.showFeed(Arrays.asList(new String[]{"jdk"}), null);
        overFlowService.showFeed(new LinkedList<>(), Boolean.TRUE);
        
        UtilityImpl.logoutProfile();
        
        overFlowService.signUp("Kalyan", "Developer");
        
        overFlowService.subscribe(Arrays.asList(new String[]{"apache", "hadoop"}));
        
        overFlowService.showFeed(new LinkedList<>(), null);
        
        overFlowService.addQuery("Does Apache Spark support streaming of data from hdfs?", 
                Arrays.asList(new String[]{"apache", "hadoop"}));
        
        overFlowService.answerQuestion("Does Hadoop work on JDK 11?", "Yeah Hadoop 3 and above supports it.");
        
        overFlowService.showFeed(new LinkedList<>(), null);
        
        UtilityImpl.logoutProfile();
        
        overFlowService.signUp("Lokesh", "Developer");
        
        overFlowService.subscribe(Arrays.asList(new String[]{"apache", "hadoop", "java"}));
        
        overFlowService.showFeed(new LinkedList<>(), null);
        
        overFlowService.showQuestion("Does Hadoop work on JDK 11?");
        
        overFlowService.acceptAnswer("Does Hadoop work on JDK 11?", "Yeah Hadoop 3 and above supports it.");
        
        overFlowService.upvoteAnswer("Does Hadoop work on JDK 11?", "Yeah Hadoop 3 and above supports it.");

        UtilityImpl.logoutProfile();
        
        UtilityImpl.login("Sachin");
        
        overFlowService.showFeed(new LinkedList<>(), null);
        
        overFlowService.showProfile("Kalyan");
        
        overFlowService.showFeed(new LinkedList<>(), Boolean.TRUE);
        
        UtilityImpl.logoutProfile();        
        
    }

}

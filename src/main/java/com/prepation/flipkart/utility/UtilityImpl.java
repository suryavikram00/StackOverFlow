/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.prepation.flipkart.utility;

import com.prepation.flipkart.Driver;
import com.prepation.flipkart.model.Profile;

/**
 *
 * @author NMSLAP570
 */
public class UtilityImpl {

    private static Profile loggedInProfile = null;

    public static Profile login(String name) {
        Profile profile = Driver.APPLICATION_CONTEXT.getProfileList().get(
                Driver.APPLICATION_CONTEXT.getProfileList().indexOf(new Profile(name, null)));
        profile.setLoggedIn(Boolean.TRUE);
        loggedInProfile = profile;
        return profile;
    }

    public static Profile logoutProfile() {
        Profile profile = Driver.APPLICATION_CONTEXT.getProfileList().get(
                Driver.APPLICATION_CONTEXT.getProfileList().indexOf(loggedInUser()));
        profile.setLoggedIn(Boolean.FALSE);
        loggedInProfile = null;
        return profile;
    }

    public static Profile loggedInUser() {
        return loggedInProfile;
    }

}

package com.accordion.testcases;

import org.testng.annotations.Test;

import Accordion.Accordion.loginURL;
import Accordion.Accordion.socialUpdateTab;

public class TC79SocialUpdateCheckRatingExperiencesoptiondropdown extends loginURL
{
	@Test(priority = 27)
	public void CheckRatingExperiencesoptiondropdownTC79()
	{
		socialUpdateTab.socialupdate();
		socialUpdateTab.ratingExperiencesoption();
	}
}

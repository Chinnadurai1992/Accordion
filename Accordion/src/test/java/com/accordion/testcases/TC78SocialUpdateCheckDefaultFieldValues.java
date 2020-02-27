package com.accordion.testcases;

import org.testng.annotations.Test;

import Accordion.Accordion.loginURL;
import Accordion.Accordion.socialUpdateTab;

public class TC78SocialUpdateCheckDefaultFieldValues extends loginURL
{
	@Test(priority = 26)
	public void CheckDefaultFieldValuesTC78()
	{
		socialUpdateTab.socialupdate();
		socialUpdateTab.ratingDropdownDefaultValue();
		socialUpdateTab.commentdefault();
	}
}

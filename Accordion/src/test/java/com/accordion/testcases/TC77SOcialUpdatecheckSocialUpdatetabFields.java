package com.accordion.testcases;

import org.testng.annotations.Test;

import Accordion.Accordion.loginURL;
import Accordion.Accordion.socialUpdateTab;

public class TC77SOcialUpdatecheckSocialUpdatetabFields extends loginURL 
{
	@Test(priority = 25)
	public void checkSocialUpdatetabFieldsTC77()
	{
		socialUpdateTab.socialupdate();
		socialUpdateTab.socialupdatefields();
	}
}

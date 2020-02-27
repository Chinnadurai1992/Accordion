package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.socialUpdateTab;
import Accordion.Accordion.webPart;

public class TC76SocialUpdateCheckSocialUpdatestabUnderWizard extends loginURL
{
	@Test(priority = 24)
	public void CheckSocialUpdatestabUnderWizardTC76() throws Exception
	{
//		webPart.webpartAdded();
//		webPart.menu();
//		webPart.EditWizard();
		socialUpdateTab.socialupdatePresent();
	}
}

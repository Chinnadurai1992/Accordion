package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.manageTitleTab;
import Accordion.Accordion.webPart;

public class TC13CheckTitlePreviewWithNormalUser extends loginURL
{
	@Test(priority = 13)
	public void CheckTitlePreviewWithNormalUserTC13() throws Exception
	{
		//loginURL.openChromeBrowser();
		loginURL.loginNormalUser();
		webPart.webpartAdded();
		manageTitleTab.apptitleBankPreviewNormalUser();
		loginURL.closeChromeBrowser();
	}	
}

package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.deleteTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC59DeleteCheckStatusRecordAfterDeletion extends loginURL
{
	@Test(priority = 38)
	public void DeleteCheckStatusRecordAfterDeletionTC59() throws Exception
	{
		deleteTab.deletetab();
		deleteTab.deleteItemPresent();
		webPart.closeWizard();
		webPart.webpartDefaultMsgNormalUser();
	}	
}

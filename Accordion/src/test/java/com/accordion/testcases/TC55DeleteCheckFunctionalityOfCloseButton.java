package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.deleteTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC55DeleteCheckFunctionalityOfCloseButton extends loginURL
{
	@Test(priority = 36)
	public void DeleteCheckFunctionalityOfCloseButtonTC55() throws Exception
	{
		webPart.webpartAdded();
		webPart.menu();
		webPart.EditWizard();
		deleteTab.deletetab();
		deleteTab.deleteClosebtn();
	}	
}

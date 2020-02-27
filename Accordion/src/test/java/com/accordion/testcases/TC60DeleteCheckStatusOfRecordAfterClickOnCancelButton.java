package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.deleteTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC60DeleteCheckStatusOfRecordAfterClickOnCancelButton extends loginURL
{
	@Test(priority = 37)
	public void DeleteCheckStatusOfRecordAfterClickOnCancelButton60() throws Exception
	{
		webPart.webpartAdded();
		webPart.menu();
		webPart.EditWizard();
		deleteTab.deletetab();
		deleteTab.deleteAlertCancel();
	}	
}

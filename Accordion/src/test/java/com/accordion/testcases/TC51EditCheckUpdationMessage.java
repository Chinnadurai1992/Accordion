package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.editTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC51EditCheckUpdationMessage extends loginURL
{
	@Test(priority = 30)
	public void EditCheckUpdationMessageTC51() throws Exception
	{
		editTab.edittab();
		editTab.editItemTitle();
		editTab.editItemDescription();
		editTab.editUpdatebtn();
		editTab.editUpdateClosebtn();
		webPart.closeWizard();
		editTab.editedItemOnPreview();
	}	
}

package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.editTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC52EditCheckValidationMessageOnClickOfUpdateButtonOnBlank extends loginURL
{
	@Test(priority = 31)
	public void EditCheckValidationMessageOnClickOfUpdateButtonOnBlankTC52() throws Exception
	{
		webPart.webpartAdded();
		webPart.menu();
		webPart.EditWizard();
		editTab.edittab();
		editTab.editlinkbtn();
		editTab.editlinkfieldBlank();
	}	
}

package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.editTab;
import Accordion.Accordion.loginURL;


public class TC47EditCheckFunctionalityOfDisableCheckBoxDefault extends loginURL
{
	@Test(priority = 26)
	public void EditCheckFunctionalityOfDisableCheckBoxDefaultTC47() throws Exception
	{
		editTab.edittab();
		editTab.editDefaultCheckbox();
	}	
}

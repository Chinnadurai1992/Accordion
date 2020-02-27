package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.editTab;
import Accordion.Accordion.loginURL;

public class TC50EditCheckFunctionalityOfCancelButton extends loginURL
{
	@Test(priority = 29)
	public void EditCheckFunctionalityOfCancelButtonTC50() throws Exception
	{
		editTab.edittab();
		editTab.editItemCancelbtn();
	}	
}

package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.reorderTab;

public class TC62ReOrderCheckFunctionalityOfCloseButton extends loginURL
{
	@Test(priority = 32)
	public void ReOrderCheckFunctionalityOfCloseButtonTC62() throws Exception
	{
		reorderTab.reordertab();
		reorderTab.reorderClosebtn();
	}	
}

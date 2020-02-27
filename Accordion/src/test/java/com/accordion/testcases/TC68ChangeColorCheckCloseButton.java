package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.changeColorTab;
import Accordion.Accordion.loginURL;

public class TC68ChangeColorCheckCloseButton extends loginURL
{
	@Test(priority = 34)
	public void ChangeColorCheckCloseButtonTC68() throws Exception
	{
		changeColorTab.changecolorTab();
		changeColorTab.changecolorClosebtn();
	}	
}

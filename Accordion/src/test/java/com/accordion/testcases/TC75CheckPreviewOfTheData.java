package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.addTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC75CheckPreviewOfTheData extends loginURL
{
	@Test(priority = 35)
	public void CheckPreviewOfTheDataTC75() throws Exception
	{
		webPart.webpartAdded();
		addTab.addAppPreview();
	}	
}

package com.accordion.testcases;

import org.testng.annotations.Test;

import Accordion.Accordion.changeColorTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC73ChangeColorCheckContentFontColor extends loginURL
{
	@Test(priority = 38)
	public void changecolor_CheckContentFontColorTC73() throws Exception
	{
		webPart.webpartAdded();
		webPart.menu();
		webPart.EditWizard();
		changeColorTab.changecolorTab();
		changeColorTab.contentFontChangecolor();
		changeColorTab.changecolorSavebtn();
		changeColorTab.changecolorSaveClosebtn();
		changeColorTab.changecolorClosebtn();
		changeColorTab.contentFontColorPreview();
	}
}

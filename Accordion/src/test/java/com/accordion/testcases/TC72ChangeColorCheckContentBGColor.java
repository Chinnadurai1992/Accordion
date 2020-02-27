package com.accordion.testcases;

import org.testng.annotations.Test;

import Accordion.Accordion.changeColorTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC72ChangeColorCheckContentBGColor extends loginURL
{
	@Test(priority = 37)
	public void changecolor_CheckContentBGColorTC72() throws Exception
	{
		webPart.webpartAdded();
		webPart.menu();
		webPart.EditWizard();
		changeColorTab.changecolorTab();
		changeColorTab.contentBGChangecolor();
		changeColorTab.changecolorSavebtn();
		changeColorTab.changecolorSaveClosebtn();
		changeColorTab.changecolorClosebtn();
		changeColorTab.contentBGColorPreview();
	}
}

package com.accordion.testcases;

import org.testng.annotations.Test;

import Accordion.Accordion.changeColorTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC70ChangeColorCheckHeaderBGColor extends loginURL
{
	@Test(priority = 35)
	public void changecolor_CheckHeaderBGColorTC70() throws Exception
	{
		webPart.webpartAdded();
		webPart.menu();
		webPart.EditWizard();
		changeColorTab.changecolorTab();
		changeColorTab.headerBGChangecolor();
		changeColorTab.changecolorSavebtn();
		changeColorTab.changecolorSaveClosebtn();
		changeColorTab.changecolorClosebtn();
		changeColorTab.headerBGColorPreview();
	}
}

package com.accordion.testcases;

import org.testng.annotations.Test;

import Accordion.Accordion.changeColorTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC71ChangeColorCheckHeaderFontColor extends loginURL
{
	@Test(priority = 36)
	public void changecolor_CheckHeaderFontColorTC71() throws Exception
	{
		webPart.webpartAdded();
		webPart.menu();
		webPart.EditWizard();
		changeColorTab.changecolorTab();
		changeColorTab.headerFontChangecolor();
		changeColorTab.changecolorSavebtn();
		changeColorTab.changecolorSaveClosebtn();
		changeColorTab.changecolorClosebtn();
		changeColorTab.headerFontColorPreview();
	}
}

package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.changeColorTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC69ChangeColorCheckColorPicker extends loginURL
{
	@Test(priority = 34)
	public void ChangeColor_CheckColorPickerTC69() throws Exception
	{
//		webPart.webpartAdded();
//		webPart.menu();
//		webPart.EditWizard();
		
		changeColorTab.changecolorTab();
		changeColorTab.titleFontChangecolor();
		changeColorTab.changecolorSavebtn();
		changeColorTab.changecolorSaveClosebtn();
		changeColorTab.changecolorClosebtn();

		changeColorTab.titleFontColorPreview();

	}	
}

package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.editTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.reorderTab;

public class TC49EditCheckFunctionalityOfDisableCheckBoxUncheck extends loginURL
{
	@Test(priority = 28)
	public void EditCheckFunctionalityOfDisableCheckBoxUncheckTC49() throws Exception
	{
		editTab.edittab();
		editTab.editDisableCheckboxUnChecked();
		editTab.editUpdatebtn();
		editTab.editUpdateClosebtn();
		reorderTab.reordertab();
		editTab.reorderItemCountDisableCheckBoxUnChecked();
	}	
}

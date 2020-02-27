package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.editTab;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.reorderTab;

public class TC48EditCheckFunctionalityOfDisableCheckBoxChecked extends loginURL
{
	@Test(priority = 27)
	public void EditCheckFunctionalityOfDisableCheckBoxCheckedTC48() throws Exception
	{
		editTab.edittab();
		editTab.editDisableCheckboxChecked();
		editTab.editUpdatebtn();
		editTab.editUpdateClosebtn();
		reorderTab.reordertab();
		editTab.reorderItemCountDisableCheckboxchecked();
	}	
}

package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.reorderTab;
import Accordion.Accordion.webPart;

public class TC65ReOrderCheckSaveWithItemSorting extends loginURL
{
	@Test(priority = 33)
	public void ReOrderCheckSaveWithItemSortingTC65() throws Exception
	{
		webPart.webpartAdded();
		webPart.menu();
		webPart.EditWizard();
		reorderTab.reordertab();
		reorderTab.reorderitem();
		reorderTab.reorderSavebtn();
		reorderTab.reorderSaveClosebtn();
	}	
}

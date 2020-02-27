package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.socialUpdateTab;

public class TC80SocialUpdateCheckCommentCheckboxCheck extends loginURL 
{
	@Test(priority = 28)
	public void CheckCommentCheckboxCheck80() throws Exception
	{
		socialUpdateTab.socialupdate();
		socialUpdateTab.commentcheckboxchecked();
		socialUpdateTab.socialupdateSaveBtn();
		socialUpdateTab.socialupdateSaveCloseBtn();
		socialUpdateTab.socialupdateCloseBtn();
	}
}

package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.socialUpdateTab;

public class TC81SocialUpdateCommentWizardFromPreview extends loginURL
{
  @Test(priority = 29)
  public void socialupdatecommentwizardfrompreview() throws Exception 
  {
	  socialUpdateTab.apppreviewComment();
  }
}

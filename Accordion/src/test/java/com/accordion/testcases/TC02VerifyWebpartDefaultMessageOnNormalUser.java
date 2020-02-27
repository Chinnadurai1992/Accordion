package com.accordion.testcases;

import org.testng.annotations.Test;
import Accordion.Accordion.loginURL;
import Accordion.Accordion.webPart;

public class TC02VerifyWebpartDefaultMessageOnNormalUser extends loginURL
{
 	@Test()
 	public void verifywebPartDefualtMsgOnNormalUser() throws Exception
 	{
 		webPart.webpartAdded();
		webPart.webpartDefaultMsgContentAdmin();
 	}
}

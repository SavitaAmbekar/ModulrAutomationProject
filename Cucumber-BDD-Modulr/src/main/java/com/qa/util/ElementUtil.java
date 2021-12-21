package com.qa.util;

import java.util.concurrent.TimeUnit;

import com.qa.factory.DriverFactory;

public class ElementUtil {
	
	public void waitForElement()
	{
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
	}

}

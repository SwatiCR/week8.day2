package pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods{
	
	public HomePage verifyHomePage() throws IOException {
		try {
			String expText = "Leaftaps - TestLeaf Automation Platform";
			String actText = getDriver().getTitle();
			Assert.assertEquals(actText, expText);
			reportStep("Title is matching","pass");
		} catch (Exception e) {
			reportStep("Title is not matching","fail");
		}
		
		return this;
	}
	
	public MyHome clickCRMSFA() {
		getDriver().findElement(By.linkText("CRM/SFA")).click();
		return new MyHome();
	}
	
}

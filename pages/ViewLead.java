package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import base.ProjectSpecificMethods;

public class ViewLead extends ProjectSpecificMethods{
	
	public ViewLead verifyFirstName() {
		String actText = "Swati";
		String expText = getDriver().findElement(By.id("viewLead_firstName_sp")).getText();
		
		Assert.assertEquals(actText, expText);
		
		return this;
	}

}

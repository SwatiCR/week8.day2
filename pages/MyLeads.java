package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class MyLeads extends ProjectSpecificMethods{
	
	public CreateLead clickCreateLead() {
		getDriver().findElement(By.linkText("Create Lead")).click();
		return new CreateLead();
	}

}

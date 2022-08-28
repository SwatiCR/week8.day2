package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class CreateLead extends ProjectSpecificMethods{
	
	public CreateLead enterFirstName(String firstName) {
		getDriver().findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		return this;
	}

	public CreateLead enterLastName(String lastName) {
		getDriver().findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		return this;
	}

	public CreateLead enterCompanyName(String companyName) {
		getDriver().findElement(By.id("createLeadForm_companyName")).sendKeys(companyName);
		return this;
	}

	public ViewLead clickCreateLead() {
		getDriver().findElement(By.className("smallSubmit")).click();
		return new ViewLead();
	}
}

package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class MyHome extends ProjectSpecificMethods{
	
	public MyLeads clickLeads() {
		getDriver().findElement(By.linkText("Leads")).click();
		return new MyLeads();
	}

}

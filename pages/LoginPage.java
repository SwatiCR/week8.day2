package pages;

import java.io.IOException;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	
	public LoginPage enterUserName(String uName) throws IOException {
		try {
			getDriver().findElement(By.id("username")).sendKeys(uName);
			reportStep("Username is entered successfully","pass");
		}
		catch (Exception e) {
			reportStep("Username is not entered successfully... "+e,"fail");
		}
		
		return this;
	}
	
	public LoginPage enterPassword(String pWord) throws IOException {
		try {
			getDriver().findElement(By.id("password")).sendKeys(pWord);
			reportStep("Passord is entered successfully","pass");
		} catch (Exception e) {
			reportStep("Password is not entered successfully..."+e,"fail");
		}
		return this;
	}
	
	public HomePage clickLogin() throws IOException {
		try {
			getDriver().findElement(By.className("decorativeSubmit")).click();
			reportStep("Login Button is clicked","pass");
		} catch (Exception e) {
			reportStep("Login Button is not clicked...."+e,"fail");
		}
		return new HomePage();
	}

}

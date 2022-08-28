package testCases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class Login extends ProjectSpecificMethods{
	@BeforeTest
	public void setUp() {
		excelFileName = "Login";
		testName = "VerifyLogin";
		testDescription = "Login with positive test data";
		testCategory = "smoke";
		testAuthor = "Swati";
	}
	
	@Test(dataProvider = "fetch")
	public void runTest(String userName,String password) throws IOException {
		LoginPage lp = new LoginPage();
		lp.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.verifyHomePage();
		
		
		
	}
}

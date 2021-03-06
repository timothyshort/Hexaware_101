package freddie.data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import freddie.utilities.Database;
import freddie.utilities.DriverFactory;

public class MortgageLoanTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		driver = DriverFactory.start();
		driver.get("http://sdettraining.com/ldss/ldss/loan");
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test(dataProvider = "getTestData")
	public void mortgageLoanAppTest(String lenderLoanNumber, String sellerName, String financialIntNum, String mortgateDate) throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.name("ctl00$MainContent$txtLenderLoanNumber")).sendKeys(lenderLoanNumber);
		Thread.sleep(500);
		driver.findElement(By.name("ctl00$MainContent$txtSellerName")).sendKeys(sellerName);
		Thread.sleep(500);
		driver.findElement(By.name("ctl00$MainContent$txtFinancialInstitutionNumber")).sendKeys(financialIntNum);
		Thread.sleep(500);
		driver.findElement(By.name("ctl00$MainContent$txtDateOfMortgageNote")).sendKeys(mortgateDate);
		Thread.sleep(500);
		driver.findElement(By.name("ctl00$MainContent$LoanButton"));
		Thread.sleep(500);
	}
	
	@DataProvider
	public Object[][] getTestData() {
		return Database.get("SELECT * FROM MortgageLoanTestData");
	}

}

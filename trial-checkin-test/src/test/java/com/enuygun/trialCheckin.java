package com.enuygun;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class trialCheckin {

	@Test
	public void Test() {
		System.out.println("Starting Trial Checkin test");

		// Create driver
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
		WebDriver driver = new FirefoxDriver();

		sleep(3000);

		// driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// open the page
		String url = "https://www.enuygun.com/";
		driver.get(url);
		sleep(2000);
		System.out.println("Page is opened.");

		WebElement logInButton = driver.findElement(By.cssSelector("div.NavbarAuth > a:nth-child(1)"));
		logInButton.click();

		sleep(2000);

		WebElement usernameClick = driver.findElement(By.cssSelector(".membership--input-custom--size"));
		usernameClick.click();

		sleep(1000);

		WebElement username = driver.findElement(By.name("_email"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(username));
		username.sendKeys("ezgittaner@gmail.com");

		// enter password
		WebElement password = driver.findElement(By.cssSelector(".MuiInputBase01201"));
		password.sendKeys("*****");

		// push log in button
		WebElement logIn = driver.findElement(By.cssSelector(".MuiButton01222"));
		wait.until(ExpectedConditions.elementToBeClickable(logIn));
		logIn.click();

		// new url
		String expectedUrl = "https://www.enuygun.com/#";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl);

		sleep(3000);

		WebElement Ezgi = driver.findElement(By.cssSelector(".align-middle"));
		wait.until(ExpectedConditions.elementToBeClickable(Ezgi));
		Ezgi.click();

		WebElement reservations = driver.findElement(
				By.cssSelector(".dropdown-menu-right > a:nth-child(5) > div:nth-child(2) > span:nth-child(1)"));
		wait.until(ExpectedConditions.elementToBeClickable(reservations));
		reservations.click();

		sleep(3000);

		// new url

		String expectedUrl2 = "https://www.enuygun.com/uyelik/biletler/";
		String actualUrl2 = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl2, expectedUrl2);

		WebElement details = driver.findElement(By.cssSelector(
				"div.MuiPaper01169:nth-child(1) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > a:nth-child(1) > button:nth-child(1) > span:nth-child(1)"));
		details.click();

		sleep(2000);
		WebElement pnr = driver.findElement(By.cssSelector(".flightNotes > div:nth-child(2) > span:nth-child(2)"));
		wait.until(ExpectedConditions.visibilityOfAllElements(pnr));
		String enUygunPnr = pnr.getText();
		System.out.println(pnr.getText());

		sleep(2000);

		// open the another page
		String url2 = "https://www.turkishairlines.com/tr-fr/ucak-bileti/rezervasyonu-yonet/";
		driver.get(url2);
		sleep(2000);
		System.out.println("New page is opened.");

		WebElement setPnr = driver.findElement(By.cssSelector(".delay22"));
		setPnr.click();
		sleep(1000);
		WebElement setPnr2 = driver.findElement(By.cssSelector("#ticketNo"));
		setPnr2.sendKeys(enUygunPnr);

		WebElement setSurname = driver.findElement(By.cssSelector(".delay21"));
		setSurname.click();
		sleep(1000);
		WebElement setSurname2 = driver.findElement(By.cssSelector("#surname"));
		setSurname2.sendKeys("TANER");

		WebElement click2 = driver.findElement(By.cssSelector(".light-arrow-right"));
		click2.click();

		sleep(5000);
		// Close browser
		driver.quit();
	}

	/** Static sleep */
	private void sleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

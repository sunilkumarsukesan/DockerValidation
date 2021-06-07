package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

import org.junit.Assert;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;


public class ChromeTest3 {
	
	@Test
	public void test3() throws MalformedURLException {

		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		// DesiredCapabilities firefox = DesiredCapabilities.firefox(); URL url = new
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, chrome);
		// Alternate
		// RemoteWebDriver driver = new RemoteWebDriver(new
		// URL("http://localhost:4445/wd/hub"),DesiredCapabilities.firefox());
		driver.get("http://facebook.com");
		System.out.println(driver.getTitle());

		// Get Browser name and version.
		Capabilities caps = driver.getCapabilities();
		System.out.println(caps.getBrowserName());
		System.out.println(caps.getVersion());

		// Get OS name.
		System.out.println(System.getProperty("os.name").toLowerCase());
	}
	
}

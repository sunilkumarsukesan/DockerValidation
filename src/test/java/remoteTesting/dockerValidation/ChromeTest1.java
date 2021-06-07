package remoteTesting.dockerValidation;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ChromeTest1 {
	
	@BeforeTest()
	public void startDocker() throws IOException, InterruptedException {
		if (new File("ServerLogs.txt").delete()) {
			System.out.println("Logfile deleted successfully");
		}
		else
		{
			System.out.println("Error");
		}
		
		StartDocker startDocker = new StartDocker();
		startDocker.startDocker();
	}
	

	@AfterTest()
	public void stopDocker() throws IOException, InterruptedException {
		StopDocker stopDocker = new StopDocker();
		stopDocker.endDocker();
	}


	@Test
	public void test1() throws MalformedURLException {

		DesiredCapabilities chrome = DesiredCapabilities.chrome();
		// DesiredCapabilities firefox = DesiredCapabilities.firefox(); URL url = new
		URL url = new URL("http://localhost:4444/wd/hub");
		RemoteWebDriver driver = new RemoteWebDriver(url, chrome);
		// Alternate
		// RemoteWebDriver driver = new RemoteWebDriver(new
		// URL("http://localhost:4445/wd/hub"),DesiredCapabilities.firefox());
		driver.get("http://google.co.in");
		System.out.println(driver.getTitle());

		// Get Browser name and version.
		Capabilities caps = driver.getCapabilities();
		System.out.println(caps.getBrowserName());
		System.out.println(caps.getVersion());

		// Get OS name.
		System.out.println(System.getProperty("os.name").toLowerCase());
	}
	
	
}

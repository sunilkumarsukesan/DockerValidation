package remoteTesting.dockerValidation;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ChromeStandaloneTest {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		ChromeStandaloneTest.runBatchFile("cmd /c start DockerSTAUp.bat");
		 DesiredCapabilities chrome = DesiredCapabilities.chrome();
		 Thread.sleep(5000);
		 //DesiredCapabilities firefox = DesiredCapabilities.firefox(); URL url = new
		 URL url = new URL("http://localhost:4444/wd/hub");
		 RemoteWebDriver driver = new RemoteWebDriver(url,chrome);		
		//Alternate
		//RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"),DesiredCapabilities.firefox());	
		driver.get("http://google.co.in");
		System.out.println(driver.getTitle());
		
						
		//Get Browser name and version.
		Capabilities caps = driver.getCapabilities();
		System.out.println(caps.getBrowserName());
		System.out.println(caps.getVersion());
		  
		//Get OS name.
		System.out.println(System.getProperty("os.name").toLowerCase());	
		ChromeStandaloneTest.runBatchFile("cmd /c start DockerSTADown.bat");
	}
	
	public static void runBatchFile(String BatchFileName) throws IOException {	
		Runtime runtime = Runtime.getRuntime();
		runtime.exec(BatchFileName);	
	}

}

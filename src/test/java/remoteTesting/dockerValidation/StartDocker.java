package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;

public class StartDocker {
		
	public void startDocker() throws IOException, InterruptedException {
				
		boolean flag = false;
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start DockerUp.bat");
		
	
		Calendar calendarInstance = Calendar.getInstance();
		calendarInstance.add(Calendar.SECOND, 30);
		long stopTime = calendarInstance.getTimeInMillis();
		
		while (System.currentTimeMillis() < stopTime) {	
			if (flag) {
				break;
			}
			Thread.sleep(1000);
			BufferedReader bufferedReader = new BufferedReader(new FileReader("ServerLogs.txt"));
			String currentLine = bufferedReader.readLine();
								
			while (currentLine != null) {
				if (currentLine.contains("The node is registered to the hub and ready to use")) {
					System.out.println("Node is up and running");
					flag = true;
					break;
				}
				currentLine = bufferedReader.readLine();
			}
			bufferedReader.close();				
		}
		Thread.sleep(3000);
		Assert.assertTrue(flag);
	}
}

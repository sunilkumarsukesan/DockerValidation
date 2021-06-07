package remoteTesting.dockerValidation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.Assert;


public class StopDocker {

	public void endDocker() throws IOException, InterruptedException {
		Runtime runtime = Runtime.getRuntime();
		runtime.exec("cmd /c start DockerDown.bat");

		boolean flag = false;
		Calendar calendarInstance = Calendar.getInstance();
		calendarInstance.add(Calendar.SECOND, 30);
		long stopTime = calendarInstance.getTimeInMillis();
		
		while (System.currentTimeMillis() < stopTime) {
			
			BufferedReader bufferedReader = new BufferedReader(new FileReader("ServerLogs.txt"));
			String currentLine = bufferedReader.readLine();

			if (flag) {
				break;
			}

			while (currentLine != null) {
				if (currentLine.contains("selenium-hub exited")) {
					System.out.println("Docker is stopped");
					flag = true;
					break;
				}
				currentLine = bufferedReader.readLine();

			}
			bufferedReader.close();
		}
		Assert.assertTrue(flag);
		Thread.sleep(3000);
		}
}

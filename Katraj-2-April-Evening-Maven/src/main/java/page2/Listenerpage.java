package page2;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listenerpage extends BasePage implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("start the test:"+result.getMethod());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("name of success test:"+result.getMethod());
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("name of failure test:"+result.getMethod());
		String name=result.getName();
		capturescreenshot(name);
		
		
	}

}

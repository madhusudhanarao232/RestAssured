package genericUtility;

import java.io.File;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListenerImp implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite Execution has been finished");
		report.flush();
	}

	@Override
	public void onStart(ITestContext context) { 
		System.out.println("Suite Execution has started");
		ExtentSparkReporter htmlreport=new ExtentSparkReporter(".//ExtentReports//reports-"+new JavaUtility().getRequiredDate(0)+".html");
		htmlreport.config().setDocumentTitle("LifeInsurance Reports");
		htmlreport.config().setTheme(Theme.STANDARD);
		htmlreport.config().setReportName("LifeInusranceReport");
		 report=new ExtentReports();
		 report.attachReporter(htmlreport);
		 report.setSystemInfo("Base url","http://rmgtestingserver/domain/Life_Insurance_Management_System/");
		 report.setSystemInfo("Base Browser","chrome");
		 report.setSystemInfo("Reporter name","Prasanna");
		 
		
	}

	

	@Override
	public void onTestFailure(ITestResult result) {
		JavaUtility jlib=new JavaUtility();
		String methodname=	result.getMethod().getMethodName();
	      test.log(Status.FAIL,methodname+"----Fail");
	      test.log(Status.INFO,result.getThrowable());
	      
	      String screenshotname=methodname+"-"+jlib.getRandom();
	      try {
	    	  TakesScreenshot t=(TakesScreenshot)(BaseClass.sdriver);
	    	  File src = t.getScreenshotAs(OutputType.FILE);
	  		LocalDateTime ldt=LocalDateTime.now();
	  		String dateTime = ldt.toString().replace(" : ", "_").replace(":", "_");
	  		File dst = new File("./ScreenShots/"+screenshotname+"_"+dateTime+".png");
	    	FileUtils.copyFile(src, dst);  
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		test.log(Status.FAIL,methodname+"-----Skip");
		test.log(Status.INFO,result.getThrowable());
	}

	@Override
	public void onTestStart(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		System.out.println(methodname+"---Execution has started");
		test=report.createTest(methodname);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodname=result.getMethod().getMethodName();
		test.log(Status.PASS,methodname+"------pass");
		
	}
	
    

}
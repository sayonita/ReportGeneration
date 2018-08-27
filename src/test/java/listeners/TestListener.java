package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
import extentmanager.ExtentTestManager;
import extentmanager.ExtentManager;


public class TestListener implements ITestListener {

    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    //Before starting all tests, below method runs.
    @Override
    public void onStart(ITestContext iTestContext) {

    }

    //After ending all tests, below method runs.
    @Override
    public void onFinish(ITestContext iTestContext) {
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), iTestResult.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        //Extentreports log operation for passed tests.
        ExtentTestManager.getTest().setDescription(iTestResult.getMethod().getDescription());
        ExtentTestManager.getTest().log(LogStatus.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        ExtentTestManager.getTest().setDescription(String.valueOf(iTestResult.getThrowable()));
        ExtentTestManager.getTest().log(LogStatus.FAIL, "Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        ExtentTestManager.getTest().setDescription(String.valueOf(iTestResult.getThrowable()));
        ExtentTestManager.getTest().log(LogStatus.SKIP, "Test Skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }

} 

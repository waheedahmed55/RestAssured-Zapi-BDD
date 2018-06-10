package com.restassured.zapi;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.restassured.util.AppTestBase;

public class ZapiTestBase extends AppTestBase {

	protected String issueID = null;
	protected ZapiTestCaseCreator zapi = null;
	protected String storyID = null;
	protected String desc = null;
	protected String projectkey = "ISPT4";
	protected String issueTypeID = "11000";
	protected String projectID= "16508";
	@BeforeClass
	public void beforeclass()
	{
		String classname = this.getClass().getSimpleName();
		
		setJiraTestCaseParamters();
		setJiraStoryID();
		if(issueID==null)
		{
			issueID = ZapiTestCaseCreator.createTestcase(projectkey, classname, desc, issueTypeID, storyID);
		}
		zapi = new ZapiTestCaseCreator(issueID,projectID);
		zapi.deleteJiraIssueTestExecutions();
	}
	
	public void setJiraStoryID() {
		this.storyID = null;
	}
	
	public void setJiraTestCaseParamters() {
		this.issueID = null;
		this.storyID = null;
		this.desc = "";
	}
	
	@BeforeMethod
	public void beforeMethod(Method method, ITestResult result)
	{
		zapi.beforeInvocation(method, result);
	}

	@AfterMethod
	public void afterMethod(Method method, ITestResult result)
	{
		zapi.afterInvocation(method, result);
	}

}

package com.restassured.zapi;

import static io.restassured.RestAssured.given;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.ITestResult;

public class ZapiTestCaseCreator {
	
 private static final String auth = "Basic username:password";
 private static final String zapiurl= "http://localhost/jira/rest/zapi";
 private static final String executionEndPoint = "/latest/execution";
 private static final String updateexecutionEndPoint = "/execute";
 private static final String createTestcaseEndPoint = "http://localhost/jira/rest/api/2/issue";
 private static final String issueAssignee = "username";

 private static final Map <Integer, Integer> statusMap = new HashMap<>();
 static {
	 statusMap.put(ITestResult.CREATED, -1);
	 statusMap.put(ITestResult.FAILURE, 2);
	 statusMap.put(ITestResult.SKIP, 4);
	 statusMap.put(ITestResult.STARTED, 3);
	 statusMap.put(ITestResult.SUCCESS, 1);
	 statusMap.put(ITestResult.SUCCESS_PERCENTAGE_FAILURE, 2);

 }
 
 private String executionId = null; 
 private String issueID=null;
 private String projectID=null;
 
 
 public ZapiTestCaseCreator()
 {
	 
 }
 public ZapiTestCaseCreator(String issueID, String projectID)
 {
	 this.issueID=issueID;
	 this.projectID= projectID;
 }
 

// Delete all old test executions in JIRA issue 
@SuppressWarnings("unchecked")
public void deleteJiraIssueTestExecutions() {
		
	System.out.println("issueID"+issueID+"projectID"+projectID);
		Map<String, Object> resp = given().baseUri(zapiurl)
				.contentType("application/json")
				.header("Authorization", auth)
				.when()
				.queryParam("issueId", issueID)
				.queryParam("projectId", projectID)
				//.queryParam("versionId", 13918)
				.get(executionEndPoint)
				.then()
				.assertThat().statusCode(200).and()
				.extract().as(Map.class);
		List<Object> executions = (List<Object>) resp.get("executions");
		System.out.println(executions.size());
		for(Object o: executions)
		{
			Map<String,Object> execution = (Map<String, Object>) o;
			Integer ID= (Integer)execution.get("id");
			         given().baseUri(zapiurl)
					.contentType("application/json")
					.header("Authorization", auth)
					.when()
					.delete(executionEndPoint + "/" + ID)
					.then()
					.assertThat().statusCode(200);
		}
 }
 
 	// Create test execution
	@SuppressWarnings("unchecked")
	public void beforeInvocation(Method method, ITestResult testResult) {
	//if(method.isTestMethod()) {
		System.out.println(method.toString());
		System.out.println(statusMap.get(testResult.getStatus()));
		Map <String, Object> payload = new HashMap<>();
		
		payload.put("cycleId", -1);
		payload.put("issueId", Integer.valueOf(issueID));
		payload.put("projectId", Integer.valueOf(projectID));
		payload.put("assigneeType", "assignee");
		payload.put("assignee", issueAssignee);

		Map<String, Object> response = given().baseUri(zapiurl)
					.contentType("application/json")
					.body(payload)
					.header("Authorization", auth)
					.when()
					.post(executionEndPoint)
					.then()
					.assertThat().statusCode(200).and()
					.extract().as(Map.class);
		 
		 executionId = response.keySet().iterator().next();
		
	}
	
	//}

// Set execution status to pass or fail or another mapped status
public void afterInvocation(Method method, ITestResult testResult) {
	//if(method.isTestMethod()) {
		System.out.println(method.toString());
		System.out.println(statusMap.get(testResult.getStatus()));
		//updateexecutionEndPoint
		Map <String, Object> payload = new HashMap<>();
		
		payload.put("status", statusMap.get(testResult.getStatus()));
		payload.put("comment", method.getName());
		
		System.out.println("execution id:" + executionId );
		System.out.println("Path = " + executionEndPoint + executionId + updateexecutionEndPoint);
		
		 String response = given().baseUri(zapiurl)
					.contentType("application/json")
					.body(payload)
					.header("Authorization", auth)
					.when()
					.put(executionEndPoint + "/" + executionId + updateexecutionEndPoint)
					.then()
					.assertThat().statusCode(200).and()
					.extract().asString();
		 System.out.println(response);

	//}

}

// Create test case and links to user story
@SuppressWarnings({ "unused", "unchecked" })
public static String createTestcase(String projKey, String summary, String descp, String issueTypeID, String storyID)
{
	
	
	Map <String, Object> payload = new HashMap<>();
	Map <String, Object> fields = new HashMap<>();
	Map <String, Object> project = new HashMap<>();
	Map <String, Object> issuetype = new HashMap<>();
	

	Map <String, Object> update = new HashMap<>();
	List<Map<String, Object>> issuelinks = new ArrayList<>();
	Map<String, Object> issuelink = new HashMap<>();
	Map<String, Object> add = new HashMap<>();
	Map<String, Object> type = new HashMap<>();
	Map<String, Object> outwardIssue = new HashMap<>();
	issuelink.put("add", add);
	add.put("type", type);
	add.put("outwardIssue", outwardIssue);
	
	type.put("name", "Blocks");
	type.put("inward","is blocked by");
	type.put("outward","blocks");
	
	// hard coded to REST 17 user story
	outwardIssue.put("id", storyID);


	project.put("key", projKey);
	fields.put("summary", summary);
	fields.put("description", descp);
	issuetype.put("id", issueTypeID);

	fields.put("project",project );
	fields.put("issuetype",issuetype );
	
	issuelinks.add(issuelink);
	update.put("issuelinks", issuelinks);
	
	payload.put("fields", fields);
	payload.put("update", update);
	
System.out.println("id"+storyID+"projKey"+projKey+"issueTypeID"+issueTypeID+"project"+project+"issuetype"+issuetype+"issuelinks"+issuelinks);
	 Map<String,Object> response = given().baseUri(createTestcaseEndPoint)
				.contentType("application/json")
				.body(payload)
				.header("Authorization", auth)
				.when()
				.post()
				.then()
				.assertThat().statusCode(201).and()
				.extract().as(Map.class);
	 
	 String id = response.get("id").toString();
		System.out.println("issueid"+id);

	 return id;
	 
}
}

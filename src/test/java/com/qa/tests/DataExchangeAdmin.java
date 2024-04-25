package com.qa.tests;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.IExecutionListener;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.base.TestBase;
import com.qa.client.RestClient;
import com.qa.data.AgencySave;
import com.qa.data.Users;
import com.qa.util.TestUtil;

public class DataExchangeAdmin extends TestBase implements IExecutionListener {

	TestBase testbase;
	RestClient restclient;
	String serviceurl;
	String apiurl;
	String url;
	String token,credentials,APIConnectivity,AdminDashboard,SearchUsersbyName,UserPresent,CustomAttributes,SystmUser,UpdateSystemUser,EnableDisableSystemUser,AgencyDistribution;
	String agency;
	String batchfileupload,batchstatusupdate,historicalbatches,batchdownloadfile,batchdetails,downloadbatchdetails,savebatchdetail,clients;
	String mappings,alertmessage,referenceagency,referencerole,userdisablereason,referencetemplate;
	String landing,failedlogins,activelogins,loginhistory,newaccounts,queryhistory,queryhistoryfiltered,seaechesperformedbyuser,multiauthorization,entitydetails,employeeworkinghours;
	String searchreasons,searchreasonsdetails,linkusers,searchreasonsusers;
	String individualsearchdata,entitysearchdata,monthlyentitysearchdata,monthlyindividualsearchdata,Downloadusagemetricsreport;
	String workflows,totalworkflows,methodfields,savemethodfields,workflowbyclient;
	CloseableHttpResponse closeableHttpResponse;

	@BeforeMethod

	public void setup() throws ClientProtocolException, IOException {
		testbase = new TestBase();
		serviceurl = prop.getProperty("URL");
		credentials = prop.getProperty("credentials");
		credentials = serviceurl + credentials;
		APIConnectivity = prop.getProperty("APIConnectivity");
		APIConnectivity = serviceurl + APIConnectivity;
		AdminDashboard = prop.getProperty("AdminDashboard");
		AdminDashboard = serviceurl + AdminDashboard;
		SearchUsersbyName = prop.getProperty("SearchUsersbyName");
		SearchUsersbyName = serviceurl + SearchUsersbyName;
		UserPresent = prop.getProperty("UserPresent");
		UserPresent = serviceurl + UserPresent;
		CustomAttributes = prop.getProperty("CustomAttributes"); // Get call
		CustomAttributes = serviceurl + CustomAttributes; // Get call
		SystmUser = prop.getProperty("SystmUser");
		SystmUser = serviceurl + SystmUser;
		UpdateSystemUser = prop.getProperty("UpdateSystemUser");
		UpdateSystemUser = serviceurl + UpdateSystemUser;
		EnableDisableSystemUser = prop.getProperty("EnableDisableSystemUser");
		EnableDisableSystemUser = serviceurl + EnableDisableSystemUser;
		AgencyDistribution = prop.getProperty("AgencyDistribution");
		AgencyDistribution = serviceurl + AgencyDistribution;
		
//		Agency
		agency = prop.getProperty("agency");
		agency = serviceurl + agency;
		
//		Batch
		batchfileupload = prop.getProperty("batchfileupload");
		batchfileupload = serviceurl + batchfileupload;
		
		batchstatusupdate = prop.getProperty("batchstatusupdate");
		batchstatusupdate = serviceurl + batchstatusupdate;
		
		historicalbatches = prop.getProperty("historicalbatches");
		historicalbatches = serviceurl + historicalbatches;
		
		batchdownloadfile = prop.getProperty("batchdownloadfile");
		batchdownloadfile = serviceurl + batchdownloadfile;
		
		batchdetails = prop.getProperty("batchdetails");
		batchdetails = serviceurl + batchdetails;
		
		downloadbatchdetails = prop.getProperty("downloadbatchdetails");
		downloadbatchdetails = serviceurl + downloadbatchdetails;
		
		savebatchdetail = prop.getProperty("savebatchdetail");
		savebatchdetail = serviceurl + savebatchdetail;
		
//		Client
		clients = prop.getProperty("clients");
		clients = serviceurl + clients;
		
//		mappings
		mappings = prop.getProperty("mappings");
		mappings = serviceurl + mappings;
		
		
//		Reference
		alertmessage = prop.getProperty("alertmessage");
		alertmessage = serviceurl + alertmessage;
		referenceagency = prop.getProperty("referenceagency");
		referenceagency = serviceurl + referenceagency;
		referencerole = prop.getProperty("referencerole");
		referencerole = serviceurl + referencerole;
		userdisablereason = prop.getProperty("userdisablereason");
		userdisablereason = serviceurl + userdisablereason;
		referencetemplate = prop.getProperty("referencetemplate");
		referencetemplate = serviceurl + referencetemplate;
		
//		Reports
		
		landing = prop.getProperty("landing");
		landing = serviceurl + landing;
		failedlogins = prop.getProperty("failedlogins");
		failedlogins = serviceurl + failedlogins;
		activelogins = prop.getProperty("activelogins");
		activelogins = serviceurl + activelogins;
		loginhistory = prop.getProperty("loginhistory");
		loginhistory = serviceurl + loginhistory;
		newaccounts = prop.getProperty("newaccounts");
		newaccounts = serviceurl + newaccounts;
		queryhistory = prop.getProperty("queryhistory");
		queryhistory = serviceurl + queryhistory;
		queryhistoryfiltered = prop.getProperty("queryhistoryfiltered");
		queryhistoryfiltered = serviceurl + queryhistoryfiltered;
		seaechesperformedbyuser = prop.getProperty("seaechesperformedbyuser");
		seaechesperformedbyuser = serviceurl + seaechesperformedbyuser;
		multiauthorization = prop.getProperty("multiauthorization");
		multiauthorization = serviceurl + multiauthorization;
		entitydetails = prop.getProperty("entitydetails");
		entitydetails = serviceurl + entitydetails;
		employeeworkinghours = prop.getProperty("employeeworkinghours");
		employeeworkinghours = serviceurl + employeeworkinghours;
		
		
//    Search Reason
		
		searchreasons = prop.getProperty("searchreasons");
		searchreasons = serviceurl + searchreasons;
		searchreasonsdetails = prop.getProperty("searchreasonsdetails");
		searchreasonsdetails = serviceurl + searchreasonsdetails;
		linkusers = prop.getProperty("linkusers");
		linkusers = serviceurl + linkusers;
		searchreasonsusers = prop.getProperty("searchreasonsusers");
		searchreasonsusers = serviceurl + searchreasonsusers;
		
//		usage metrics
		
		individualsearchdata = prop.getProperty("individualsearchdata");
		individualsearchdata = serviceurl + individualsearchdata;
		entitysearchdata = prop.getProperty("entitysearchdata");
		entitysearchdata = serviceurl + entitysearchdata;
		monthlyentitysearchdata = prop.getProperty("monthlyentitysearchdata");
		monthlyentitysearchdata = serviceurl + monthlyentitysearchdata;
		monthlyindividualsearchdata = prop.getProperty("monthlyindividualsearchdata");
		monthlyindividualsearchdata = serviceurl + monthlyindividualsearchdata;
		Downloadusagemetricsreport = prop.getProperty("Downloadusagemetricsreport");
		Downloadusagemetricsreport = serviceurl + Downloadusagemetricsreport;
		
		
//		usage metrics
		
		totalworkflows = prop.getProperty("totalworkflows");
		totalworkflows = serviceurl + totalworkflows;
		methodfields = prop.getProperty("methodfields");
		methodfields = serviceurl + methodfields;
		savemethodfields = prop.getProperty("savemethodfields");
		savemethodfields = serviceurl + savemethodfields;
		
	
//		workflows
		workflows = prop.getProperty("workflows");
		workflows = serviceurl + workflows;
		
		totalworkflows = prop.getProperty("totalworkflows");
		totalworkflows = serviceurl + totalworkflows;
		
		workflowbyclient = prop.getProperty("workflowbyclient");
		workflowbyclient = serviceurl + workflowbyclient;
		
			
		
	}
	@Test(priority = 1)
	public void Credentilas() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
//		headermap.put("username", "idealQA");
//		headermap.put("password", "%C922Yj0");
//		headermap.put("client_secret", "1orlfkcif7e15iet49mg1aojvrg5ovq6acmr8ldpdo6p7998neg3");
//		headermap.put("client_id", "6b6iij617t0mrnb1g5v6vua93u");
//		headermap.put("x-api-key", "RT3xMZkRjm5lwbjbV4iO86Izfl8JpZ29qPfvR5eb");

		String jsonpayload = "{\r\n"
				+ "    \"Username\": \"pritsdev\",\r\n"
				+ "    \"Password\": \"prits!@\",\r\n"
				+ "    \"APIKey\": \"456efd38-1ab1-4536-9734-664cba0d8386\",\r\n"
				+ "    \"Email\": \"orivera@prits.pr.gov\"\r\n"
				+ "}";
		

		closeableHttpResponse = restclient.post(credentials, jsonpayload, headermap);


//			//1.GET status code
		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

//			//2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

//			//To get value from JSON Array
		token = TestUtil.getValueByjpath(responseJson, "/access_token");
		System.out.println("Token is : " + token);
//		    			
//			//3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
			allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}
	
	@Test(priority = 2)
	public void Admin_APIConnectivity() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);
		
		closeableHttpResponse = restclient.get(APIConnectivity,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

//		// To get value from JSON Array
		String Admin_AgencyName = TestUtil.getValueByjpath(responseJson, "/data[0]/AgencyName");
		System.out.println("API Connectivity message Response From Json is : " + Admin_AgencyName);
		
		String Admin_AgencyCode = TestUtil.getValueByjpath(responseJson, "/data[0]/AgencyCode");
		System.out.println("API Connectivity message Response From Json is : " + Admin_AgencyCode);

		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}
	
	@Test(priority = 3)
	public void AdminDashboard() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("quarter", "-84472401");
		headermap.put("year", "-84472401");
		headermap.put("Authorization", "Bearer " + token);
		
		closeableHttpResponse = restclient.get(AdminDashboard,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

//		// To get value from JSON Array
		String Dashboard_Type = TestUtil.getValueByjpath(responseJson, "/data[0]/Type");
		System.out.println("API Connectivity message Response From Json is : " + Dashboard_Type);
		

		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}	

	@Test(priority = 4)
	public void Admin_SearchUsersByName() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("name", "dolor aute");
		headermap.put("Authorization", "Bearer " + token);
		
		closeableHttpResponse = restclient.get(SearchUsersbyName,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

		

		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}	

	@Test(priority = 5)
	public void Admin_IsUserPresent() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("mail", "dolor aute");
		headermap.put("Authorization", "Bearer " + token);
		
		closeableHttpResponse = restclient.get(UserPresent,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

		

		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}	

	@Test(priority = 6)
	public void CustomAttributes() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("ascending", "true");
		headermap.put("Authorization", "Bearer " + token);
		
		closeableHttpResponse = restclient.get(CustomAttributes,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

		

		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}	
	
//	@Test(priority = 7)
//	public void CreateSysyemUser() throws ClientProtocolException, IOException {
//		restclient = new RestClient();
//		HashMap<String, String> headermap = new HashMap<String, String>();
//		headermap.put("content-type", "application/json");
//		headermap.put("firstName", "dolor aute");
//		headermap.put("lastName", "dolor aute");
//		headermap.put("mothersLastName", "dolor aute");
//		headermap.put("middleInitials", "dolor aute");
//		headermap.put("displayName", "dolor aute");
//		headermap.put("mail", "dolor aute");
//		headermap.put("agency", "dolor aute");
//		headermap.put("role", "dolor aute");
//		headermap.put("Authorization", "Bearer " + token);
//		
//
//		closeableHttpResponse = restclient.post_nobody(SystmUser, headermap);
//
//		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
//		System.out.println("Status code:" + statuscode);
//		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");
//
//		// //2.Json String
//		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
//		JSONObject responseJson = new JSONObject(responsestring);
//		System.out.println("JSON response from API---->" + responseJson);
//
////		// To get value from JSON Array
////		SearchReasonId = TestUtil.getValueByjpath(responseJson, "/searchReasons[0]/id");
////		System.out.println("Response From Json is : " + SearchReasonId);
//
//		// 3.All Headers
//		Header[] headersArray = closeableHttpResponse.getAllHeaders();
//		HashMap<String, String> allHeaders = new HashMap<String, String>();
//
//		for (Header header : headersArray) {
//		allHeaders.put(header.getName(), header.getValue());
//
//		}
//		System.out.println("Headers Array-->" + allHeaders);
//
//	}

	@Test(priority = 8)
	public void UpdateSystemUser() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
//		headermap.put("firstName", "dolor aute");
//		headermap.put("lastName", "dolor aute");
//		headermap.put("mothersLastName", "dolor aute");
//		headermap.put("middleInitials", "dolor aute");
//		headermap.put("displayName", "dolor aute");
		headermap.put("mail", "sabol80073@acname.com");
		headermap.put("agency", "TSDEV");
		headermap.put("role", "HR");
		headermap.put("Authorization", "Bearer " + token);

		closeableHttpResponse = restclient.post_nobody(UpdateSystemUser, headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

//		// To get value from JSON Array
		String actual_status = TestUtil.getValueByjpath(responseJson, "/status");
		System.out.println("Tickets Response From Json is : " + actual_status);


		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}

	@Test(priority = 9)
	public void EnableDisableSystemUser() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("userId", "dolor aute");
		headermap.put("disableFlag", "true");
		headermap.put("reason", "dolor aute");
		headermap.put("Authorization", "Bearer " + token);
				

		closeableHttpResponse = restclient.post_nobody(EnableDisableSystemUser, headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

//		// To get value from JSON Array
//		citizen_referenceId = TestUtil.getValueByjpath(responseJson, "/citizen_referenceId");
//		System.out.println("Fee Response From Json is : " + citizen_referenceId);

		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}
	
	@Test(priority = 10)
	public void AgencyDistribution() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);
		

		closeableHttpResponse = restclient.get(AgencyDistribution, headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

//		// To get value from JSON Array
		String AgencyName = TestUtil.getValueByjpath(responseJson, "/data[0]/AgencyName");
		System.out.println("Agency Distribution Response From Json is : " + AgencyName);

		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}
	
	
//	Agency
	
	@Test(priority = 11)
	public void AgencyAll() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);
		
		
		closeableHttpResponse = restclient.get(agency, headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

//		// To get value from JSON Array
		String AgencyId = TestUtil.getValueByjpath(responseJson, "agencies[0]/AgencyId");
		System.out.println("Agency message Response From Json is : " + AgencyId);
		
		String AgencyCode = TestUtil.getValueByjpath(responseJson, "agencies[0]/AgencyCode");
		System.out.println("Agency message Response From Json is : " + AgencyCode);
		
		String AgencyName = TestUtil.getValueByjpath(responseJson, "agencies[0]/AgencyName");
		System.out.println("Agency message Response From Json is : " + AgencyName);

		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}
	
	
//	Batch
	
	@Test(priority = 12)
	public void batch_fileupload() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "multipart/form-data");
		headermap.put("SearchType", "dolor aute");
		headermap.put("SearchReasonId", "33631227");
		headermap.put("ClientId", "33631227");
		headermap.put("WorkflowId", "33631227");
		headermap.put("RequestingAgency", "dolor aute");
		headermap.put("BatchName", "dolor aute");
		headermap.put("BatchId", "33631227");
		headermap.put("status", "dolor aute");
		headermap.put("Authorization", "Bearer " + token);
		
		String jsonpayload = "{\r\n"
				+ "  \"searchReasonId\": 10198,\r\n"
				+ "  \"registrationNumber\": \"PR0566EE\",\r\n"
				+ "  \"transactionDate\": \"2024-01-31\",\r\n"
				+ "  \"shipPickup\": \"Y\",\r\n"
				+ "  \"mailingAddressLine1\": \"123\",\r\n"
				+ "  \"mailingAddressLine2\": \"123\",\r\n"
				+ "  \"mailingCity\": \"San Juan\",\r\n"
				+ "  \"mailingZip\": \"12345\",\r\n"
				+ "  \"ResidentialAddressLine1\": \"123\",\r\n"
				+ "  \"ResidentialAddressLine2\": \"123\",\r\n"
				+ "  \"ResidentialCity\": \"lARES\",\r\n"
				+ "  \"ResidentialZip\": \"12123\",\r\n"
				+ "  \"receiptNumber\": \"0000000\",\r\n"
				+ "  \"amount\": 5.00,\r\n"
				+ "  \"Email\": \"email@email.com\",\r\n"
				+ "  \"UserId\": \"1394892\",\r\n"
				+ "  \"transactionCode\": \"28937291\"\r\n"
				+ "}";
		

		closeableHttpResponse = restclient.post(batchfileupload, jsonpayload, headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

//		// To get value from JSON Array
//		String citizen_referenceId_ShipRenewal = TestUtil.getValueByjpath(responseJson, "/citizen_referenceId");
//		System.out.println("Ticket Transaction message Response From Json is : " + citizen_referenceId_ShipRenewal);

		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}
	
//	@Test(priority = 13)
//	public void batch_statusupdate() throws ClientProtocolException, IOException {
//		restclient = new RestClient();
//		HashMap<String, String> headermap = new HashMap<String, String>();
//		headermap.put("content-type", "application/json");
//		headermap.put("SearchType", "dolor aute");
//		headermap.put("SearchReasonId", "33631227");
//		headermap.put("ClientId", "33631227");
//		headermap.put("WorkflowId", "33631227");
//		headermap.put("RequestingAgency", "dolor aute");
//		headermap.put("BatchName", "dolor aute");
//		headermap.put("BatchId", "33631227");
//		headermap.put("status", "dolor aute");
//		headermap.put("Authorization", "Bearer " + token);
//		
//		String jsonpayload = "{\r\n"
//				+ "  \"searchReasonId\": 10199\r\n"
//				+ "}";
//		
//
//		closeableHttpResponse = restclient.post(batchstatusupdate,jsonpayload, headermap);
//
//		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
//		System.out.println("Status code:" + statuscode);
//		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");
//
//		// //2.Json String
//		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
//		JSONObject responseJson = new JSONObject(responsestring);
//		System.out.println("JSON response from API---->" + responseJson);
//
////		// To get value from JSON Array
////		String citizen_referenceId_Shipfees = TestUtil.getValueByjpath(responseJson, "/citizen_referenceId");
////		System.out.println("Ticket Transaction message Response From Json is : " + citizen_referenceId_ShipRenewal);
//
//		// 3.All Headers
//		Header[] headersArray = closeableHttpResponse.getAllHeaders();
//		HashMap<String, String> allHeaders = new HashMap<String, String>();
//
//		for (Header header : headersArray) {
//		allHeaders.put(header.getName(), header.getValue());
//
//		}
//		System.out.println("Headers Array-->" + allHeaders);
//
//	}
	
	
	@Test(priority = 14)
	public void historicalbatches() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("SearchType", "dolor aute");
		headermap.put("SearchReasonId", "33631227");
		headermap.put("ClientId", "33631227");
		headermap.put("StartDate", "dolor aute");
		headermap.put("EndDate", "dolor aute");
		headermap.put("Authorization", "Bearer " + token);
		
		closeableHttpResponse = restclient.get(historicalbatches,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

//		// To get value from JSON Array
//		String citizen_AgencyName = TestUtil.getValueByjpath(responseJson, "/data[0]/Agency");
//		System.out.println("Ticket Transaction message Response From Json is : " + citizen_AgencyName);

		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

		}
		System.out.println("Headers Array-->" + allHeaders);

	}
	
	@Test(priority = 15)
	public void batch_downloadfile() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("BatchId", "33631227");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.post_nobody(batchdownloadfile,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
	}

	@Test(priority = 16)
	public void batchdetail() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("BatchId", "33631227");
		headermap.put("SearchType", "dolor aute");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(batchdetails,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
	}

	@Test(priority = 17)
	public void downloadbatchdetail() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("BatchId", "33631227");
		headermap.put("SearchType", "dolor aute");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(downloadbatchdetails,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
	}
	
	@Test(priority = 18)
	public void client() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(clients,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
//		// To get value from JSON Array
		String ClientName = TestUtil.getValueByjpath(responseJson, "/clients/ClientName");
		System.out.println("clients message Response From Json is : " + ClientName);
		
		String ClientId = TestUtil.getValueByjpath(responseJson, "/clients/ClientId");
		System.out.println("clients message Response From Json is : " + ClientId);
		
		String ClientAgencyCode = TestUtil.getValueByjpath(responseJson, "/clients/ClientAgencyCode");
		System.out.println("clients message Response From Json is : " + ClientAgencyCode);
		
	}
	
	@Test(priority = 18)
	public void mapping() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(mappings,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
//		// To get value from JSON Array
		String mapping_status = TestUtil.getValueByjpath(responseJson, "/status");
		System.out.println("mapping message Response From Json is : " + mapping_status);
		

	}
	
	
//	@Test(priority = 18)
//	public void savebatchdetail() throws ClientProtocolException, IOException {
//		restclient = new RestClient();
//		HashMap<String, String> headermap = new HashMap<String, String>();
//		headermap.put("content-type", "application/json");
//		headermap.put("BatchId", "33631227");
//		headermap.put("SearchType", "dolor aute");
//		headermap.put("Authorization", "Bearer " + token);
//
//		
//		closeableHttpResponse = restclient.get(savebatchdetail,headermap);
//
//		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
//		System.out.println("Status code:" + statuscode);
//		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");
//
//		// //2.Json String
//		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
//		JSONObject responseJson = new JSONObject(responsestring);
//		System.out.println("JSON response from API---->" + responseJson);
//	}
	
	
//	Reference
	
	@Test(priority = 20)
	public void alertmessage() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(alertmessage,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
	}


	@Test(priority = 21)
	public void reference_agency() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(referenceagency,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);

		// To get value from JSON Array
		String domain = TestUtil.getValueByjpath(responseJson, "/data[0]/Domain");
		System.out.println("Fee Response From Json is : " + domain);

		String Code = TestUtil.getValueByjpath(responseJson, "/data[0]/Code");
		System.out.println("Fee Response From Json is : " + Code);
		
		// 3.All Headers
		Header[] headersArray = closeableHttpResponse.getAllHeaders();
		HashMap<String, String> allHeaders = new HashMap<String, String>();

		for (Header header : headersArray) {
		allHeaders.put(header.getName(), header.getValue());

			}
		System.out.println("Headers Array-->" + allHeaders);
	}
	
	@Test(priority = 22)
	public void reference_role() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("BatchId", "33631227");
		headermap.put("SearchType", "dolor aute");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(referencerole,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		
		// To get value from JSON Array
		String role_domain = TestUtil.getValueByjpath(responseJson, "/data[0]/Domain");
		System.out.println("Fee Response From Json is : " + role_domain);

		String role_Code = TestUtil.getValueByjpath(responseJson, "/data[0]/Code");
		System.out.println("Fee Response From Json is : " + role_Code);

	}
	
	@Test(priority = 23)
	public void reference_userdisablereason() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(userdisablereason,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String userreason = TestUtil.getValueByjpath(responseJson, "/data[0]/Domain");
		System.out.println("Fee Response From Json is : " + userreason);

		String user_Code = TestUtil.getValueByjpath(responseJson, "/data[0]/Code");
		System.out.println("Fee Response From Json is : " + user_Code);

	}
	
	@Test(priority = 24)
	public void reeference_template() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("name", "CitizenTemplate");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(referencetemplate,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		String filename = TestUtil.getValueByjpath(responseJson, "/filename");
		System.out.println("Fee Response From Json is : " + filename);
	}
	
	
//	Reports
	
	@Test(priority = 25)
	public void reports_landing() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(landing,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String reports_domain = TestUtil.getValueByjpath(responseJson, "/data[0]/Domain");
		System.out.println("Fee Response From Json is : " + reports_domain);

		String reports_Code = TestUtil.getValueByjpath(responseJson, "/data[0]/Code");
		System.out.println("Fee Response From Json is : " + reports_Code);

	}
	
	@Test(priority = 26)
	public void reports_failedlogins() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(failedlogins,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String reports_role = TestUtil.getValueByjpath(responseJson, "/data[0]/role");
		System.out.println("Fee Response From Json is : " + reports_role);

		String reports_agency = TestUtil.getValueByjpath(responseJson, "/data[0]/agency");
		System.out.println("Fee Response From Json is : " + reports_agency);
		
		}
	
	
	@Test(priority = 27)
	public void reports_activelogins() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(activelogins,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String reports_act_login_role = TestUtil.getValueByjpath(responseJson, "/data[0]/role");
		System.out.println("Fee Response From Json is : " + reports_act_login_role);

		String reports_act_login_agency = TestUtil.getValueByjpath(responseJson, "/data[0]/agency");
		System.out.println("Fee Response From Json is : " + reports_act_login_agency);
	}
	
	
	@Test(priority = 28)
	public void reports_loginhistory() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(loginhistory,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String reports_loginhistory_role = TestUtil.getValueByjpath(responseJson, "/data[0]/role");
		System.out.println("Fee Response From Json is : " + reports_loginhistory_role);

		String reports_loginhistory_agency = TestUtil.getValueByjpath(responseJson, "/data[0]/agency");
		System.out.println("Fee Response From Json is : " + reports_loginhistory_agency);
	}
	
	@Test(priority = 29)
	public void reports_newaccounts() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(newaccounts,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String reports_acc = TestUtil.getValueByjpath(responseJson, "/data[0]/accountEnabled");
		System.out.println("Fee Response From Json is : " + reports_acc);
	}
	
	@Test(priority = 30)
	public void reports_queryhistory() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(queryhistory,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
	}
	
//	@Test(priority = 30)
//	public void reports_queryhistoryfiltered() throws ClientProtocolException, IOException {
//		restclient = new RestClient();
//		HashMap<String, String> headermap = new HashMap<String, String>();
//		headermap.put("content-type", "application/json");
//		headermap.put("Authorization", "Bearer " + token);
//
//		
//		closeableHttpResponse = restclient.get(queryhistoryfiltered,headermap);
//
//		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
//		System.out.println("Status code:" + statuscode);
//		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");
//
//		// //2.Json String
//		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
//		JSONObject responseJson = new JSONObject(responsestring);
//		System.out.println("JSON response from API---->" + responseJson);
//				
//	}
	
	@Test(priority = 32)
	public void reports_seaechesperformedbyuser() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("startDate", "01-01-2022");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(seaechesperformedbyuser,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
			}
	
	@Test(priority = 33)
	public void reports_multiauthorization() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(multiauthorization,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String reports_SearchId = TestUtil.getValueByjpath(responseJson, "/data[0]/SearchId");
		System.out.println("Fee Response From Json is : " + reports_SearchId);

		String reports_TableId = TestUtil.getValueByjpath(responseJson, "/data[0]/TableId");
		System.out.println("Fee Response From Json is : " + reports_TableId);
	}

	@Test(priority = 34)
	public void reports_entitydetails() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(entitydetails,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		}
	
	@Test(priority = 35)
	public void reports_employeeworkinghours() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(employeeworkinghours,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String reports_employee_role = TestUtil.getValueByjpath(responseJson, "/data[0]/role");
		System.out.println("Fee Response From Json is : " + reports_employee_role);

		String reports_employee_agency = TestUtil.getValueByjpath(responseJson, "/data[0]/agency");
		System.out.println("Fee Response From Json is : " + reports_employee_agency);
	}
	
	
	
//	search reason
	@Test(priority = 36)
	public void searchreason() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("SearchReasonId", "10217");
		headermap.put("ClientId", "86");
		headermap.put("WorkflowId", "129");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(searchreasons,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String searchReasonid = TestUtil.getValueByjpath(responseJson, "/data[0]/SearchReasonId");
		System.out.println("Serach reason Id Response From Json is : " + searchReasonid);

		String clientname = TestUtil.getValueByjpath(responseJson, "/data[0]/clientname");
		System.out.println("Search reason clientname Response From Json is : " + clientname);
	}

	@Test(priority = 37)
	public void searchreasondetail() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("SearchReasonId", "10217");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(searchreasonsdetails,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String searchreason_agencymethodcode = TestUtil.getValueByjpath(responseJson, "/data[0]/AgencyMethodCode");
		System.out.println("SearchReasonDetail Agencymethod code Response From Json is : " + searchreason_agencymethodcode);

		String searchReasonDetailid = TestUtil.getValueByjpath(responseJson, "/data[0]/SearchReasonDetailId");
		System.out.println("SearchReasonDetail ID Response From Json is : " + searchReasonDetailid);
	}

	
	@Test(priority = 39)
	public void searchreasonsusers() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("SearchReasonId", "10217");
		headermap.put("AgencyCode", "192");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(searchreasonsusers,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
//		// To get value from JSON Array
//		String reports_domain = TestUtil.getValueByjpath(responseJson, "/data[0]/Domain");
//		System.out.println("Fee Response From Json is : " + reports_domain);
//
//		String reports_Code = TestUtil.getValueByjpath(responseJson, "/data[0]/Code");
//		System.out.println("Fee Response From Json is : " + reports_Code);
	}
	
//	usage metrics
	

	@Test(priority = 40)
	public void individualsearch() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(individualsearchdata,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
	}
	
	@Test(priority = 41)
	public void entitysearch() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(entitysearchdata,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
	}
	
	@Test(priority = 42)
	public void monthlyentity() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(monthlyentitysearchdata,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
	}
	
	@Test(priority = 43)
	public void monthlyindividual() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(monthlyindividualsearchdata,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		

	}
	
	@Test(priority = 44)
	public void downloadreport() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(Downloadusagemetricsreport,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		

	}
	
//	workflow

	@Test(priority = 45)
	public void workflow_by_id() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(workflows,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		

	}
	
	@Test(priority = 45)
	public void total_workflow() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(totalworkflows,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		

	}

	
	
	@Test(priority = 48)
	public void workflow_client() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("ClientId", "86");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(workflowbyclient,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
     }
}

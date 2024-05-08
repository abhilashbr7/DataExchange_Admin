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

public class DataExchangeAdmin_Ondemand extends TestBase implements IExecutionListener {

	TestBase testbase;
	RestClient restclient;
	String serviceurl;
	String apiurl;
	String url;
	String token,credentials,APIConnectivity,AdminDashboard,SearchUsersbyName,UserPresent,CustomAttributes,SystmUser,UpdateSystemUser,EnableDisableSystemUser,AgencyDistribution;
	String agency,savemapping,agencysave;
	String batchfileupload,batchstatusupdate,historicalbatches,batchdownloadfile,batchdetails,downloadbatchdetails,savebatchdetail,clients,saveclient;
	String alertmessage,referenceagency,referencerole,userdisablereason,referencetemplate;
	String landing,failedlogins,activelogins,loginhistory,newaccounts,queryhistory,queryhistoryfiltered,seaechesperformedbyuser,multiauthorization,entitydetails,employeeworkinghours;
	String searchreasons,searchreasonsdetails,linkusers,searchreasonsusers;
	String individualsearchdata,entitysearchdata,monthlyentitysearchdata,monthlyindividualsearchdata,Downloadusagemetricsreport;
	String totalworkflows,methodfields,savemethodfields,workflowbyclient,saveworkflow;
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
		
		agencysave = prop.getProperty("agencysave");
		agencysave = serviceurl + agencysave;
		
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
		
		saveclient = prop.getProperty("saveclient");
		saveclient = serviceurl + saveclient;
		
//		mappings
		savemapping = prop.getProperty("savemapping");
		savemapping = serviceurl + savemapping;
		
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
		
		saveworkflow = prop.getProperty("saveworkflow");
		saveworkflow = serviceurl + saveworkflow;
		methodfields = prop.getProperty("methodfields");
		methodfields = serviceurl + methodfields;
		savemethodfields = prop.getProperty("savemethodfields");
		savemethodfields = serviceurl + savemethodfields;
	
			
		
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
	
//	@Test(priority = 1)
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

	@Test(priority = 2)
	public void saveagency() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		String jsonpayload = "{\r\n"
				+ "  \"agencyId\": 192,\r\n"
				+ "  \"agencyCode\": \"TSDEV\",\r\n"
				+ "  \"agencyName\": \"Automation testing subject  DEV\",\r\n"
				+ "  \"agencyDescription\": \"This agency is to serve as the testing subject of automation in DEV\",\r\n"
				+ "  \"serviceBusRequestQueue\": \"NULL\",\r\n"
				+ "  \"active\": true\r\n"
				+ "}";
		

		closeableHttpResponse = restclient.post(agencysave, jsonpayload, headermap);


		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String agencyid = TestUtil.getValueByjpath(responseJson, "/agencies/AgencyId");
		System.out.println("Agncy id Response From Json is : " + agencyid);

		String agencycode = TestUtil.getValueByjpath(responseJson, "/agencies/AgencyCode");
		System.out.println("agency code Response From Json is : " + agencycode);
	}
		
	
	@Test(priority = 3)
	public void save_client() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		String jsonpayload = "{\r\n"
				+ "  \"clientId\": 86,\r\n"
				+ "  \"clientName\": \"TS Automation Client DEV\",\r\n"
				+ "  \"clientDescription\": \"This client is to serve as the test subject of automation calls DEV\",\r\n"
				+ "  \"clientAgencyCode\": \"TSDEV\",\r\n"
				+ "  \"username\": \"tsclientuat\",\r\n"
				+ "  \"password\": \"&Y^Da9mY4A2\",\r\n"
				+ "  \"active\": true\r\n"
				+ "}";
		

		closeableHttpResponse = restclient.post(saveclient, jsonpayload, headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
			
	}
	
	@Test(priority = 4)
	public void save_mapping() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		String jsonpayload = "{\r\n"
				+ "  \"workflowMappingId\": 91,\r\n"
				+ "  \"clientId\": 86,\r\n"
				+ "  \"workflowId\": 129,\r\n"
				+ "  \"apiKey\": \"acd93473-e8b7-4ce4-a09b-5b8a7f9bb921\",\r\n"
				+ "  \"active\": true\r\n"
				+ "}";
		

		closeableHttpResponse = restclient.post(savemapping, jsonpayload, headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
			
	}

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
//	@Test(priority = 4)
//	public void save_searchreason() throws ClientProtocolException, IOException {
//		restclient = new RestClient();
//		HashMap<String, String> headermap = new HashMap<String, String>();
//		headermap.put("content-type", "application/json");
//		headermap.put("Authorization", "Bearer " + token);
//
//		
//		String jsonpayload = "{\r\n"
//				+ "  \"workflowMappingId\": 91,\r\n"
//				+ "  \"clientId\": 86,\r\n"
//				+ "  \"workflowId\": 129,\r\n"
//				+ "  \"apiKey\": \"acd93473-e8b7-4ce4-a09b-5b8a7f9bb921\",\r\n"
//				+ "  \"active\": true\r\n"
//				+ "}";
//		
//
//		closeableHttpResponse = restclient.post(savemapping, jsonpayload, headermap);
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
//
	@Test(priority = 7)
	public void linkuser() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("SearchReasonId", "10217");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.post_nobody(linkusers,headermap);

		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String linkuser_id1 = TestUtil.getValueByjpath(responseJson, "/data[0]");
		System.out.println("Link user Response From Json is : " + linkuser_id1);

		String linkuser_id2 = TestUtil.getValueByjpath(responseJson, "/data[1]");
		System.out.println("Link User Response From Json is : " + linkuser_id2);
	}
	

	@Test(priority = 8)
	public void saveworkflow() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		String jsonpayload = "{\r\n"
				+ "  \"workflowId\": 129,\r\n"
				+ "  \"name\": \"TS Workflow DEV\",\r\n"
				+ "  \"description\": \"This workflow is to serve as the test subject of the automation calls\",\r\n"
				+ "  \"active\": true,\r\n"
				+ "  \"details\": [\r\n"
				+ "    {\r\n"
				+ "      \"workflowDetailId\": 129,\r\n"
				+ "      \"agencyMethodCode\": \"TSDEV\",\r\n"
				+ "      \"active\": true\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
		

		closeableHttpResponse = restclient.post(saveworkflow, jsonpayload, headermap);


		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String linkuser_id1 = TestUtil.getValueByjpath(responseJson, "/data[0]");
		System.out.println("Link user Response From Json is : " + linkuser_id1);

		String linkuser_id2 = TestUtil.getValueByjpath(responseJson, "/data[1]");
		System.out.println("Link User Response From Json is : " + linkuser_id2);
	}

	@Test(priority = 9)
	public void methodfieelds() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("workflowId", "129");
		headermap.put("agencyMethodCode", "TSDEV");
		headermap.put("Authorization", "Bearer " + token);

		
		closeableHttpResponse = restclient.get(methodfields,headermap);

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
	@Test(priority = 8)
	public void savemethodfields() throws ClientProtocolException, IOException {
		restclient = new RestClient();
		HashMap<String, String> headermap = new HashMap<String, String>();
		headermap.put("content-type", "application/json");
		headermap.put("Authorization", "Bearer " + token);

		
		String jsonpayload = "{\r\n"
				+ "  \"workflowId\": 20719940,\r\n"
				+ "  \"agencyMethodCode\": \"anim laboris Ut fugiat sed\",\r\n"
				+ "  \"fields\": {\r\n"
				+ "    \"commodo1\": [\r\n"
				+ "      {\r\n"
				+ "        \"value\": \"<Circular reference to #/components/schemas/JToken detected>\"\r\n"
				+ "      },\r\n"
				+ "      {\r\n"
				+ "        \"value\": \"<Circular reference to #/components/schemas/JToken detected>\"\r\n"
				+ "      }\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}";
		

		closeableHttpResponse = restclient.post(savemethodfields, jsonpayload, headermap);


		int statuscode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code:" + statuscode);
		Assert.assertEquals(statuscode, RESPONSE_STATUS_CODE_200, "status code is not 200");

		// //2.Json String
		String responsestring = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responsestring);
		System.out.println("JSON response from API---->" + responseJson);
		
		// To get value from JSON Array
		String linkuser_id1 = TestUtil.getValueByjpath(responseJson, "/data[0]");
		System.out.println("Link user Response From Json is : " + linkuser_id1);

		String linkuser_id2 = TestUtil.getValueByjpath(responseJson, "/data[1]");
		System.out.println("Link User Response From Json is : " + linkuser_id2);
	}


}

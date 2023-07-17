package com.biometic.controller;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.biometic.model.Biometric_AttendanceData;
import com.biometic.model.EmployeeAndBioMetricRefNo;
import com.biometic.model.Events_Errors;
import com.biometic.model.Server_Details;
import com.biometic.serviceimpl.Biometric_AttdImpl;
import com.biometic.serviceimpl.EmployeeAndBioMetricMappingImpl;
import com.biometic.serviceimpl.EventsErrorsImpl;
import com.biometic.serviceimpl.ServerDetailsImpl;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Autowired;

@Component
public class UtilityService {
	
	
	@Autowired
	Biometric_AttdImpl biometric;
	
	
	@Autowired
	ServerDetailsImpl serverDetailsImpl;
	
	@Autowired
	EventsErrorsImpl eventsErrorsImpl;
	

	@Autowired
	EmployeeAndBioMetricMappingImpl empAndBioImpl;
	
	
	
	
	
	//@Autowired
	//Biometric_Attd biometric_Attd;
	

	
	
	//@PostConstruct // it will execute every 30 seconds 
	//@Scheduled(fixedDelay = 30000)
	public void data() throws ParserConfigurationException, SAXException, JAXBException, IOException 
	{
		
		int lasteventno=0;
		String serverIp=null;
		String entryorexit=null;
		Element rootElement=null;
		String seqNo=null;
		String lastpostedsequenceno=null;
		String serverName=null;
	
		List<Server_Details> servers=serverDetailsImpl.findAll();
		
	    	
	
		for (Server_Details server : servers) {
		

			lasteventno= Integer.parseInt(server.getLastsequence())+1;
			lastpostedsequenceno=server.getLastsequence();
			serverIp=server.getServerip();
			entryorexit=server.getEntryexit();
			serverName=server.getServername();
		

		rootElement=ExecuteRequest("geteventcount",0,null,serverIp);
		
		String totalEvents = rootElement.getElementsByTagName("Seq-Number").item(0).getTextContent();
		
		int totEvents = Integer.parseInt(totalEvents); 
		
		//totEvents=999;
		
		for (int starteventno = lasteventno; starteventno <= totEvents; starteventno = starteventno + 100) {

			rootElement = ExecuteRequest("getevents", starteventno,null,serverIp);
			
			 for (int j = 0; j <= 99; j++) {
				
				if(rootElement.getElementsByTagName("seq-No").item(j)!=null) {

				seqNo = rootElement.getElementsByTagName("seq-No").item(j).getTextContent();

				String date = rootElement.getElementsByTagName("date").item(j).getTextContent();

				String time = rootElement.getElementsByTagName("time").item(j).getTextContent();

				String userId = rootElement.getElementsByTagName("detail-1").item(j).getTextContent();

				StringBuilder sb = new StringBuilder();
				sb.append(date).append(" ").append(time);
				String pattern = "dd/MM/yyyy HH:mm:ss";
				Date dateValue = null;

				SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
				try {
					dateValue = dateFormat.parse(sb.toString());

				} catch (ParseException e) {
					e.printStackTrace();
				}

				try {
				
				Biometric_AttendanceData ba = new Biometric_AttendanceData();
				ba.setAttendancedate(dateValue);
				ba.setCreateddate(new Date());
				ba.setEmpno(userId);
				ba.setInorout(entryorexit);
				ba.setOrgname(serverName);
				ba.setSequenceno(seqNo);
				ba.setStatus("Post");

			    ba=biometric.save(ba);
			    lastpostedsequenceno=seqNo;
				
				System.out.println(ba.getId());
				
				}catch(Exception e) {
					System.out.println("Got Exception"+e.getMessage());
					// updating last se
					 server.setLastsequence(lastpostedsequenceno);
					 saveError("server ip "+serverIp+"----> sequence no"+seqNo+"----->"+e.getMessage()+"");
					 serverDetailsImpl.save(server);
					continue;
				}
			} else {
				break;
			}

		}
			 server.setLastsequence(lastpostedsequenceno);
			 serverDetailsImpl.save(server);
		}
	}
		
		
		System.out.println("all data has been written successfully");
		
	}
	
	public Element ExecuteRequest(String requesttype,int startevent,String empNo,String serverIp) throws IOException, ParserConfigurationException, SAXException {

		Request request = null;

		if (requesttype == "geteventcount") {

			request = new Request.Builder()
					.url("http://"+serverIp+"/device.cgi/command?action=geteventcount&format=xml").get()
					.addHeader("authorization", "Basic YWRtaW46MTIzNA==").addHeader("cache-control", "no-cache")
					.addHeader("postman-token", "9a6d72d3-d32a-f0af-bb2a-f627246ea7df").build();

		}

		else if (requesttype == "getevents" && startevent > 0) {
			
		
			request = new Request.Builder().url(
					"http://"+serverIp+"/device.cgi/events?action=getevent&roll-over-count=0&seq-number="+startevent+"&no-of-events=100&format=xml")
					.get().addHeader("authorization", "Basic YWRtaW46MTIzNA==").addHeader("cache-control", "no-cache")
					.addHeader("postman-token", "9a6d72d3-d32a-f0af-bb2a-f627246ea7df").build();

		}
		
		else if (requesttype == "getuser") {
	         request= new Request.Builder()
				  .url("http://"+serverIp+"/device.cgi/users?action=get&user-id="+empNo+"&format=xml")
				  .get()
				  .addHeader("authorization", "Basic YWRtaW46MTIzNA==")
				  .addHeader("cache-control", "no-cache")
				  .addHeader("postman-token", "9a6d72d3-d32a-f0af-bb2a-f627246ea7df")
				  .build();
		
		}

		return GetApiResponse(request);

	}
	
	
	
	public Element GetApiResponse(Request request) throws IOException, ParserConfigurationException, SAXException {

		OkHttpClient client = new OkHttpClient();
		Response response = client.newCall(request).execute();

		if (response.code() == 200) {
			System.out.println(response.body().byteStream());

			ResponseBody responseBody = response.body();
			if (responseBody != null) {
				String xmlString = responseBody.string();
				// Proceed with parsing and processing the XML content

				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

				// Create the DocumentBuilder.
				DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();

				// Create the Document.
				Document document = documentBuilder.parse(new InputSource(new StringReader(xmlString)));

				// Get the root element.
				Element rootElement = document.getDocumentElement();

				return rootElement;
			}
		}
		return null;
	}
	
	public String getUserDetails(String employeeNo) throws IOException, ParserConfigurationException, SAXException {

		Element rootElement = null;

		rootElement = ExecuteRequest("getuser", 0, employeeNo,"192.168.1.28");

		if (rootElement.getElementsByTagName("ref-user-id").item(0) != null) {
			String bioUserId = rootElement.getElementsByTagName("ref-user-id").item(0).getTextContent();

			return bioUserId;
		}
		return null;

	}
	
	public void saveError(String error) {
		
		Events_Errors ee=new Events_Errors();
	    ee.setError(error);
	    ee.setCreateddate(new Date());
	    eventsErrorsImpl.save(ee);
	    
		
	}
	
	//@Scheduled(fixedDelay = 30000)
	public void updateEmployeeIds() throws IOException, ParserConfigurationException, SAXException {
		

		
		List<EmployeeAndBioMetricRefNo> empbio = empAndBioImpl.findAll();

		String empbiono = null;

		if (empbio != null && empbio.size() > 0) {

			for (EmployeeAndBioMetricRefNo emp : empbio) {

				if (emp.getEmployeeno() != null) {

					empbiono = getUserDetails(emp.getEmployeeno());

					emp.setBiorefno(empbiono);

					emp = empAndBioImpl.save(emp);

					if (emp.getId() != null) {

					}
				}

			}

		}

	}
	
	
	
	
}

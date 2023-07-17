package com.biometic.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import com.biometic.model.EmployeeAndBioMetricRefNo;
import com.biometic.model.Server_Details;
import com.biometic.model.Users;
import com.biometic.serviceimpl.EmployeeAndBioMetricMappingImpl;
import com.biometic.serviceimpl.ServerDetailsImpl;

import okhttp3.Request;

// In this class, we have left the caching approach for tutorial simplicity.
// If users which they can enable caching in this application.
@RestController
@RequestMapping(value = "/api")
@CrossOrigin
public class ServiceController {
	
	private static final Logger log = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	ServerDetailsImpl serverDetailsImpl;
	
	
	@Autowired
	EmployeeAndBioMetricMappingImpl empAndBioImpl;
	
	@Autowired
	UtilityService utilityService;
	
	@RequestMapping("/getHello")
	public String getHello() {
		return "Hello ";
	}
	
	@GetMapping("/newserver")
	public String newServer(@RequestParam("serverIp") String serverIp, @RequestParam("port") String port,@RequestParam("serverName") String serverName,
			@RequestParam("country") String country,@RequestParam("type") String type) {
		
		Server_Details sd=new Server_Details();
		log.info("new value are creeati"+serverIp);
		sd.setCountry(country);
		sd.setServerip(serverIp);
		sd.setPort(port);
		sd.setServername(serverName);
		sd.setCreateddate(new Date());
		sd.setLastsequence("0");
		sd.setStatus("Active");
		sd.setEntryexit(type);
		sd=serverDetailsImpl.save(sd);
		
		if(sd.getId()!=null) {
			
			return "server detailed saved successfully";
		}
	
		return "not saved";
	}
	
	@GetMapping("/newuser")
	public String newUser(@RequestParam("employeeNo") String employeeNo, @RequestParam("orgName") String orgName) throws IOException, ParserConfigurationException, SAXException {

		EmployeeAndBioMetricRefNo eb = new EmployeeAndBioMetricRefNo();
		eb.setEmployeeno(employeeNo);
		eb.setOrgname(orgName);
		String empbiono=utilityService.getUserDetails(employeeNo);
		eb.setBiorefno(empbiono);
		long id=(long) 3445;
		//eb.setId(id);
		if(empbiono!=null) {
			eb=empAndBioImpl.save(eb);

			if (eb.getId() != null) {

				return "user detailed saved successfully";
			}
		}
		if(empbiono==null) { return "Could Not Found User In BioMteric Machine"; };
		
		

		return "not saved";
	}
	
	
	@PostMapping("/register")
	public void newServer(@RequestBody Users requestDto) {
		
		System.out.println(requestDto);
	}
}





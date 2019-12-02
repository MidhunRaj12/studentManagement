package com.infosys.studentmanage.teacher.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.infosys.studentmanage.teacher.model.StudentDTO;

@Component
public class AdminServiceClient
{
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${Admin.service.url}")
	String serviceUrl;

	public List<StudentDTO> getAllBooksByIds(String oauthHeader, List<Long> bookIds)
	{
		//Removing 'Bearer '(7 char position) from oauthHeader as setBearerAuth will add it again
		oauthHeader = oauthHeader.substring(7);
		
		HttpHeaders  headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBearerAuth(oauthHeader);
		
		HttpEntity<List<Long>> entity = new HttpEntity<List<Long>>(bookIds,headers);
		
		//Request body can be sent only for POST Method
		ResponseEntity<List<StudentDTO>> rateResponse  = restTemplate.exchange(serviceUrl, HttpMethod.POST, entity,
				new ParameterizedTypeReference<List<StudentDTO>>(){});
		List<StudentDTO> bookLists = rateResponse.getBody();
		
		return bookLists;
	}

}

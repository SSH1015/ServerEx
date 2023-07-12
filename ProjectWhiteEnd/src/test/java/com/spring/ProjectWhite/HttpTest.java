package com.spring.ProjectWhite;

import java.net.URI;
import java.util.Arrays;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HttpTest {

	private static final Logger logger = LoggerFactory.getLogger(RestTemplate.class);

	@Test
	public void restTemplateTest() throws Exception{

			RestTemplate restTemplate = new RestTemplate();
			URI uri = URI.create("http://www.naver.com");
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.set("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36");
			HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
			ResponseEntity<String> result  = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
			logger.info(result.toString());
}

}
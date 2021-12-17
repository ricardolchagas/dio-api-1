package br.com.dio.api.connectors;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.dio.api.models.HGBrasilResponse;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HGBrasilConnector {
	
	private static final String SCHEME = "https";
	//private static final String HOST = "api.hgbrasil.com";
	private static final String HOST = "34.117.10.255.nip.io";	
	//private static final String URI = "weather";
	private static final String URI = "previsoes";
	private static final String API_KEY = "fe8fedf3";
	private static final String API_FIELDS = "only_results,temp,city_name,forecast,max,min,date";
	private static final int MAX_ARRAY_RESULTS = 3;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public HGBrasilResponse fecthWeatherForCity (String city)
	{
		log.info("Consultando a API da HG Brasil para a cidade {}", city );
		
		HttpEntity<?> entity = createHeaders();
			
		var uriComponentsBuilder =  createUriBuilder(city);
		
		log.info("Url para chamada da api do hgbrasil {} ", uriComponentsBuilder.toUriString());
		
		final ResponseEntity<HGBrasilResponse> responseEntity = this.restTemplate.exchange(uriComponentsBuilder.toUriString(),
				HttpMethod.GET, entity, HGBrasilResponse.class);
		
		HGBrasilResponse response = Optional.ofNullable(responseEntity.getBody()).orElse(null);
		
		log.info("Retorno da API HGBrasil para a cidade {}: {}", city, response);
				
		return response;
		
	}

	private UriComponentsBuilder createUriBuilder(String city) {
		UriComponentsBuilder uriBuilder = UriComponentsBuilder.newInstance();
		uriBuilder.scheme(SCHEME).host(HOST).path(URI);
		//uriBuilder.queryParam("key", API_KEY);
		uriBuilder.queryParam("array_limit",MAX_ARRAY_RESULTS);
		uriBuilder.queryParam("fields", API_FIELDS);
		uriBuilder.queryParam("city_name",city);
		return uriBuilder; 
	}

	private HttpEntity<?> createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity<>(headers);
		
	}
}

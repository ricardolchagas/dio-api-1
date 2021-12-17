package br.com.dio.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.dio.api.models.PrevisaoTempoResponseModel;
import br.com.dio.api.services.PrevisaoTempoService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PrevisaoTempoResource {
	@Autowired
	PrevisaoTempoService service;
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE, value="/")
	public ResponseEntity<PrevisaoTempoResponseModel> get(final String city)
	{
		log.info("PrevisaoTempoResource -> Consultando a previsao do tempo para cidade {}",  city);
		
		if (city == null)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		
		var retornoApi = service.fecthPrevisaoTempo(city);
		
		return  ResponseEntity.ok(retornoApi);
	}
	

}

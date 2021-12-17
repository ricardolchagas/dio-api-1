package br.com.dio.api.models;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PrevisaoTempoResponseModel {
	
	private Integer hora;
	private Integer temperatura;
	private String data;
	private String nomeCidade;
	
	public List<Forecast> forecast = null;

}

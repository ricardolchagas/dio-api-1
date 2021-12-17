package br.com.dio.api.models;

import java.util.List;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "temp", "date", "city_name", "forecast" })
@Generated("jsonschema2pojo")
@Data
public class HGBrasilResponse {

	@JsonProperty("temp")
	public Integer temp;
	@JsonProperty("date")
	public String date;
	@JsonProperty("city_name")
	public String cityName;
	@JsonProperty("forecast")
	public List<Forecast> forecast = null;

}
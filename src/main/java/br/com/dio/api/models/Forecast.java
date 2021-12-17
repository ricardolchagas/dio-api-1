package br.com.dio.api.models;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "date", "max", "min" })
@Generated("jsonschema2pojo")
@Data
public class Forecast {

	@JsonProperty("date")
	public String date;
	@JsonProperty("max")
	public Integer max;
	@JsonProperty("min")
	public Integer min;

}
package com.br.ms.send.email.model;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.br.ms.send.email.validate.EmailValidation;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SendEmail {

	@NotBlank
	@NotNull
	@EmailValidation
	private String senderEmail;

	@NotBlank
	@NotNull
	@EmailValidation
	private String recipientEmail;

	@NotBlank
	@NotNull
	private String apiKey;

	@NotBlank
	@NotNull
	private String templateIde;

	
	@NotNull
	private List<Data> data;
	


}
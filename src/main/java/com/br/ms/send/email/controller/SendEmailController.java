package com.br.ms.send.email.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.ms.send.email.commons.UriConstants;
import com.br.ms.send.email.model.SendEmail;
import com.br.ms.send.email.payload.ApiResponse;
import com.br.ms.send.email.service.SendEmailService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(UriConstants.URI_SEND_EMAIL)
@Api(value = "Send-email", description = "REST API for Send email", tags = { "Send-email" })
public class SendEmailController {

	private SendEmailService service;

	@Autowired
	public SendEmailController(SendEmailService service) {
		this.service = service;

	}

	@ApiOperation(value = "Method responsible for contact email")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiResponse> send(@Valid @RequestBody SendEmail email) throws IOException {

		service.send(email);

		return ResponseEntity.ok(new ApiResponse(true, "E-mail enviado com sucesso!"));
	}
	


}

package com.br.ms.send.email.service;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.br.ms.send.email.exception.EmailException;
import com.br.ms.send.email.model.SendEmail;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Personalization;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;


@Service
public class SendEmailService {
	
	private static final Logger logger = LoggerFactory.getLogger(SendEmailService.class);

	public String send(SendEmail sendEmail) throws IOException {

		Email from = new Email(sendEmail.getSenderEmail());
		Email to = new Email(sendEmail.getRecipientEmail());
		Mail mail = new Mail();
		DynamicTemplatePersonalization personalization = new DynamicTemplatePersonalization();
		personalization.addTo(to);
		mail.setFrom(from);
		mail.setSubject("The subject");

		personalization.addDynamicTemplateData(sendEmail);
		mail.addPersonalization(personalization);
		mail.setTemplateId(sendEmail.getTemplateIde());

		SendGrid sg = new SendGrid(sendEmail.getApiKey());
		Request request = new Request();

		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sg.api(request);
			logger.info(response.getBody());
			return response.getBody();
		} catch (IOException ex) {
			 throw new EmailException("Não foi possível enviar o e-mail", ex);
		}
	}
 
	private static class DynamicTemplatePersonalization extends Personalization {

		@JsonProperty(value = "dynamic_template_data")
		private Map<String, String> dynamic_template_data;

		@JsonProperty("dynamic_template_data")
		public Map<String, String> getDynamicTemplateData() {
			if (dynamic_template_data == null) {
				return Collections.<String, String>emptyMap();
			}
			return dynamic_template_data;
		}

		public void addDynamicTemplateData(SendEmail sendEmail) {
			if (dynamic_template_data == null) {
				dynamic_template_data = new HashMap<String, String>();

				sendEmail.getData().forEach(datos -> {
					dynamic_template_data.put(datos.getKey().toString(), datos.getValue().toString());
				});

			} else {
				dynamic_template_data.put("", "");
			}
		}

	}

}

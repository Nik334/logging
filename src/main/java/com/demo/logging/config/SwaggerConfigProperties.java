package com.demo.logging.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration("swaggerConfigProperties")
@EnableConfigurationProperties
public class SwaggerConfigProperties {

	@Value("${api.version}")
	private String apiVersion;

	@Value("${swagger.enabled}")
	private String enabled = "false";

	@Value("${swagger.title}")
	private String title;

	@Value("${swagger.description}")
	private String description;

	@Value("${swagger.termAndServices.url}")
	private String termAndServicesUrl;

	@Value("${swagger.contact.name}")
	private String contactName;

	@Value("${swagger.contact.url}")
	private String contactUrl;

	@Value("${swagger.contact.email}")
	private String contactEmail;

	@Value("${swagger.license}")
	private String license;

	@Value("${swagger.license.url}")
	private String licenseUrl;

	@Value("${swagger.useDefaultResponseMessages}")
	private String useDefaultResponseMessages;

	@Value("${swagger.enableUrlTemplating}")
	private String enableUrlTemplating;

	@Value("${swagger.deepLinking}")
	private String deepLinking;

	@Value("${swagger.defaultModelsExpandDepth}")
	private String defaultModelsExpandDepth;

	@Value("${swagger.defaultModelExpandDepth}")
	private String defaultModelExpandDepth;

	@Value("${swagger.displayOperationId}")
	private String displayOperationId;

	@Value("${swagger.displayRequestDuration}")
	private String displayRequestDuration;

	@Value("${swagger.filter}")
	private String filter;

	@Value("${swagger.maxDisplayedTags}")
	private String maxDisplayedTags;

	@Value("${swagger.showExtensions}")
	private String showExtensions;

}

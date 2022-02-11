package com.demo.logging.config;

import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.Lists;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.DocExpansion;
import springfox.documentation.swagger.web.ModelRendering;
import springfox.documentation.swagger.web.OperationsSorter;
import springfox.documentation.swagger.web.TagsSorter;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket apiDesign(SwaggerConfigProperties swaggerConfigProperties) {
		return new Docket(DocumentationType.SWAGGER_2).enable(Boolean.valueOf(swaggerConfigProperties.getEnabled()))
				.select().paths(PathSelectors.any()).apis(RequestHandlerSelectors.basePackage("com.inogit")).build()
				.apiInfo(apiInfo(swaggerConfigProperties)).securityContexts(Lists.newArrayList(securityContext()))
				.securitySchemes(Lists.newArrayList(apiKey()));
	}

	private ApiInfo apiInfo(SwaggerConfigProperties swaggerConfigProperties) {
		return new ApiInfo(swaggerConfigProperties.getTitle(), swaggerConfigProperties.getDescription(),
				swaggerConfigProperties.getApiVersion(), swaggerConfigProperties.getTermAndServicesUrl(),
				new Contact(swaggerConfigProperties.getContactName(), swaggerConfigProperties.getContactUrl(),
						swaggerConfigProperties.getContactEmail()),
				swaggerConfigProperties.getLicense(), swaggerConfigProperties.getLicenseUrl(), Collections.emptyList());
	}

	private ApiKey apiKey() {
		return new ApiKey("JWT", "Authorization", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(PathSelectors.regex("/.*")).build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return Lists.newArrayList(new SecurityReference("JWT", authorizationScopes));
	}

	@Bean
	UiConfiguration uiConfig(SwaggerConfigProperties swaggerConfigProperties) {
		return UiConfigurationBuilder.builder().deepLinking(Boolean.valueOf(swaggerConfigProperties.getDeepLinking()))
				.displayOperationId(Boolean.valueOf(swaggerConfigProperties.getDisplayOperationId()))
				.defaultModelsExpandDepth(Integer.valueOf(swaggerConfigProperties.getDefaultModelsExpandDepth()))
				.defaultModelExpandDepth(Integer.valueOf(swaggerConfigProperties.getDefaultModelExpandDepth()))
				.defaultModelRendering(ModelRendering.EXAMPLE)
				.displayRequestDuration(Boolean.valueOf(swaggerConfigProperties.getDisplayRequestDuration()))
				.docExpansion(DocExpansion.NONE).filter(Boolean.valueOf(swaggerConfigProperties.getFilter()))
				.maxDisplayedTags(Integer.valueOf(swaggerConfigProperties.getMaxDisplayedTags()))
				.operationsSorter(OperationsSorter.ALPHA)
				.showExtensions(Boolean.valueOf(swaggerConfigProperties.getShowExtensions()))
				.tagsSorter(TagsSorter.ALPHA).supportedSubmitMethods(UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS)
				.validatorUrl(null).build();
	}

}

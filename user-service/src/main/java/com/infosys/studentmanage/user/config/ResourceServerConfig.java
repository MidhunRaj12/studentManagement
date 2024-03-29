package com.infosys.studentmanage.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	private static final String RESOURCE_ID = "resource_id";
	
	@Value("${clientId}")
	String clientId;
	@Value("${clientSecret}")
	String clientSecret;
	@Value("${remoteTokenServiceUrl}")
	String remoteTokenServiceUrl;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId(RESOURCE_ID).stateless(false);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/user/**").access("hasRole('ADMIN') or hasRole('TEACHER') or hasRole('STUDENT')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());

	}
	
//	@Primary
	@Bean
	public RemoteTokenServices tokenService() {
		RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setCheckTokenEndpointUrl(remoteTokenServiceUrl);
		tokenService.setClientId(clientId);
		tokenService.setClientSecret(clientSecret);
		return tokenService;
	} 

}
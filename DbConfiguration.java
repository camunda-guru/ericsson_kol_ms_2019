package com.boa.kyc.configurations;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import com.boa.kyc.services.AppointmentSQLService;
import com.boa.kyc.services.AppointmentService;

@Configuration
public class DbConfiguration {
//app-about-company.properties
	@Value("${db_url}")
	private String url;
	@Value("${db_username}")
	private String userName;
	@Value("${db_password}")
	private String password;
//config-server-client-development.properties
	//@Value("${msg}")
	//private String message;
	
	
	@Bean
	@ConditionalOnClass(DataSource.class)
	public DataSource getInstance()
	{
		DataSourceBuilder builder= DataSourceBuilder.create();
		builder.url(url);
		builder.username(userName);
		builder.password(password);
		return builder.build();		
	}
	
	@Bean
	@Conditional(AppointmentNoSQLCondition.class)	
	public AppointmentFacade getNoSQLInstance()
	{
		return new AppointmentNoSQLImpl();
	}
	
	@Bean
	@Conditional(AppointmentSQLCondition.class)	
	public AppointmentFacade getSQLInstance()
	{
		return new AppointmentSQLImpl();
	}
	
}

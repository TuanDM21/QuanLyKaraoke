package com.dmt.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@ComponentScan("com.dmt.*")
public class ApplicationContextConfig {

	@Bean(name = "viewResolver")
	public ViewResolver getViewResolver() {
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();

		// TilesView 3
		viewResolver.setViewClass(TilesView.class);

		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundleMessageSource = new ReloadableResourceBundleMessageSource();
		bundleMessageSource.setBasename("classpath:messages");
		bundleMessageSource.setDefaultEncoding("utf-8");
		return bundleMessageSource;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		dataSource.setUrl("jdbc:sqlserver://localhost:1433;databaseName=QuanLyKaraoke");
		dataSource.setUsername("sa");
		dataSource.setPassword("Password.1");
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}

	@Bean
	public JavaMailSender getMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		// using gmail
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		mailSender.setUsername("shopkikiki123@gmail.com\r\n" + "");
		mailSender.setPassword("nfalgksswonqlpid\r\n" + "");
		mailSender.setDefaultEncoding("utf-8");
		Properties jaProperties = new Properties();
		jaProperties.put("mail.smtp.starttls.enable", "true");
		jaProperties.put("mail.smtp.auth", "true");
		jaProperties.put("mail.transport", "smtp");
		jaProperties.put("mail.debug", "true");
		mailSender.setJavaMailProperties(jaProperties);
		return mailSender;
	}

	@Bean(name = "tilesConfigurer")
	public TilesConfigurer getTilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();

		// TilesView 3
		tilesConfigurer.setDefinitions("/WEB-INF/tiles.xml");

		return tilesConfigurer;
	}

}
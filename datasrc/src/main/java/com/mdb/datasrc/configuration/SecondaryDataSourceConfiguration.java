package com.mdb.datasrc.configuration;





import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariDataSource;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "secondaryEntityManagerFactory",
        transactionManagerRef = "secondaryTransactionManager",
        basePackages = {"com.mdb.datasrc.repo.secondary"})
public class SecondaryDataSourceConfiguration {
	@Value("${spring.datasource.secondary.jndi-name}")
    private String secondaryJndiDatasourceName;
	 @Bean(name = "secondaryDataSourceProperties")
	    @ConfigurationProperties("spring.datasource-secondary")
	    public DataSourceProperties secondaryDataSourceProperties() {
	        return new DataSourceProperties();
	    }

	    @Bean(name = "secondaryDataSource")
	    @ConfigurationProperties("spring.datasource-secondary.configuration")
	    public DataSource secondaryDataSource(@Qualifier("secondaryDataSourceProperties") DataSourceProperties secondaryDataSourceProperties) {
	    	if (secondaryJndiDatasourceName == null || secondaryJndiDatasourceName.equalsIgnoreCase("NONE")) {
	 	         return secondaryDataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();

	    	}else {
	    		 JndiDataSourceLookup jndiDataSourceLookup = new JndiDataSourceLookup();
		         return jndiDataSourceLookup.getDataSource(secondaryJndiDatasourceName);
	    	}
	    	
	    }

	    @Bean(name = "secondaryEntityManagerFactory")
	    public LocalContainerEntityManagerFactoryBean secondaryEntityManagerFactory(
	            EntityManagerFactoryBuilder secondaryEntityManagerFactoryBuilder, @Qualifier("secondaryDataSource") DataSource secondaryDataSource) {

	        Map<String, String> secondaryJpaProperties = new HashMap<>();
	        secondaryJpaProperties.put("hibernate.dialect", "com.mdb.datasrc.configuration.AppOracleDialect");

	        return secondaryEntityManagerFactoryBuilder
	                .dataSource(secondaryDataSource)
	                .packages("com.mdb.datasrc.model.secondary")
	                .persistenceUnit("secondaryDataSource")
	                .properties(secondaryJpaProperties)
	                .build();
	    }

	    @Bean(name = "secondaryTransactionManager")
	    public PlatformTransactionManager secondaryTransactionManager(
	            @Qualifier("secondaryEntityManagerFactory") EntityManagerFactory secondaryEntityManagerFactory) {

	        return new JpaTransactionManager(secondaryEntityManagerFactory);
	    }
	    
}

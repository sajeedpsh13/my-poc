package com.mdb.datasrc.multitanancy;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.MultiTenancyStrategy;
import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import com.mdb.datasrc.DatasrcApplication;


//@Configuration
public class JpaMultitenancyConfig {
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

//	@Bean
	public LocalSessionFactoryBean entityManagerFactory(DataSource dataSource,
			MultiTenantConnectionProvider multiTenantConnectionProvider,
			CurrentTenantIdentifierResolver tenantIdentifierResolver) {
		
		LocalSessionFactoryBean emfBean = new LocalSessionFactoryBean();
		emfBean.setDataSource(dataSource);
		emfBean.setPackagesToScan(DatasrcApplication.class.getPackage().getName());
		emfBean.setMultiTenantConnectionProvider(multiTenantConnectionProvider);
		emfBean.setCurrentTenantIdentifierResolver(tenantIdentifierResolver);

		Properties jpaProperties = new Properties();
		jpaProperties.put(org.hibernate.cfg.Environment.MULTI_TENANT, MultiTenancyStrategy.SCHEMA);
		jpaProperties.put(org.hibernate.cfg.Environment.MULTI_TENANT_CONNECTION_PROVIDER,
				multiTenantConnectionProvider);
		jpaProperties.put(org.hibernate.cfg.Environment.MULTI_TENANT_IDENTIFIER_RESOLVER, tenantIdentifierResolver);
		emfBean.setHibernateProperties(jpaProperties);
		return emfBean;
	}
}

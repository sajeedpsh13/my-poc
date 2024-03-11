package com.mdb.datasrc.multitanancy;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.hibernate.engine.config.spi.ConfigurationService;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.hibernate.service.spi.ServiceRegistryAwareService;
import org.hibernate.service.spi.ServiceRegistryImplementor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class ContextBasedTenantProvider implements MultiTenantConnectionProvider, ServiceRegistryAwareService {

	
	DataSource dataSource;

	@Override
	public void injectServices(ServiceRegistryImplementor serviceRegistry) {
	    Map lSettings = serviceRegistry.getService(ConfigurationService.class).getSettings();
	    System.out.println("  ********************** " + Environment.DATASOURCE );
	    System.out.println("  ********************** " + lSettings.get( Environment.DATASOURCE ) );
	    dataSource = (DataSource) lSettings.get( Environment.DATASOURCE );

	}

	@Override
	public boolean isUnwrappableAs(Class unwrapType) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> unwrapType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getAnyConnection() throws SQLException {
		
		return this.dataSource.getConnection();
	}

	@Override
	public void releaseAnyConnection(Connection connection) throws SQLException {
		connection.close();
	}

	@Override
	public Connection getConnection(String tenantIdentifier) throws SQLException {
		// tenantIdentifier = "102";

		final Connection conn = this.getAnyConnection();
		try {
			
			if (tenantIdentifier != null && tenantIdentifier.length() > 0) {
				try(CallableStatement stmt = conn.prepareCall("call XXSP_UTIL_PKG.SET_POLICY_CONTEXT(?)")) {
					System.out.println("Got this ..."+tenantIdentifier);
					stmt.setBigDecimal(1, new BigDecimal(tenantIdentifier));
					stmt.execute();
				} catch (SQLException e) {
					
				}
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("could not set context");
		}
		return conn;
	}

	@Override
	public void releaseConnection(String tenantIdentifier, Connection connection) throws SQLException {
		try(CallableStatement stmt = connection.prepareCall("call XXSP_UTIL_PKG.SET_POLICY_CONTEXT(?)")) {						
			stmt.setBigDecimal(1, null);
			stmt.execute();

		} catch (SQLException e) {

		}
		connection.close();
	}

	@Override
	public boolean supportsAggressiveRelease() {
		// TODO Auto-generated method stub
		return false;
	}

}

package com.mdb.datasrc.multitanancy;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

//@Component
public class ContextBasedTenantIdentifierResolver implements CurrentTenantIdentifierResolver {
	

    String tenantKey;

	@Override
	public String resolveCurrentTenantIdentifier() {		
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
        	HttpServletRequest request = requestAttributes.getRequest();
        	String tenantId = request.getHeader("X-ORG-ID");
            if (tenantId != null) {
                return tenantId;
            }
        }
		return "";
	}

	@Override
	public boolean validateExistingCurrentSessions() {
		// TODO Auto-generated method stub
		return true;
	}

}


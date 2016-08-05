package org.jasig.cas.authentication.user;

import java.security.GeneralSecurityException;

import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;

public class ValidationUserNameAndPassword extends AbstractUsernamePasswordAuthenticationHandler {

	

	  /** {@inheritDoc} */
    @Override
    protected final HandlerResult authenticateUsernamePasswordInternal(final UsernamePasswordCredential credential)
            throws GeneralSecurityException, PreventedException {

        final String username = credential.getUsername();
        final String password = credential.getPassword();
        
        if("admin".equals(username) && "admin".equals(password)){
        	return createHandlerResult(credential, new SimplePrincipal(username), null);
        }
        else{
        	return null;
        }
        
    }
}

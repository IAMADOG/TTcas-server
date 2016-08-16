package org.jasig.cas.authentication.user;

import java.security.GeneralSecurityException;

import org.jasig.cas.authentication.HandlerResult;
import org.jasig.cas.authentication.PreventedException;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.handler.support.AbstractUsernamePasswordAuthenticationHandler;
import org.jasig.cas.authentication.principal.SimplePrincipal;
import org.jasig.cas.authentication.user.entity.User;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

public class ValidationUserNameAndPassword extends AbstractUsernamePasswordAuthenticationHandler {

	@Autowired(required = true)
	SqlSessionTemplate sqlSessionTemplate;
	
	String statement = User.class.getName()+".";

	  /** {@inheritDoc} */
    @Override
    protected final HandlerResult authenticateUsernamePasswordInternal(final UsernamePasswordCredential credential)
            throws GeneralSecurityException, PreventedException {

        final String username = credential.getUsername();
        final String password = credential.getPassword();
        
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        
       User  user2 = sqlSessionTemplate.selectOne(statement+"get", user);
        
       String info = JSON.toJSONString(user2);
       
        if(user2 != null){
        	return createHandlerResult(credential, new SimplePrincipal(info), null);
        }
        else{
        	return null;
        }
        
    }
    
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate){
    	this.sqlSessionTemplate = sqlSessionTemplate;
    }
}

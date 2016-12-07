/**
 *    Copyright  2016  tianjunwei
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.tianjunwei.openapi;

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.authentication.AuthenticationException;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.ticket.TicketException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author tianjunwei
 * @time 2016 上午11:03:17
 */
public class CasOpenApiImpl {
	
	@Autowired
	CentralAuthenticationService centralAuthenticationService;
	
	public String applyTGT(String userName,String passWord){
		Credential credentials = new UsernamePasswordCredential(userName,passWord);
		String tgt = null;
		try {
			tgt = centralAuthenticationService.createTicketGrantingTicket(credentials );
		} catch (TicketException | AuthenticationException e) {
			e.printStackTrace();
		}
		return tgt;
	}
	
	public String destoryTGT(String tgt){
		
		centralAuthenticationService.destroyTicketGrantingTicket(tgt);
		
		return tgt;
	}
	
	
}

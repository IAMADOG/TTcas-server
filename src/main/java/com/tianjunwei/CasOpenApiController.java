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
package com.tianjunwei;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianjunwei.openapi.CasOpenApi;

/**
 * @author tianjunwei
 * @time 2016 上午11:09:52
 */
@Controller("/cas")
public class CasOpenApiController {
	
	@Autowired
	CasOpenApi casOpenApi;
	
	@RequestMapping("/applyTGT")
	@ResponseBody
	public String applyTGT(String userName,String passWord){
		return casOpenApi.applyTGT(userName, passWord);
	}
	
	@RequestMapping("/destoryTGT")
	@ResponseBody
	public String destoryTGT(String tgt){
		return  casOpenApi.destoryTGT(tgt);
	}
	
}

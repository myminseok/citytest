package org.example.cities;

import java.util.List;

import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.ServiceInfo;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Configuration
public class UserProvodedServiceController {
	
	
	@RequestMapping("/prop")
    public String index() {
    	 CloudFactory cloudFactory = new CloudFactory();
         Cloud cloud = cloudFactory.getCloud();
    
         StringBuilder sb = new StringBuilder();
//   
//         sb.append("cloud.getServiceInfos():<br/>");
//         List<ServiceInfo> infos = cloud.getServiceInfos();
//         
//         for(ServiceInfo info: infos){
//        	 sb.append(info.getClass().getName()+","+info.toString()+"<br/>");
//         }
         sb.append("<br/>");
         sb.append("startsWith(targetservice):<br/>");
         for (ServiceInfo info : cloud.getServiceInfos()) {
             if (info.getId().startsWith(UserProvidedTargetInfo.PREFIX)) {
            	 sb.append(info.getClass().getName()+","+info.toString()+"<br/>");
             }
         }

         return "result:"+sb.toString();
    }
    

    @RequestMapping("/rest")
    public String rest1(){
    	CloudFactory cloudFactory = new CloudFactory();
        Cloud cloud = cloudFactory.getCloud();
        
        String url=null;
        for (ServiceInfo serviceInfo : cloud.getServiceInfos()) {
            if (serviceInfo.getId().startsWith(UserProvidedTargetInfo.PREFIX)) {
           	 System.out.println("found TargetInfoClass:"+serviceInfo.toString());
           	 url = ((UserProvidedTargetInfo)serviceInfo).getUri();
           	 break;
            }
        }
        
        if(url==null){
        	return "no property defined "+UserProvidedTargetInfo.PREFIX;
        }
        
    	RestTemplate restTemplate = new RestTemplate();
    	
    	return url+"<br/><br/><br/>"+restTemplate.getForObject(url,String.class);
    }
    

	
}

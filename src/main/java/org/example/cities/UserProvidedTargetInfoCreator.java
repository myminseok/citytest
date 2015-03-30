package org.example.cities;

import java.util.Map;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.cloudfoundry.Tags;


public class UserProvidedTargetInfoCreator extends CloudFoundryServiceInfoCreator<UserProvidedTargetInfo> {


    public UserProvidedTargetInfoCreator() {
        super(new Tags(), UserProvidedTargetInfo.PREFIX);
    }

    @Override
    public UserProvidedTargetInfo createServiceInfo(Map<String, Object> serviceData) {
    	
    	
        String id = (String) serviceData.get("name");
        System.out.println("!TargetInfoCreator:"+id);
        Map<String, Object> credentials = getCredentials(serviceData);
        String uri = getUriFromCredentials(credentials);

        return new UserProvidedTargetInfo(id, uri);
    }
}
package org.example.cities;

import org.springframework.cloud.service.BaseServiceInfo;
import org.springframework.cloud.service.ServiceInfo.ServiceLabel;

@ServiceLabel("targetservice")
public class UserProvidedTargetInfo extends BaseServiceInfo {
	
	public static final String PREFIX = "targetservice";
	
	protected String uri;
    public UserProvidedTargetInfo(String id, String uri) {
		super(id);
		this.uri=uri;
		// TODO Auto-generated constructor stub
	}

    public String toString(){
    	return this.id+","+this.uri;
    }

    public String getUri(){
    	return uri;
    }
	
}
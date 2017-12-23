package com.est.rest.client;


import com.est.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;


public class UserModel {

    public UserModel(){
    }
    
    public static final String ROOT_URL ="http://localhost:8080";
    public static final String SERVICE_URL_USER = 
            "/est-webservice/service/user/get/userlistMap";

    public static String iPlaingListMurl = null;

     public List<User> getUser()
            throws IOException {
        
        String service = ROOT_URL + SERVICE_URL_USER;
        String s = HttpActionSimples.get(service);
        ObjectMapper mapper = new ObjectMapper();
     //   mapper.configure(
     //           DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        JsonNode root = mapper.readValue(s, JsonNode.class);
       
        JsonNode data = root.findValue("data");
        String json = data.toString();
        TypeReference<List<User>> ref = new TypeReference<List<User>>() {};
        List<User>  test  = mapper.readValue(json, ref);
        return test;
    }
    
}
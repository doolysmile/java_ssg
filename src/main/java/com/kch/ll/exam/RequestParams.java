package com.kch.ll.exam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class RequestParams {
    private String url;
    private String path;
    private Map<String, String> requestParams;

    public RequestParams(String command){
        this.url = command;
        String[] getAndParams = command.split("\\?", 2);
        requestParams = new HashMap<>();
        this.path = getAndParams[0];
        if(getAndParams.length >= 2){
            String[] Params = getAndParams[1].split("[=&]");


            for(int i = 0; i < Params.length; i +=2){
                requestParams.put(Params[i], Params[i+1]);
            }
        }

    }

    public String getPath(){
        return this.path;
    }

    public String getParamByKey(String key){

        if(this.requestParams.containsKey(key)){
            return this.requestParams.get(key);
        }

        return null;
    }
}

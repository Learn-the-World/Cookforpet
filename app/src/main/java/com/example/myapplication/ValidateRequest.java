package com.example.myapplication;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ValidateRequest extends StringRequest{
    final static private String URL="cookforpet.db"; //php서버의 주소가 들어가야 함
    private Map<String, String> parameters;

    //생성자 만들기
    public ValidateRequest(String userID,  Response.Listener<String> listener){
        super(Method.POST,URL,listener, null);
        parameters = new HashMap<>();
    }

    @Override
    public Map<String , String> getParams(){
        return parameters;
    }
}

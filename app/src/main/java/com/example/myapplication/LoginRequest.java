//package com.example.myapplication;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.Response;
//import com.android.volley.toolbox.StringRequest;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class LoginRequest extends StringRequest {
//    //서버 URL 설정(php 파일 연동)
//    final static private String URL = "cookforpet.db"; //php 서버의 주소가 들어가야 함
//    private Map<String, String> map;
//
//    public LoginRequest(String user_id, String user_pwd, Response.Listener<String> listener) {
//        super(Method.POST, URL, listener, null);
//
//        map = new HashMap<>();
//        map.put("user_id", user_id);
//        map.put("user_pwd", user_pwd);
//    }
//
//    @Override
//    protected Map<String, String>getParams() throws AuthFailureError {
//        return map;
//    }
//
//}
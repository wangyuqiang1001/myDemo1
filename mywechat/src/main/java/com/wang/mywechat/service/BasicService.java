package com.wang.mywechat.service;

public interface BasicService {
    String verify(String signature,String timestamp,String nonce,String echostr);

    String getAccessToken();

     String createMenu();
}

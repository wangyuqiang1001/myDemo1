package com.wang.mywechat.util;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtil {
    /**
     * 解析微信发来的请求（XML）
     *
     * @param request
     * @return map
     * @throws Exception
     */
    public static Map<String, String> parseXml(HttpServletRequest request) throws Exception {
        // 将解析结果存储在HashMap中
        Map<String, String> map = new HashMap();
        // 从request中取得输入流
        InputStream inputStream = request.getInputStream();
        // 读取输入流
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);
        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        // 遍历所有子节点
        for (Element e : elementList) {
            map.put(e.getName(), e.getText());
        }
        // 释放资源
        inputStream.close();
        inputStream = null;
        return map;
    }

    /**
     * 根据消息类型 构造返回消息
     * (1)被动回复用户发送给公众号的相关信息，可能存在有语音，图片，，视频，音频，地址位置，等相关信息
     * (2)根据相关推送事件，，比如用户扫码事件，点击按钮事件等等，以此来作出相关交互
     */
    public static String buildXml(Map<String, String> map) {
        String result;
        String msgType = map.get("MsgType").toUpperCase().toString();
        result = buildReplyMessage(map,msgType);
        return result;
    }

    /**
     * 构造文本消息
     * @param msgType
     * @param map
     * @return
     */
    private static String buildReplyMessage(Map<String, String> map,String msgType) {
        //发送方帐号
        String fromUserName = map.get("FromUserName");
        // 开发者微信号
        String toUserName = map.get("ToUserName");
        String replyContent="未定义的消息类型";
        if("EVENT".equals(msgType)){
            buildReplyMessageEvent(msgType,map.get("Event"));
        }
        if("TEXT".equals(msgType)){
            replyContent="接收到用户的文本消息";
        }
        if("IMAGE".equals(msgType)){
            replyContent="接收到用户的图片信息";}
        if("VOICE".equals(msgType)){
            replyContent="接收到用户的语音信息";}
        if("NEWS".equals(msgType)){
            replyContent="接收到用户的图文信息";}
        if("MUSIC".equals(msgType)){
            replyContent="接收到用户的音乐信息";}
        if("VIDEO".equals(msgType)){
            replyContent="接收到用户的视频信息";}


        //用于在接收到相关消息时再做出回复，，发送方和接收方位置刚好对调
        return String.format(
                "<xml>" +
                        "<ToUserName><![CDATA[%s]]></ToUserName>" +
                        "<FromUserName><![CDATA[%s]]></FromUserName>" +
                        "<CreateTime>%s</CreateTime>" +
                        "<MsgType><![CDATA[text]]></MsgType>" +
                        "<Content><![CDATA[%s]]></Content>" + "</xml>",
                fromUserName, toUserName, getUtcTime(),replyContent );
    }

    /**
     * 当用户非
     * @param msgType
     * @param event
     * @return
     */
    public  static String buildReplyMessageEvent(String msgType,String event){
        if("SUBSCRIBE".equals(event)){
            System.out.println("用户关注了公众号");
        }
        if("UNSUBSCRIBE".equals(event)){
            System.out.println("用户取消关注了公众号");
        }


        return  "";
    }

    private static String getUtcTime() {
        Date dt = new Date();// 如果不需要格式,可直接用dt,dt就是当前系统时间
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmm");// 设置显示格式
        String nowTime = df.format(dt);
        long dd = (long) 0;
        try {
            dd = df.parse(nowTime).getTime();
        } catch (Exception e) {

        }
        return String.valueOf(dd);
    }

}
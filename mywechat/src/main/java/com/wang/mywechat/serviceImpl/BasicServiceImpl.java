package com.wang.mywechat.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.joymeter.util.HttpClient;
import com.wang.mywechat.consts.Const;
import com.wang.mywechat.entity.menu.Button;
import com.wang.mywechat.entity.menu.CommonButton;
import com.wang.mywechat.entity.menu.Menu;
import com.wang.mywechat.entity.menu.OuterButton;
import com.wang.mywechat.service.BasicService;
import com.wang.mywechat.util.ConnectionVertify;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BasicServiceImpl implements BasicService {
    private static final String TOKEN = "08f028ba6df044239f3db275165d161c";
    private static ConcurrentHashMap tokenMap = new ConcurrentHashMap<String, Object>();

    @Override
    public String verify(String signature, String timestamp, String nonce, String echostr) {
        String sortStr = ConnectionVertify.sort(TOKEN, timestamp, nonce);
        String mysignature = ConnectionVertify.shal(sortStr);
        if (!"".equals(signature) && !"".equals(mysignature) && mysignature.equals(signature)) {
            return echostr;
        }
        return "error";
    }

    /**
     * 获取accessToken 默认超时时间是两个小时
     *
     * @return
     */
    @Override
    public String getAccessToken() {
        long currrentTime = new Date().getTime();
        String param = Const.param.replaceFirst("APPID", Const.appId).
                replaceFirst("APPSECRET", Const.appSecret);
        System.out.println(param);

        JSONObject result = JSON.parseObject(HttpClient.sendGet2(Const.accessTokenUrl, param));
        System.out.println("access_token"+result.getString("access_token"));

        if (tokenMap.get("time") == null || currrentTime - (long) tokenMap.get("time") > 7200) {
            tokenMap.put("time", currrentTime);
            tokenMap.put("token", result.getString("access_token"));
        }
        return result.getString("access_token");
    }


    @Override
    public String createMenu() {
        String menuUrl = Const.menuUrl.replaceFirst("ACCESS_TOKEN", this.getAccessToken());
        CommonButton btn1 = new CommonButton();
        btn1.setType("click");
        btn1.setName("今日歌曲");
        btn1.setKey("is click");
        CommonButton btn2 = new CommonButton();
        btn2.setType("view");
        btn2.setName("搜索");
        btn2.setUrl("http://www.soso.com/");
        CommonButton btn3 = new CommonButton();
        btn3.setType("miniprogram");
        btn3.setName("wxa");
        btn3.setUrl("http://mp.weixin.qq.com");
        btn3.setAppid("wx286b93c14bbf93aa");
        btn3.setPagepath("pages/lunar/index");
        CommonButton btn4 = new CommonButton();
        btn4.setType("click");
        btn4.setName("赞我们一下");
        btn4.setKey("v1001_goo");
        OuterButton outerButton = new OuterButton();
        outerButton.setName("菜单");
        outerButton.setSub_button(new CommonButton[]{btn2,btn3,btn4});
        Menu menu = new Menu();
        menu.setButton(new Button[]{btn1,outerButton});
        String menuStr = JSON.toJSONString(menu);
        String s = HttpClient.sendPost(menuUrl, menuStr);
        return  s;
    }




}

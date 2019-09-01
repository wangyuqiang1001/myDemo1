package com.wang.mywechat.entity.menu;

import javax.lang.model.element.NestingKind;

/**
 * 通用内层菜单
 */
public class CommonButton extends Button {
    private String type;
    private String url;   //如果类型为view则需要对应参数，，代表地址
    private String key;   //用于当类型为click时来传递信息
    private String appid;//小程序appid
    private String pagepath;//小程序路径

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }
}

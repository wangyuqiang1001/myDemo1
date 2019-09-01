package com.wang.mywechat.entity.menu;

public class OuterButton extends Button {
    private CommonButton[] sub_button;

    public CommonButton[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(CommonButton[] sub_button) {
        this.sub_button = sub_button;
    }
}

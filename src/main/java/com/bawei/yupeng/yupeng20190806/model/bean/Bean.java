package com.bawei.yupeng.yupeng20190806.model.bean;

public class Bean {
    private String content;
    private String avatar;
    private String type;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Bean() {
    }

    public Bean(String content, String avatar, String type) {
        this.content = content;
        this.avatar = avatar;
        this.type = type;
    }
}

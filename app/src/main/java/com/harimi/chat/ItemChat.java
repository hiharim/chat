package com.harimi.chat;

import java.io.Serializable;

public class ItemChat implements Serializable {
    //닉네임,프로필,내용,날짜
    String nickname;
  //  String profile;
    String content;
    String date;
    //뷰타입(왼쪽,가운데,오른쪽)
    int viewType;

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }



    public ItemChat(String nickname, String content, String date, int viewType) {
        this.nickname = nickname;
        this.content = content;
        this.date = date;
        this.viewType = viewType;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}

package com.example.toycathon.dto;

import android.os.Parcel;
import android.os.Parcelable;

public class Questions implements Parcelable {
    public static final Parcelable.Creator<Questions> CREATOR = new Parcelable.Creator<Questions>() {
        @Override
        public Questions createFromParcel(Parcel in) {
            return new Questions(in);
        }

        @Override
        public Questions[] newArray(int size) {
            return new Questions[size];
        }
    };
    private String id;
    private String question;
    private String choice01;
    private String choice02;
    private String choice03;
    private String choice04;
    private String crtAns;
    private String thumb;
    private String categories;
    private String description;

    public Questions(Parcel in) {
        id = in.readString();
        question = in.readString();
        choice01 = in.readString();
        choice02 = in.readString();
        choice03 = in.readString();
        choice04 = in.readString();
        crtAns = in.readString();
        categories = in.readString();
        thumb = in.readString();
        description = in.readString();
    }

    public Questions() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoice01() {
        return choice01;
    }

    public void setChoice01(String choice01) {
        this.choice01 = choice01;
    }

    public String getChoice02() {
        return choice02;
    }

    public void setChoice02(String choice02) {
        this.choice02 = choice02;
    }

    public String getChoice03() {
        return choice03;
    }

    public void setChoice03(String choice03) {
        this.choice03 = choice03;
    }

    public String getChoice04() {
        return choice04;
    }

    public void setChoice04(String choice04) {
        this.choice04 = choice04;
    }

    public String getCrtAns() {
        return crtAns;
    }

    public void setCrtAns(String crtAns) {
        this.crtAns = crtAns;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(question);
        parcel.writeString(choice01);
        parcel.writeString(choice02);
        parcel.writeString(choice03);
        parcel.writeString(choice04);
        parcel.writeString(crtAns);
        parcel.writeString(categories);
        parcel.writeString(thumb);
        parcel.writeString(description);
    }
}

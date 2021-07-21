package com.example.myapplication;

import java.io.Serializable;

public class Post implements Serializable {


    public String title;
    private String startdata;
    private String enddate;
    private String place;
    private String state;
    private String subdeadline;
    private String notificationdue;
    private String finalVersiondue;

    private String category1;
    private String category2;
    private String category3;

    private String content;
    private String link;
    private String icon;

    public Post(String Title, String Startdata, String Enddate,
                String Place, String Subdeadline,
                String Notificationdue, String FinalVersiondue,
                String Category1, String Category2, String Category3
                , String image, String Link){

         title = Title;
         startdata = Startdata;
         enddate = Enddate;
         place = Place;
         subdeadline = Subdeadline;
         notificationdue = Notificationdue;
         finalVersiondue = FinalVersiondue;

         category1 = Category1;
         category2 = Category2;
         category3 = Category3;
         icon = image;
         link = Link;
    }

    public String getTitle(){
        return title;
    }

    public String getStartdata(){
        return startdata;
    }

    public String getEnddate(){
        return enddate;
    }

    public String getPlace(){ return place; }

    public String getState(){
        return state;
    }

    public String getSubdeadline(){
        return subdeadline;

    }

    public String getNotificationdue(){
        return notificationdue;
    }

    public String getFinalVersiondue(){
        return finalVersiondue;
    }

    public String getCategory1(){
        return category1;
    }

    public String getCategory2(){
        return category2;
    }

    public String getCategory3(){
        return category3;
    }

    public String getContent(){
        return content;

    }

    public String getLink(){
        return link;
    }
    public String getIcon(){ return icon; }
}

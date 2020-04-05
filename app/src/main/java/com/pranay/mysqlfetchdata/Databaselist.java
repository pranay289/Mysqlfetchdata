package com.pranay.mysqlfetchdata;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Databaselist
{
        @SerializedName("imgurl")
        @Expose
        private String imgurl;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("price")
        @Expose
        private String price;

        public String getImgurl() {
            return imgurl;
        }

        public void setImgurl(String imgurl) {
            this.imgurl = imgurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }


}

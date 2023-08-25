package com.joseph.ecv4josephtrigo.model;

public class Shows {

        private String name; private String title; private String url;

        public Shows(String name, String title, String url) {
            this.name = name;
            this.title = title;
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }


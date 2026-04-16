package com.example.sportsnews;

public class Newsitem  {


        private String title;
        private String description;
        private String category;
        private int imageResId;
        private boolean isBookmarked;

        public Newsitem(String title, String description, String category, int imageResId) {
            this.title = title;
            this.description = description;
            this.category = category;
            this.imageResId = imageResId;
            this.isBookmarked = false;
        }

        public String getTitle() {
            return title;
        }

        public String getDescription() {
            return description;
        }

        public String getCategory() {
            return category;
        }

        public int getImageResId() {
            return imageResId;
        }

        public boolean isBookmarked() {
            return isBookmarked;
        }

        public void setBookmarked(boolean bookmarked) {
            isBookmarked = bookmarked;
        }
    }


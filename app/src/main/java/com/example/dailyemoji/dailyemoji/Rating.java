package com.example.dailyemoji.dailyemoji;

class Rating {
    private int rating;
    private String emoji;
    private String note;
    private String timestamp;

    void setRating(int ratingValue) {
        this.rating = ratingValue;
    }

    void setEmoji(String emojiValue) {
        this.emoji = emojiValue;
    }

    void setNote(String noteValue) {
        this.note = noteValue;
    }

    void setTimestamp(String timestampValue) {
        this.timestamp = timestampValue;
    }

    int getYear(){
        int year = Integer.parseInt(this.timestamp.substring(0,4));
        return year;
    }

    int getMonth(){
        int month = Integer.parseInt(this.timestamp.substring(6,7));
        return month;

    }

    int getDay(){
        int day = Integer.parseInt(this.timestamp.substring(9,10));
        return day;
    }

    int getRating() {
        return rating;
    }

    String getEmoji() {
        return emoji;
    }

    String getNote() {
        return note;
    }

    String getTimestamp() {
        return timestamp;
    }
}

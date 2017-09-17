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

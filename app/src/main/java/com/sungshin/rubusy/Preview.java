package com.sungshin.rubusy;
//import android.net.Uri;
public class Preview {
    private String title;
    private String score;
    private int image;
    //private Uri photo;

    public Preview(String title, String score, int image) {
        this.title = title;
        this.score = score;
        this.image = image;
        //this.photo = photo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.title = score;
    }

    public int getImage() {return image;}

    public void setImage(int image){this.image = image;}

    //public Uri getPhoto() { return photo;}

    //public void setPhoto(Uri photo) {this.photo = photo;
    // }
}

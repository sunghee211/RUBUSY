package com.sungshin.rubusy;

public class IconItem {
    String convenience;
    int icon;

    public IconItem(String convenience, int icon) {
        super();
        this.convenience = convenience;
        this.icon = icon;
    }

    public String getConvenience() {
        return convenience;
    }

    public void setConvenience(String convenience) {
        this.convenience = convenience;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

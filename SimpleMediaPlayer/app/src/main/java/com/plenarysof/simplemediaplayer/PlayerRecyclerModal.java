package com.plenarysof.simplemediaplayer;

public class PlayerRecyclerModal {

    String musicName;
    int musicIcon;

    public PlayerRecyclerModal(String musicName, int musicIcon) {
        this.musicName = musicName;
        this.musicIcon = musicIcon;
    }

    public String getMusicName() {
        return musicName;
    }

    public int getMusicIcon() {
        return musicIcon;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public void setMusicIcon(int musicIcon) {
        this.musicIcon = musicIcon;
    }
}

package com.plenarysoft.recycelerview;

public class SettingsModel {
    String settingName;
    int image;

    public SettingsModel(String settingName, int image) {
        this.settingName = settingName;
        this.image = image;
    }

    public String getSettingName() {
        return settingName;
    }

    public int getImage() {
        return image;
    }

    public void setSettingName(String settingName) {
        this.settingName = settingName;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

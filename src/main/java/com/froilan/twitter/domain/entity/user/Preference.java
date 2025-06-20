package com.froilan.twitter.domain.entity.user;

import org.springframework.data.mongodb.core.mapping.Field;

public class Preference {
    @Field("dark_mode")
    private boolean darkMode;

    @Field("color_scheme")
    private String colorScheme;

    @Field("font_size")
    private String fontSize;

    @Field("background")
    private String background;

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    public String getColorScheme() {
        return colorScheme;
    }

    public void setColorScheme(String colorScheme) {
        this.colorScheme = colorScheme;
    }

    public String getFontSize() {
        return fontSize;
    }

    public void setFontSize(String fontSize) {
        this.fontSize = fontSize;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }
}

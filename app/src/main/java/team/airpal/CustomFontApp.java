package team.airpal;

import android.app.Application;


public class CustomFontApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FontsOverride.setDefaultFont(this, "DEFAULT", "fonts/Raleway-Regular.ttf");
        FontsOverride.setDefaultFont(this, "MONOSPACE", "fonts/Raleway-Regular.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "fonts/Raleway-Regular.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "fonts/Raleway-Regular.ttf");
    }
}
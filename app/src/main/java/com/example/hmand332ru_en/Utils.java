package com.example.hmand332ru_en;

import android.app.Activity;


public class Utils {
    public final static int THEME_GREEN = 1;
    public final static int THEME_BLUE = 2;
    public final static int THEME_DEFAULT = 0;
    private static int sTheme = THEME_DEFAULT;


    public static void changeToTheme(final Activity activity, int theme) {
        sTheme = theme;
        activity.recreate();
    }


    public static void onActivityCreateSetTheme(final Activity activity) {
        switch (sTheme) {
            default:
            case THEME_DEFAULT:
                activity.setTheme(R.style.BlackTheme);
                break;
            case THEME_GREEN:
                activity.setTheme(R.style.GreenTheme);
                break;
            case THEME_BLUE:
                activity.setTheme(R.style.BlueTheme);
                break;
        }
    }
}

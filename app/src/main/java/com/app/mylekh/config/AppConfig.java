package com.app.mylekh.config;

import static com.app.mylekh.BuildConfig.BASE_URL;

public class AppConfig {


    public static final String IMAGE_URL_PATH = BASE_URL+"Admin/admin/";

    //layout customization
    public static final boolean FORCE_VIDEO_PLAYER_TO_LANDSCAPE = false;

    //if you use RTL Language e.g : Arabic Language or other, set true
    public static final boolean RTL_MODE = false;

    public static final int POST_PER_PAGE = 12;


    //auto image slider duration on featured recipes
    public static final int AUTO_SLIDER_DURATION = 6000;

}
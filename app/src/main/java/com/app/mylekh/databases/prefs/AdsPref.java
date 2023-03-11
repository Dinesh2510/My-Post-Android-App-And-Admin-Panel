package com.app.mylekh.databases.prefs;

import android.content.Context;
import android.content.SharedPreferences;

public class AdsPref {

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public AdsPref(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences("ads_setting", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void saveAds(String ad_status, String ad_type, String admob_publisher_id, String admob_app_id, String admob_banner_unit_id, String admob_interstitial_unit_id, String admob_native_unit_id, String admob_app_open_ad_unit_id, String fan_banner_unit_id, String fan_interstitial_unit_id, String fan_native_unit_id, String startapp_app_id, String unity_game_id, String unity_banner_placement_id, String unity_interstitial_placement_id, String applovin_banner_ad_unit_id, String applovin_interstitial_ad_unit_id, String mopub_banner_ad_unit_id, String mopub_interstitial_ad_unit_id, int interstitial_ad_interval, int native_ad_interval, int native_ad_index, String date_time) {
        editor.putString("ad_status", ad_status);
        editor.putString("ad_type", ad_type);
        editor.putString("admob_publisher_id", admob_publisher_id);
        editor.putString("admob_app_id", admob_app_id);
        editor.putString("admob_banner_unit_id", admob_banner_unit_id);
        editor.putString("admob_interstitial_unit_id", admob_interstitial_unit_id);
        editor.putString("admob_native_unit_id", admob_native_unit_id);
        editor.putString("admob_app_open_ad_unit_id", admob_app_open_ad_unit_id);
        editor.putString("fan_banner_unit_id", fan_banner_unit_id);
        editor.putString("fan_interstitial_unit_id", fan_interstitial_unit_id);
        editor.putString("fan_native_unit_id", fan_native_unit_id);
        editor.putString("startapp_app_id", startapp_app_id);
        editor.putString("unity_game_id", unity_game_id);
        editor.putString("unity_banner_placement_id", unity_banner_placement_id);
        editor.putString("unity_interstitial_placement_id", unity_interstitial_placement_id);
        editor.putString("applovin_banner_ad_unit_id", applovin_banner_ad_unit_id);
        editor.putString("applovin_interstitial_ad_unit_id", applovin_interstitial_ad_unit_id);
        editor.putString("mopub_banner_ad_unit_id", mopub_banner_ad_unit_id);
        editor.putString("mopub_interstitial_ad_unit_id", mopub_interstitial_ad_unit_id);
        editor.putInt("interstitial_ad_interval", interstitial_ad_interval);
        editor.putInt("native_ad_interval", native_ad_interval);
        editor.putInt("native_ad_index", native_ad_index);
        editor.putString("date_time", date_time);
        editor.apply();
    }

    public String getAdStatus() {
        return sharedPreferences.getString("ad_status", "0");
    }

    public String getAdType() {
        return sharedPreferences.getString("ad_type", "0");
    }

    public String getAdMobPublisherId() {
        return sharedPreferences.getString("admob_publisher_id", "0");
    }

    public String getAdMobAppId() {
        return sharedPreferences.getString("admob_app_id", "0");
    }

    public String getAdMobBannerId() {
        return sharedPreferences.getString("admob_banner_unit_id", "0");
    }

    public String getAdMobInterstitialId() {
        return sharedPreferences.getString("admob_interstitial_unit_id", "0");
    }

    public String getAdMobNativeId() {
        return sharedPreferences.getString("admob_native_unit_id", "0");
    }

    public String getAdMobAppOpenAdId() {
        return sharedPreferences.getString("admob_app_open_ad_unit_id", "0");
    }

    public String getFanBannerUnitId() {
        return sharedPreferences.getString("fan_banner_unit_id", "0");
    }

    public String getFanInterstitialUnitId() {
        return sharedPreferences.getString("fan_interstitial_unit_id", "0");
    }

    public String getFanNativeUnitId() {
        return sharedPreferences.getString("fan_native_unit_id", "0");
    }

    public String getStartappAppId() {
        return sharedPreferences.getString("startapp_app_id", "0");
    }

    public String getUnityGameId() {
        return sharedPreferences.getString("unity_game_id", "0");
    }

    public String getUnityBannerPlacementId() {
        return sharedPreferences.getString("unity_banner_placement_id", "banner");
    }

    public String getUnityInterstitialPlacementId() {
        return sharedPreferences.getString("unity_interstitial_placement_id", "video");
    }

    public String getAppLovinBannerAdUnitId() {
        return sharedPreferences.getString("applovin_banner_ad_unit_id", "0");
    }

    public String getAppLovinInterstitialAdUnitId() {
        return sharedPreferences.getString("applovin_interstitial_ad_unit_id", "0");
    }

    public String getMopubBannerAdUnitId() {
        return sharedPreferences.getString("mopub_banner_ad_unit_id", "0");
    }

    public String getMopubInterstitialAdUnitId() {
        return sharedPreferences.getString("mopub_interstitial_ad_unit_id", "0");
    }

    public int getInterstitialAdInterval() {
        return sharedPreferences.getInt("interstitial_ad_interval", 0);
    }

    public int getNativeAdInterval() {
        return sharedPreferences.getInt("native_ad_interval", 0);
    }

    public int getNativeAdIndex() {
        return sharedPreferences.getInt("native_ad_index", 0);
    }

    public String getDateTime() {
        return sharedPreferences.getString("date_time", "0");
    }

}

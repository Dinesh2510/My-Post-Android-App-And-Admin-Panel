package com.app.mylekh.activities;

import static com.app.mylekh.config.AppConfig.RTL_MODE;
import static com.app.mylekh.utils.Constant.RECIPES_GRID_2_COLUMN;
import static com.app.mylekh.utils.Constant.RECIPES_GRID_3_COLUMN;
import static com.app.mylekh.utils.Constant.RECIPES_LIST_BIG;
import static com.app.mylekh.utils.Constant.RECIPES_LIST_SMALL;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.app.mylekh.BuildConfig;
import com.app.mylekh.R;
import com.app.mylekh.databases.prefs.SharedPref;
import com.app.mylekh.fragments.FragmentCategory;
import com.app.mylekh.fragments.FragmentHome;
import com.app.mylekh.fragments.FragmentPosts;
import com.app.mylekh.utils.AppBarLayoutBehavior;
import com.app.mylekh.utils.Tools;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private long exitTime = 0;
    MyApplication myApplication;
    private BottomNavigationView navigation;
    private ViewPager viewPager;
    private TextView title_toolbar;
    MenuItem prevMenuItem;
    int pager_number = 3;
    ImageButton btn_search;
    SharedPref sharedPref;
    CoordinatorLayout coordinatorLayout;
    ImageButton btn_overflow;
    public ImageButton btn_filter;
    private BottomSheetDialog mBottomSheetDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tools.getTheme(this);
        setContentView(R.layout.activity_main);

        sharedPref = new SharedPref(this);
        Tools.getLayoutDirections(this, RTL_MODE);

        AppBarLayout appBarLayout = findViewById(R.id.appbarLayout);
        ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).setBehavior(new AppBarLayoutBehavior());

        myApplication = MyApplication.getInstance();

        title_toolbar = findViewById(R.id.title_toolbar);
        btn_filter = findViewById(R.id.btn_filter);
        btn_overflow = findViewById(R.id.btn_overflow);
        btn_overflow.setOnClickListener(view -> showBottomSheetDialog());

        coordinatorLayout = findViewById(R.id.coordinatorLayout);

        navigation = findViewById(R.id.navigation);
        navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);

        initViewPager();

        Tools.notificationOpenHandler(this, getIntent());
        Tools.getCategoryPosition(this, getIntent());
        Tools.getRecipesPosition(this, getIntent());

        initToolbarIcon();

    }

    public void showInterstitialAd() {

    }

    public void initViewPager() {
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(pager_number);
        navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_recent:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_category:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                navigation.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigation.getMenu().getItem(position);

                if (viewPager.getCurrentItem() == 0) {
                    title_toolbar.setText(getResources().getString(R.string.app_name));
                    showFilter(false);
                } else if (viewPager.getCurrentItem() == 1) {
                    title_toolbar.setText(getResources().getString(R.string.home_title_recent));
                    showFilter(false);
                } else if (viewPager.getCurrentItem() == 2) {
                    title_toolbar.setText(getResources().getString(R.string.title_nav_category));
                    showFilter(false);
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    public void selectFragmentRecipe() {
        viewPager.setCurrentItem(1);
    }

    public void selectFragmentCategory() {
        viewPager.setCurrentItem(2);
    }

    public void showFilter(Boolean show) {
        if (show) {
            btn_filter.setVisibility(View.VISIBLE);
        } else {
            btn_filter.setVisibility(View.GONE);
        }
    }

    public class MyAdapter extends FragmentPagerAdapter {

        MyAdapter(FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    return new FragmentHome();
                case 1:
                    return new FragmentPosts();
                case 2:
                    return new FragmentCategory();
            }
            return null;
        }

        @Override
        public int getCount() {
            return pager_number;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void initToolbarIcon() {

        if (sharedPref.getIsDarkTheme()) {
            findViewById(R.id.toolbar).setBackgroundColor(getResources().getColor(R.color.colorToolbarDark));
            navigation.setBackgroundColor(getResources().getColor(R.color.colorToolbarDark));
        } else {
            findViewById(R.id.toolbar).setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }

        btn_search = findViewById(R.id.btn_search);

    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem((0), true);
        } else {
            exitApp();
        }
    }

    public void exitApp() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Snackbar.make(coordinatorLayout, getString(R.string.press_again_to_exit), Snackbar.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    @SuppressWarnings("rawtypes")
    private void showBottomSheetDialog() {

        @SuppressLint("InflateParams") final View view = getLayoutInflater().inflate(R.layout.lyt_bottom_sheet, null);

        FrameLayout lyt_bottom_sheet = view.findViewById(R.id.bottom_sheet);

        SwitchCompat switch_theme = view.findViewById(R.id.switch_theme);

        if (sharedPref.getIsDarkTheme()) {
            switch_theme.setChecked(true);
            lyt_bottom_sheet.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_rounded_dark));
        } else {
            switch_theme.setChecked(false);
            lyt_bottom_sheet.setBackground(ContextCompat.getDrawable(this, R.drawable.bg_rounded_default));
        }

        switch_theme.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Log.e("INFO", "" + isChecked);
            new Handler().postDelayed(() -> {
                sharedPref.setIsDarkTheme(isChecked);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                mBottomSheetDialog.dismiss();
            }, 300);
        });

        changeRecipesListViewType(view);

        view.findViewById(R.id.btn_privacy_policy).setOnClickListener(action -> {
            startActivity(new Intent(getApplicationContext(), ActivityPrivacyPolicy.class));
            mBottomSheetDialog.dismiss();
        });
        view.findViewById(R.id.btn_rate).setOnClickListener(action -> {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID)));
            mBottomSheetDialog.dismiss();
        });
        view.findViewById(R.id.btn_more).setOnClickListener(action -> {
            String url = sharedPref.getMoreAppsUrl();
            if (url.startsWith("http") || url.startsWith("https") || url.startsWith("www")) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(sharedPref.getMoreAppsUrl())));
            } else {
                Snackbar.make(coordinatorLayout, "Whoops, no more apps available at this time", Snackbar.LENGTH_SHORT).show();
            }
            mBottomSheetDialog.dismiss();
        });
        view.findViewById(R.id.btn_about).setOnClickListener(action -> {
            aboutDialog();
            mBottomSheetDialog.dismiss();
        });

        mBottomSheetDialog = new BottomSheetDialog(this, R.style.SheetDialog);


        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        BottomSheetBehavior bottomSheetBehavior = mBottomSheetDialog.getBehavior();
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);

        mBottomSheetDialog.show();
        mBottomSheetDialog.setOnDismissListener(dialog -> mBottomSheetDialog = null);

    }

    public void aboutDialog() {
        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.custom_dialog_about, null);

        TextView txt_version = view.findViewById(R.id.txt_version);
        txt_version.setText(getString(R.string.sub_about_app_version) + " " + BuildConfig.VERSION_NAME);

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setView(view);
        alert.setCancelable(false);
        alert.setPositiveButton(R.string.dialog_ok, (dialog, which) -> dialog.dismiss());
        alert.show();
    }

    private void changeRecipesListViewType(View view) {

        final TextView txt_recipes_view = view.findViewById(R.id.txt_current_recipes_list);
        if (sharedPref.getRecipesViewType() == RECIPES_LIST_SMALL) {
            txt_recipes_view.setText(getResources().getString(R.string.single_choice_list_small));
        } else if (sharedPref.getRecipesViewType() == RECIPES_LIST_BIG) {
            txt_recipes_view.setText(getResources().getString(R.string.single_choice_list_big));
        } else if (sharedPref.getRecipesViewType() == RECIPES_GRID_2_COLUMN) {
            txt_recipes_view.setText(getResources().getString(R.string.single_choice_grid_2));
        } else if (sharedPref.getRecipesViewType() == RECIPES_GRID_3_COLUMN) {
            txt_recipes_view.setText(getResources().getString(R.string.single_choice_grid_3));
        }

        view.findViewById(R.id.btn_switch_recipes).setOnClickListener(view2 -> {
            String[] items = getResources().getStringArray(R.array.dialog_recipes_list);
            int itemSelected = sharedPref.getRecipesViewType();
            new AlertDialog.Builder(this)
                    .setTitle(R.string.title_setting_recipes)
                    .setSingleChoiceItems(items, itemSelected, (dialogInterface, position) -> {
                        sharedPref.updateRecipesViewType(position);

                        if (position == 0) {
                            txt_recipes_view.setText(getResources().getString(R.string.single_choice_list_small));
                        } else if (position == 1) {
                            txt_recipes_view.setText(getResources().getString(R.string.single_choice_list_big));
                        } else if (position == 2) {
                            txt_recipes_view.setText(getResources().getString(R.string.single_choice_grid_2));
                        } else if (position == 3) {
                            txt_recipes_view.setText(getResources().getString(R.string.single_choice_grid_3));
                        }

                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        intent.putExtra("recipes_position", "recipes_position");
                        startActivity(intent);

                        dialogInterface.dismiss();
                    })
                    .show();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

}

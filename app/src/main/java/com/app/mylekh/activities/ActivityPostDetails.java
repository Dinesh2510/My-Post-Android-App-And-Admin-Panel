package com.app.mylekh.activities;

import static com.app.mylekh.config.AppConfig.IMAGE_URL_PATH;
import static com.app.mylekh.config.AppConfig.RTL_MODE;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.app.mylekh.BuildConfig;
import com.app.mylekh.R;
import com.app.mylekh.databases.prefs.SharedPref;
import com.app.mylekh.models.PostData;
import com.app.mylekh.utils.AppBarLayoutBehavior;
import com.app.mylekh.utils.Constant;
import com.app.mylekh.utils.Tools;
import com.google.android.material.appbar.AppBarLayout;
import com.squareup.picasso.Picasso;

public class ActivityPostDetails extends AppCompatActivity {

    private PostData post;
    TextView txt_recipe_title, txt_category, txt_recipe_time;
    ImageView thumbnail_video;
    ImageView recipe_image;
    private WebView recipe_description;
    CoordinatorLayout parent_view;
    SharedPref sharedPref;
    ImageButton image_favorite, btn_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tools.getTheme(this);
        setContentView(R.layout.activity_recipe_detail_offline);

        sharedPref = new SharedPref(this);
        Tools.getLayoutDirections(this, RTL_MODE);

        AppBarLayout appBarLayout = findViewById(R.id.appbar);
        ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).setBehavior(new AppBarLayoutBehavior());

        parent_view = findViewById(R.id.lyt_content);

        thumbnail_video = findViewById(R.id.thumbnail_video);
        recipe_image = findViewById(R.id.recipe_image);
        txt_recipe_title = findViewById(R.id.recipe_title);
        txt_category = findViewById(R.id.category_name);
        txt_recipe_time = findViewById(R.id.recipe_time);
        recipe_description = findViewById(R.id.recipe_description);


        image_favorite = findViewById(R.id.img_favorite);
        btn_share = findViewById(R.id.btn_share);

        post = (PostData) getIntent().getSerializableExtra(Constant.EXTRA_OBJC);

        initToolbar();

        displayData();


    }

    public void displayData() {

        txt_recipe_title.setText(post.post_title);
        txt_category.setText(post.post_title);
        txt_recipe_time.setText(post.category_name);


        Picasso.get()
                .load( IMAGE_URL_PATH+ post.post_image)
                .placeholder(R.drawable.ic_thumbnail)
                .into(recipe_image);
        recipe_description.setBackgroundColor(Color.TRANSPARENT);
        recipe_description.setFocusableInTouchMode(false);
        recipe_description.setFocusable(false);
        recipe_description.getSettings().setDefaultTextEncodingName("UTF-8");

        WebSettings webSettings = recipe_description.getSettings();
        Resources res = getResources();
        int fontSize = res.getInteger(R.integer.font_size);
        webSettings.setDefaultFontSize(fontSize);

        String mimeType = "text/html; charset=UTF-8";
        String encoding = "utf-8";
        String htmlText = post.post_description;

        String bg_paragraph;
        if (sharedPref.getIsDarkTheme()) {
            bg_paragraph = "<style type=\"text/css\">body{color: #eeeeee;}";
        } else {
            bg_paragraph = "<style type=\"text/css\">body{color: #000000;}";
        }

        String font_style_default = "<style type=\"text/css\">@font-face {font-family: MyFont;src: url(\"file:///android_asset/font/custom_font.ttf\")}body {font-family: MyFont; font-size: medium; text-align: left;}</style>";

        String text = "<html><head>"
                + font_style_default
                + "<style>img{max-width:100%;height:auto;} figure{max-width:100%;height:auto;} iframe{width:100%;}</style> "
                + bg_paragraph
                + "</style></head>"
                + "<body>"
                + htmlText
                + "</body></html>";

        String text_rtl = "<html dir='rtl'><head>"
                + font_style_default
                + "<style>img{max-width:100%;height:auto;} figure{max-width:100%;height:auto;} iframe{width:100%;}</style> "
                + bg_paragraph
                + "</style></head>"
                + "<body>"
                + htmlText
                + "</body></html>";

        if (RTL_MODE) {
            recipe_description.loadDataWithBaseURL(null, text_rtl, mimeType, encoding, null);
        } else {
            recipe_description.loadDataWithBaseURL(null, text, mimeType, encoding, null);
        }

        btn_share.setOnClickListener(view -> {
            String share_title = android.text.Html.fromHtml(post.post_title).toString();
            String share_content = android.text.Html.fromHtml(getResources().getString(R.string.share_text)).toString();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, share_title + "\n\n" + share_content + "\n\n" + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        });



    }

    private void initToolbar() {
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (sharedPref.getIsDarkTheme()) {
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorToolbarDark));
        } else {
            toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        }

        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setTitle("");
        }

    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            default:
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }

}

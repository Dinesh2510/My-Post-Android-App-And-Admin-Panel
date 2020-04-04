package com.demo.blog.PostPkg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.demo.blog.R;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class PostDetails extends AppCompatActivity {
    String Title, Details, Image, Link, Date;
    ImageView Image_view, dig_img;

    TextView txt_Title, txt_Details, txt_Image, txt_Link, txt_Date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_details);

        DrawableCrossFadeFactory factory = new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

        Title = getIntent().getStringExtra("title");
        Details = getIntent().getStringExtra("detail");
        Image = getIntent().getStringExtra("image");
        Link = getIntent().getStringExtra("link");
        Date = getIntent().getStringExtra("date");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Post Details");



        final Drawable upArrow = getResources().getDrawable(R.drawable.back_btn);
        upArrow.setColorFilter(getResources().getColor(R.color.grey_60), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        txt_Title = findViewById(R.id.post_Title);
        txt_Details = findViewById(R.id.post_details);
        Image_view = findViewById(R.id.post_img);
        txt_Link = findViewById(R.id.post_link);
        txt_Date = findViewById(R.id.post_date);
        dig_img = findViewById(R.id.dig_img);


        txt_Title.setText(Title);
        txt_Details.setText(Details);
        txt_Link.setText(Link);
        txt_Date.setText(Date);

        Glide.with(this)
                .load("http://192.168.43.207/adview/admin/" + Image)
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .placeholder(R.drawable.placeholder)
                .transition(withCrossFade(factory))
                .into(Image_view);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_basic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = Details + "\n From MyPost App.Download the App now! https://play.google.com/store/apps/details?id=com.whatsapp";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, Title + "\nLink: " + Link);
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share Post via"));
        }
        return super.onOptionsItemSelected(item);
    }

}

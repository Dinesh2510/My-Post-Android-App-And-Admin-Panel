package com.app.mylekh.adapters;

import static com.app.mylekh.config.AppConfig.IMAGE_URL_PATH;
import static com.google.firebase.messaging.Constants.MessageNotificationKeys.IMAGE_URL;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.app.mylekh.R;
import com.app.mylekh.databases.prefs.SharedPref;
import com.app.mylekh.models.BannerData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterFeatured extends PagerAdapter {

    private Context context;
    private List<BannerData> items;
    private SharedPref sharedPref;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, BannerData video);
    }

    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public AdapterFeatured(Context context, List<BannerData> list) {
        this.context = context;
        this.sharedPref = new SharedPref(context);
        this.items = list;
    }

    @NonNull
    public Object instantiateItem(ViewGroup viewGroup, int position) {
        final BannerData p = items.get(position);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_featured, viewGroup, false);

        ImageView image = inflate.findViewById(R.id.image);
        ImageView thumbnail_video = inflate.findViewById(R.id.thumbnail_video);
        Log.e(" p.banner_image", "instantiateItem: "+ IMAGE_URL + p.banner_image );
        Picasso.get()
                .load(IMAGE_URL_PATH + p.banner_image)
                .placeholder(R.drawable.ic_thumbnail)
                .into(image);

/*
        ((TextView) inflate.findViewById(R.id.recipe_title)).setText(p.recipe_title);
*/


        inflate.findViewById(R.id.lyt_parent).setOnClickListener(view -> {
            if (AdapterFeatured.this.onItemClickListener != null) {
                AdapterFeatured.this.onItemClickListener.onItemClick(view, p);
            }
        });

        viewGroup.addView(inflate);
        return inflate;
    }

    public int getCount() {
        return this.items.size();
    }

    public void destroyItem(ViewGroup viewGroup, int i, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

}
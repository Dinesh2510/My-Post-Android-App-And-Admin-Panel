package com.app.mylekh.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import com.app.mylekh.R;
import com.app.mylekh.activities.ActivityPostDetails;
import com.app.mylekh.adapters.AdapterFeatured;
import com.app.mylekh.adapters.AdapterHomePost;
import com.app.mylekh.callbacks.CallbackHome;
import com.app.mylekh.config.AppConfig;
import com.app.mylekh.databases.prefs.SharedPref;
import com.app.mylekh.models.BannerData;
import com.app.mylekh.models.PostData;
import com.app.mylekh.rests.RestAdapter;
import com.app.mylekh.utils.Constant;
import com.app.mylekh.utils.Tools;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentHome extends Fragment {

    private View root_view;
    private SwipeRefreshLayout swipe_refresh;
    private Call<CallbackHome> callbackCall = null;
    private View lyt_main_content;
    private Runnable runnableCode = null;
    private Handler handler = new Handler();
    private ViewPager view_pager_featured;
    public static final String EXTRA_OBJC = "key.EXTRA_OBJC";
    private ShimmerFrameLayout lyt_shimmer;
    SharedPref sharedPref;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root_view = inflater.inflate(R.layout.fragment_home, container, false);


        sharedPref = new SharedPref(getActivity());


        swipe_refresh = root_view.findViewById(R.id.swipe_refresh);
        swipe_refresh.setColorSchemeResources(R.color.colorPrimary);
        lyt_main_content = root_view.findViewById(R.id.lyt_home_content);
        lyt_shimmer = root_view.findViewById(R.id.shimmer_view_container);

        // on swipe list
        swipe_refresh.setOnRefreshListener(this::requestAction);

        requestAction();

        return root_view;
    }

    private void requestAction() {
        showFailedView(false, "");
        swipeProgress(true);
        new Handler().postDelayed(this::requestHomeData, Constant.DELAY_TIME);
    }

    private void requestHomeData() {
        this.callbackCall = RestAdapter.createAPI().getHome();
        this.callbackCall.enqueue(new Callback<CallbackHome>() {
            public void onResponse(Call<CallbackHome> call, Response<CallbackHome> response) {
                CallbackHome responseHome = response.body();
                if (responseHome == null || !responseHome.status.equals("ok")) {
                    onFailRequest();
                    return;
                }
                displayData(responseHome);
                swipeProgress(false);
                lyt_main_content.setVisibility(View.VISIBLE);
            }

            public void onFailure(Call<CallbackHome> call, Throwable th) {
                Log.e("onFailure", th.getMessage());
                if (!call.isCanceled()) {
                    onFailRequest();
                }
            }
        });
    }

    private void onFailRequest() {
        swipeProgress(false);
        if (Tools.isConnect(getActivity())) {
            showFailedView(true, getString(R.string.failed_text));
        } else {
            showFailedView(true, getString(R.string.failed_text));
        }
    }

    private void showFailedView(boolean show, String message) {
        View lyt_failed = root_view.findViewById(R.id.lyt_failed_home);
        ((TextView) root_view.findViewById(R.id.failed_message)).setText(message);
        if (show) {
            lyt_failed.setVisibility(View.VISIBLE);
            lyt_main_content.setVisibility(View.GONE);
        } else {
            lyt_failed.setVisibility(View.GONE);
            lyt_main_content.setVisibility(View.VISIBLE);
        }
        root_view.findViewById(R.id.failed_retry).setOnClickListener(view -> requestAction());
    }

    private void swipeProgress(final boolean show) {
        if (!show) {
            swipe_refresh.setRefreshing(show);
            lyt_shimmer.setVisibility(View.GONE);
            lyt_shimmer.stopShimmer();
            lyt_main_content.setVisibility(View.VISIBLE);

            return;
        }
        swipe_refresh.post(() -> {
            swipe_refresh.setRefreshing(show);
            lyt_shimmer.setVisibility(View.VISIBLE);
            lyt_shimmer.startShimmer();
            lyt_main_content.setVisibility(View.GONE);
        });
    }

    private void startAutoSlider(final int position) {

        if (this.runnableCode != null) {
            this.handler.removeCallbacks(this.runnableCode);
        }
        this.runnableCode = () -> {
            int currentItem = view_pager_featured.getCurrentItem() + 1;
            if (currentItem >= position) {
                currentItem = 0;
            }
            view_pager_featured.setCurrentItem(currentItem);
            handler.postDelayed(FragmentHome.this.runnableCode, AppConfig.AUTO_SLIDER_DURATION);
        };
        handler.postDelayed(this.runnableCode, AppConfig.AUTO_SLIDER_DURATION);

    }

    private void displayData(CallbackHome responseHome) {
        displayBanner(responseHome.bannerList);
        displayPosts(responseHome.allPost);

        displayData();
    }

    private void displayData() {

        ((TextView) root_view.findViewById(R.id.txt_title_post)).setText(getResources().getString(R.string.home_title_recent));

        ((ImageView) root_view.findViewById(R.id.img_arrow_category)).setImageResource(R.drawable.ic_arrow_next);

        root_view.findViewById(R.id.ripple_more_post).setOnClickListener(view -> {

        });



    }

    private void displayBanner(final List<BannerData> list) {

        view_pager_featured = root_view.findViewById(R.id.view_pager_featured);
        final AdapterFeatured adapter = new AdapterFeatured(getActivity(), list);
        final LinearLayout lyt_featured = root_view.findViewById(R.id.lyt_featured);
        view_pager_featured.setAdapter(adapter);
        view_pager_featured.setOffscreenPageLimit(4);

        if (list.size() > 0) {
            lyt_featured.setVisibility(View.VISIBLE);
        } else {
            lyt_featured.setVisibility(View.GONE);
        }

        view_pager_featured.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {

            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position < list.size()) {

                }
            }
        });
        adapter.setOnItemClickListener((view, obj) -> {
           /* Intent intent = new Intent(getActivity(), ActivityBannerDetails.class);
            intent.putExtra(Constant.EXTRA_OBJC, obj);
            startActivity(intent);*/
        });

        TabLayout tabLayout = root_view.findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(view_pager_featured, true);

        startAutoSlider(list.size());

    }

    private void displayPosts(List<PostData> list) {
        RecyclerView recyclerView = root_view.findViewById(R.id.recycler_view_category);
      //  recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        AdapterHomePost adapterHomePost = new AdapterHomePost(getActivity(), list);
        recyclerView.setAdapter(adapterHomePost);
        recyclerView.setNestedScrollingEnabled(false);
        adapterHomePost.setOnItemClickListener((view, obj, position) -> {
            Intent intent = new Intent(getActivity(), ActivityPostDetails.class);
            intent.putExtra(EXTRA_OBJC, obj);
            startActivity(intent);
        });

        LinearLayout lyt_category = root_view.findViewById(R.id.lyt_category);
        if (list.size() > 0) {
            lyt_category.setVisibility(View.VISIBLE);
        } else {
            lyt_category.setVisibility(View.GONE);
        }
    }



    public void onDestroy() {
        if (!(callbackCall == null || callbackCall.isCanceled())) {
            this.callbackCall.cancel();
        }
        lyt_shimmer.stopShimmer();
        super.onDestroy();
    }

}


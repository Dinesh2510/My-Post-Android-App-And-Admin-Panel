package com.demo.blog.Fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.demo.blog.PostPkg.AppController;
import com.demo.blog.PostPkg.Post;
import com.demo.blog.PostPkg.PostAdapter;
import com.demo.blog.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Post> posts;
    PostAdapter postAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_all_post);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        posts = new ArrayList<>();
        ConnectivityManager ConnectionManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {

            LoadPosts();

        } else {
            Toast.makeText(getContext(), "Network Not Available", Toast.LENGTH_LONG).show();

        }
    }


    private void LoadPosts() {
        String GET_POST_LIST = "https://pixeldev.in/webservices/mypost/GetAllPostList.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, GET_POST_LIST,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Log.i("tagconvertstr", "[" + response + "]");
                        if (!response.equalsIgnoreCase("failure")) {
                            try {

                                JSONObject obj = new JSONObject(response);
                                JSONArray array = obj.getJSONArray("response");

                                // JSONArray array = new JSONArray("response");

                                for (int i = 0; i < array.length(); i++) {

                                    JSONObject rlist = array.getJSONObject(i);


                                    Log.i("rlist", "[" + rlist + "]");

                                    posts.add(new Post(
                                            rlist.getString("post_id"),
                                            rlist.getString("post_title"),
                                            rlist.getString("post_description"),
                                            rlist.getString("post_link"),
                                            rlist.getString("post_image"),
                                            rlist.getString("created_at")


                                    ));
                                }

                                //creating adapter object and setting it to recyclerview
                                postAdapter = new PostAdapter(getContext(), posts);
                                recyclerView.setAdapter(postAdapter);

                                setDataAdapter();


                            } catch (JSONException e) {
                                e.printStackTrace();


                            }
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(stringRequest);

    }

    private void setDataAdapter() {

        if (posts.size() > 0) {

            postAdapter = new PostAdapter(getContext(), posts);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(postAdapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            Toast.makeText(getContext(), "Oops! Nothing found.", Toast.LENGTH_SHORT).show();
        }
    }
}
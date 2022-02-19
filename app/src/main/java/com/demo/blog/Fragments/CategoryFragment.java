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
import com.demo.blog.Category.Category;
import com.demo.blog.Category.CategoryAdapter;
import com.demo.blog.PostPkg.AppController;
import com.demo.blog.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class CategoryFragment extends Fragment {
    RecyclerView recyclerView;
    ArrayList<Category> categoryList;
    CategoryAdapter categoryAdapter;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public CategoryFragment() {
    }

    public static CategoryFragment newInstance(String param1, String param2) {
        CategoryFragment fragment = new CategoryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_category, null);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_all_category);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        categoryList = new ArrayList<>();

        ConnectivityManager ConnectionManager = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected() == true) {

            LoadCategory();

        } else {
            Toast.makeText(getContext(), "Network Not Available", Toast.LENGTH_LONG).show();


        }
    }

    private void LoadCategory() {
        String GET_POST_LIST = "https://pixeldev.in/webservices/mypost/GetAllCategoryList.php";
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

                                    categoryList.add(new Category(
                                            rlist.getString("category_id"),
                                            rlist.getString("category_name")


                                    ));
                                }

                                //creating adapter object and setting it to recyclerview
                                categoryAdapter = new CategoryAdapter(getContext(), categoryList);
                                recyclerView.setAdapter(categoryAdapter);

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

        if (categoryList.size() > 0) {

            categoryAdapter = new CategoryAdapter(getContext(), categoryList);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(categoryAdapter);
        } else {
            recyclerView.setVisibility(View.GONE);
            Toast.makeText(getContext(), "Oops! Nothing found.", Toast.LENGTH_SHORT).show();
        }
    }


}

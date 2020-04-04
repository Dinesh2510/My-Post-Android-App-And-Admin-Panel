package com.demo.blog.Activites;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
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
import java.util.HashMap;
import java.util.Map;

import static androidx.recyclerview.widget.RecyclerView.HORIZONTAL;

public class CategoryPostList extends AppCompatActivity {
    String category_id, category_name;
    RecyclerView recyclerView;
    ArrayList<Post> posts;
    PostAdapter postAdapter;
    Toolbar toolbar;
    private ActionBar actionBar;
    ProgressBar progress_horizontal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_post_list);

        category_id = getIntent().getStringExtra("category_id");
        category_name = getIntent().getStringExtra("category_name");

        TextView tv_title = findViewById(R.id.tv_title);
         progress_horizontal = findViewById(R.id.progress_horizontal);
        tv_title.setText(category_name);


        recyclerView = findViewById(R.id.recycler_all_categoryList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecor = new DividerItemDecoration(this, HORIZONTAL);
        recyclerView.addItemDecoration(itemDecor);
        posts = new ArrayList<>();

        ConnectivityManager ConnectionManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = ConnectionManager.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected() == true) {

            LoadCategoryPosts();

        } else {
            Toast.makeText(this, "Network Not Available", Toast.LENGTH_LONG).show();

            progress_horizontal.setVisibility(View.GONE);

        }

    }


    private void LoadCategoryPosts() {
        progress_horizontal.setVisibility(View.VISIBLE);
        String GET_POST_LIST = "http://192.168.43.207/adview/GetAllCategoryPostList.php";
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
                                postAdapter = new PostAdapter(CategoryPostList.this, posts);
                                recyclerView.setAdapter(postAdapter);

                                setDataAdapter();


                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(getApplicationContext(), "Oops! Posts Are Not Available.", Toast.LENGTH_SHORT).show();
                                progress_horizontal.setVisibility(View.GONE);

                            }
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();

                params.put("category_id", category_id);
                Log.d("parmas", "getParams: " + params);

                return params;
            }

        };

        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(stringRequest);

    }

    private void setDataAdapter() {

        if (posts.size() > 0) {

            postAdapter = new PostAdapter(CategoryPostList.this, posts);
            recyclerView.setVisibility(View.VISIBLE);
            recyclerView.setAdapter(postAdapter);
            progress_horizontal.setVisibility(View.GONE);
        } else {
            recyclerView.setVisibility(View.GONE);
            progress_horizontal.setVisibility(View.GONE);
            Toast.makeText(CategoryPostList.this, "Oops! Nothing found.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(this, "Hmmmm...", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }


}

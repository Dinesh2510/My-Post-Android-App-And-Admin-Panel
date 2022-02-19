package com.demo.blog.PostPkg;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.demo.blog.R;

import java.util.List;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private Context mCtx;
    private List<Post> posts;

    public PostAdapter(Context mCtx, List<Post> posts) {
        this.mCtx = mCtx;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_post_list, null);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostAdapter.PostViewHolder holder, int position) {
        DrawableCrossFadeFactory factory =
                new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();
        final Post post = posts.get(position);
        holder.Post_Title.setText(post.getPost_title());
        Log.d("_image_a", "onCreate: " + "https://pixeldev.in/webservices/mypost/Admin/admin/post_images/" + post.getPost_image());

        Glide.with(mCtx)
                .load("https://pixeldev.in/webservices/mypost/Admin/admin/" + post.getPost_image())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(50)))
                .placeholder(R.drawable.placeholder)
                .transition(withCrossFade(factory))
                .into(holder.Post_icons);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mCtx, PostDetails.class);
                intent.putExtra("title", post.getPost_title());
                intent.putExtra("detail", post.getPost_description());
                intent.putExtra("image", post.getPost_image());
                intent.putExtra("link", post.getPost_link());
                intent.putExtra("date", post.getCreated_at());
                mCtx.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView Post_Title, Post_details, Post_link;
        ImageView Post_icons;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);

            Post_Title = itemView.findViewById(R.id.post_Title);
            // Post_details = itemView.findViewById(R.id.etf_name);
            //  Post_link = itemView.findViewById(R.id.etf_name);
            Post_icons = itemView.findViewById(R.id.postImage);


        }
    }
}

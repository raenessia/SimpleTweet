package com.codepath.apps.restclienttemplate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.Viewhold>{

    private Context context;
    private List<Tweet> tweets;


    //Pass in context and list of tweets
    public TweetAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }



    // for each row, inflate the layout
    @NonNull
    @Override
    public Viewhold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, viewGroup,false);
        return new Viewhold(view);
    }

    //bind the values based on the position the element
    @Override
    public void onBindViewHolder(@NonNull Viewhold viewhold, int i) {
        Tweet tweet = tweets.get(i);
        viewhold.tvBody.setText(tweet.body);
        viewhold.tvScreenName.setText(tweet.user.screenName);
        Glide.with(context).load(tweet.user.profileImageUrl).into(viewhold.ivProfileImage);


    }


    @Override
    public int getItemCount() {
        return tweets.size();
    }



    // define the Viewholder
    public class Viewhold extends RecyclerView.ViewHolder{
        public ImageView ivProfileImage;
        public TextView tvScreenName;
        public TextView tvBody;

        public Viewhold(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvBody = itemView.findViewById(R.id.tvBody);
        }
    }
}

package me.codetalk.retrofittest1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import me.codetalk.retrofittest1.R;
import me.codetalk.retrofittest1.api.entity.PostData;
import me.codetalk.retrofittest1.api.entity.Tag;

/**
 * Created by Administrator on 2017/12/15.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder> {

    private List<PostData> posts;
    private Context context;
    private PostItemListener itemListener;

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public PostAdapter(Context context, List<PostData> posts, PostItemListener postItemListener) {
        this.context = context;
        this.posts = posts;
        this.itemListener = postItemListener;
    }

    @Override
    public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);

        return new ViewHolder(view, this.itemListener);
    }

    @Override
    public void onBindViewHolder(PostAdapter.ViewHolder holder, int position) {
        PostData post = posts.get(position);

        holder.post = post;
        holder.textAuthor.setText(post.getAuthor());
        holder.textContent.setText(post.getContent());
        holder.textCreate.setText(formatter.format(new Timestamp(post.getCreateDate())));

        List<Tag> tags = post.getTags();
        StringBuffer buf = new StringBuffer();
        for(Tag tag : tags) {
            buf.append(tag.getText()).append(" ");
        }
        holder.textTags.setText(buf.toString());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    private PostData getPostItem(int position) {
        return posts.get(position);
    }

    public void updatePosts(List<PostData> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        PostData post;

        TextView textAuthor;
        TextView textCreate;
        TextView textContent;
        TextView textTags;

        PostItemListener itemListener;

        public ViewHolder(View itemView, PostItemListener itemListener) {
            super(itemView);
            itemView.setOnClickListener(this);

            this.itemListener = itemListener;

            textAuthor = itemView.findViewById(R.id.text_post_author);
            textCreate = itemView.findViewById(R.id.text_post_createdate);
            textContent = itemView.findViewById(R.id.text_post_content);
            textTags = itemView.findViewById(R.id.text_post_tags);
        }

        @Override
        public void onClick(View view) {
            int viewId = view.getId();
            if(viewId == R.id.layout_post) {
                PostData post = getPostItem(getAdapterPosition());

                this.itemListener.onPostClick(post.getId());

//                notifyDataSetChanged();
            }
        }

    }

    public interface PostItemListener {

        void onPostClick(Long id);

    }

}

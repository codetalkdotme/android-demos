package me.codetalk.retrofittest1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import me.codetalk.retrofittest1.R;
import me.codetalk.retrofittest1.api.entity.Tag;

/**
 * Created by Administrator on 2017/12/16.
 */

public class TagAdapter extends RecyclerView.Adapter<TagAdapter.ViewHolder>{

    private List<Tag> tagList = null;

    private Context context;

    private Set<String> tags = new HashSet<>();

    public TagAdapter(Context context, List<Tag> tags) {
        this.context = context;
        this.tagList = tags;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_tag, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Tag tag = tagList.get(position);

        holder.textTag.setText(tag.getText());
    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    public void updateTags(List<Tag> tags) {
        this.tagList = tags;
        notifyDataSetChanged();
    }

    public Set<String> getSelectedTags() {
        return tags;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView textTag;

        public ViewHolder(View itemView) {
            super(itemView);

            this.textTag = itemView.findViewById(R.id.text_tag);

            this.textTag.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int viewId = view.getId();
            if(viewId == R.id.text_tag) {
                TextView tagView = (TextView)view;

                Tag tag = tagList.get(getAdapterPosition());
                String tt = tag.getText();
                if(tags.contains(tt)) {
                    tags.remove(tt);

                    tagView.setText(tt);
                } else {
                    tags.add(tt);

                    SpannableString tagu = new SpannableString(tt);
                    tagu.setSpan(new UnderlineSpan(), 0, tt.length(), 0);
                    tagView.setText(tagu);
                }
            }
        }
    }
}

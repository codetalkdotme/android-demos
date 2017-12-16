package me.codetalk.restjsontest.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import me.codetalk.restjsontest.R;
import me.codetalk.restjsontest.vo.MetaVO;

/**
 * Created by guobxu on 2017/12/15.
 */

public class MetaAdapter extends RecyclerView.Adapter<MetaAdapter.ViewHolder>{

    private List<MetaVO> metaVOList;


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textNo;
        TextView textMeta;

        public ViewHolder(View itemView) {
            super(itemView);

            textNo = itemView.findViewById(R.id.text_meta_no);
            textMeta = itemView.findViewById(R.id.text_meta);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_meta, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MetaVO meta = metaVOList.get(position);

        holder.textNo.setText(meta.getNo());
        holder.textMeta.setText(meta.getText());

        if(meta.getNo() == null) {
            holder.textNo.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return metaVOList.size();
    }


}

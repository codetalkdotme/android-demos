package me.codetalk.uibestpractice.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import me.codetalk.uibestpractice.R;
import me.codetalk.uibestpractice.vo.Msg;

/**
 * Created by Administrator on 2017/12/14.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> msgList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout leftLayout;

        LinearLayout rightLayout;

        TextView leftMsg;
        TextView rightMsg;

        public ViewHolder(View view) {
            super(view);

            leftLayout = view.findViewById(R.id.layout_left);
            rightLayout = view.findViewById(R.id.layout_right);

            leftMsg = view.findViewById(R.id.text_left_msg);
            rightMsg = view.findViewById(R.id.text_right_msg);
        }

    }

    public MsgAdapter(List<Msg> msgList) {
        this.msgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = msgList.get(position);
        if(msg.getType() == Msg.TYPE_RECV) {
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        } else if(msg.getType() == Msg.TYPE_SEND){
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

}

package me.codetalk.customlistviewtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.codetalk.customlistviewtest.R;
import me.codetalk.customlistviewtest.vo.FruitVO;

/**
 * Created by Administrator on 2017/12/14.
 */

public class FruitAdapter extends ArrayAdapter<FruitVO> {

    private int resourceId;

    public FruitAdapter(@NonNull Context context, int itemViewResourceId, @NonNull List<FruitVO> objects) {
        super(context, itemViewResourceId, objects);

        this.resourceId = itemViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FruitVO fruit = getItem(position);
        View view = null;
        ViewHolder viewHolder = null;
        if(convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = view.findViewById(R.id.item_image_fruit);
            viewHolder.fruitText = view.findViewById(R.id.item_text_fruit);

            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitText.setText(fruit.getName());

        return view;
    }


}

class ViewHolder {

    ImageView fruitImage;

    TextView fruitText;

}

package me.codetalk.recyclerimagetest.adapter;

import android.content.Context;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import me.codetalk.recyclerimagetest.R;

/**
 * Created by guobxu on 2018/1/8.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {

    private static final String TAG = "ImageAdapter";

    private List<ImageVO> imageList;

    private Context context;

    public ImageAdapter(List<ImageVO> imageList, Context context) {
        this.imageList = imageList;
        this.context = context;
    }

    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "In onCreateViewHolder...");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_img, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ImageAdapter.ViewHolder holder, int position) {
        ImageVO img = imageList.get(position);
//        String filePath = getRealPathFromURI(img.getUri());

        holder.imageView.setImageBitmap(BitmapFactory.decodeFile(img.getFilePath()));
//        holder.textFile.setText(img.getFilePath());
    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public void addImages(List<ImageVO> imgs) {
        int pos = imageList.size();
        imageList.addAll(imgs);

        notifyItemRangeInserted(pos, imgs.size());
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
//        TextView textFile;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image_from_uri);
//            textFile = itemView.findViewById(R.id.text_img);
        }
    }


    protected String getRealPathFromURI(Uri contentUri) {
        Cursor cursor = null;
        try {
            String[] proj = { MediaStore.Images.Media.DATA };
            cursor = context.getContentResolver().query(contentUri,  proj, null, null, null);
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToFirst();

            return cursor.getString(column_index);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }


}

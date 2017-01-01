package me.anwarshahriar.databindingexplore;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.Glide;

public class ImageAdapter {
    @BindingAdapter({"imageUrl", "placeHolder"})
    public static void setImage(ImageView poster, String posterImage, Drawable placeHolderImage) {
        Glide.with(poster.getContext())
                .load(posterImage)
                .centerCrop()
                .placeholder(placeHolderImage)
                .crossFade()
                .into(poster);
    }
}

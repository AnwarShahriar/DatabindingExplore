package me.anwarshahriar.databindingexplore;

import android.databinding.BindingAdapter;
import android.databinding.InverseBindingListener;
import android.databinding.InverseBindingMethod;
import android.databinding.InverseBindingMethods;

@InverseBindingMethods(
        @InverseBindingMethod(type = RandomColor.class,
                attribute = "color",
                method = "getCurrentColor")
)
public class ColorBindingAdapter {

    @BindingAdapter("colorAttrChanged")
    public static void setListeners(RandomColor view,
                                    final InverseBindingListener listener) {
        RandomColor.OnColorChangeListener newListener = new RandomColor.OnColorChangeListener() {
            @Override
            public void onColorChange(RandomColor view, int newColor) {
                listener.onChange();
            }
        };

        view.setOnColorChangeListener(newListener);
    }

    @BindingAdapter("color")
    public static void setCustomColor(RandomColor view, int color) {
        view.setColor(color);
    }
}

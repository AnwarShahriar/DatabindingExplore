package me.anwarshahriar.databindingexplore;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import java.util.Random;

public class RandomColor extends View {
    Paint paint;
    Rect rect;
    OnColorChangeListener onColorChangeListener;

    public RandomColor(Context context) {
        super(context);
        init();
    }

    public RandomColor(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RandomColor(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        rect = new Rect();

        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);

        final Random random = new Random();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int color = Color.argb(255, random.nextInt(256),
                        random.nextInt(256), random.nextInt(256));
                setColor(color);
            }
        });
    }

    public void setColor(int color) {
        paint.setColor(color);
        invalidate();
        if (onColorChangeListener != null) {
            onColorChangeListener.onColorChange(this, color);
        }
    }

    public int getCurrentColor() {
        return paint.getColor();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        rect.set(0, 0, widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(rect, paint);
    }

    public void setOnColorChangeListener(OnColorChangeListener onColorChangeListener) {
        this.onColorChangeListener = onColorChangeListener;
    }

    public interface OnColorChangeListener {
        void onColorChange(RandomColor view, int newColor);
    }
}
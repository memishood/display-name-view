package com.emrememis.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/**
 * @author emre.memis.49@gmail.com
 */
public class DisplayNameView extends FrameLayout {
    private int textColor, textSize, backgroundColor, strokeColor, strokeWidth;
    private String displayName;

    public DisplayNameView(@NonNull Context context) {
        super(context);
    }

    public DisplayNameView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public DisplayNameView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    private void init(@Nullable AttributeSet attrs) {
        // set root view
        inflate(getContext(), R.layout.layout_display_name_view, this);
        // create attribute instance to get parameters
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.DisplayNameView);
        try {
            this.textColor = typedArray.getColor(
                    R.styleable.DisplayNameView_textColor,
                    -2
            );
            this.textSize = typedArray.getDimensionPixelSize(
                    R.styleable.DisplayNameView_textSize,
                    -2
            );
            this.backgroundColor = typedArray.getColor(
                    R.styleable.DisplayNameView_backgroundColor,
                    -2
            );
            this.strokeColor = typedArray.getColor(
                    R.styleable.DisplayNameView_strokeColor,
                    -2
            );
            this.strokeWidth = typedArray.getDimensionPixelSize(
                    R.styleable.DisplayNameView_strokeWidth,
                    -2
            );
            this.displayName = typedArray.getString(R.styleable.DisplayNameView_displayName);
        } finally {
            typedArray.recycle();
        }
        // update ui after got the params
        updateUI();
    }

    private void updateUI() {
        TextView textView = findViewById(R.id.layout_display_name_text_view);

        setBackgroundResource(R.drawable.layout_display_name_background);
        GradientDrawable backgroundRes = (GradientDrawable) getBackground();

        if (this.backgroundColor != -2) {
            backgroundRes.setColor(this.backgroundColor);
        }

        if (this.strokeColor != -2 && this.strokeWidth != -2) {
            backgroundRes.setStroke(this.strokeWidth, this.strokeColor);
        }

        if (this.textColor != -2) {
            textView.setTextColor(this.textColor);
        }


        if (this.textSize != -2) {
            textView.setTextSize(this.textSize);
        }

        if (this.displayName != null) {
            String formattedDisplayName = generateDisplayName(this.displayName);
            if (formattedDisplayName != null) {
                textView.setText(formattedDisplayName);
            }
        }
    }

    private String generateDisplayName(String name) {
        String trim = name.trim();
        if (!trim.isEmpty()) {
            String[] words = trim.split(" ");
            String displayName = String.valueOf(words[0].charAt(0));
            if (words.length > 1) {
                displayName += words[words.length - 1].charAt(0);
            }
            return displayName.toUpperCase();
        }
        return null;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public int getTextSize() {
        return this.textSize;
    }

    public int getBackgroundColor() {
        return this.backgroundColor;
    }

    public int getStrokeColor() {
        return this.strokeColor;
    }

    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public void setTextColor(@ColorInt int textColor) {
        this.textColor = textColor;
        updateUI();
    }

    public void setTextSize(int textSize) {
        this.textSize = textSize;
        updateUI();
    }

    public void setBackgroundColor(@ColorInt int backgroundColor) {
        this.backgroundColor = backgroundColor;
        updateUI();
    }

    public void setStrokeColor(@ColorInt int strokeColor) {
        this.strokeColor = strokeColor;
        updateUI();
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        updateUI();
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
        updateUI();
    }

    public void startAnim() {
        TextView textView = findViewById(R.id.layout_display_name_text_view);
        Animation anim = AnimationUtils.loadAnimation(getContext(), R.anim.image_anim);
        textView.startAnimation(anim);
    }

    public void stopAnim() {
        TextView textView = findViewById(R.id.layout_display_name_text_view);
        textView.clearAnimation();
    }
}
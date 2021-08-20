package com.gzeinnumer.dr;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

import com.gzeinnumer.dr.utils.ViewIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class DynamicRadioButton extends RadioGroup {
    private final Context _context;
    private final AttributeSet _attrs;
    private int _cbStyle = R.style.def_radioButtonStyle;
    private int _orientation = VERTICAL;
    private int position = -1;

    private ArrayList<Object> sendArray = new ArrayList<>();

    private OnCheckedChangeListener onCheckedChangeListener;

    public DynamicRadioButton(Context context) {
        this(context, null);
    }

    public DynamicRadioButton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this._context = context;
        this._attrs = attrs;

        // Set Layout
        initView(sendArray);
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    public <T> DynamicRadioButton setItemList(List<T> items) {
        initView(items);
        return this;
    }

    private <T> void initView(List<T> items) {
        TypedArray attributes = _context.obtainStyledAttributes(_attrs, R.styleable.DynamicCheckBox);

        if (attributes.getInt(R.styleable.DynamicCheckBox_orientationRadioButton, 1) == 0)
            _orientation = HORIZONTAL;

        setOrientation(_orientation);

        if (attributes.getResourceId(R.styleable.DynamicCheckBox_style, -1) != -1)
            _cbStyle = attributes.getResourceId(R.styleable.DynamicCheckBox_style, -1);

        RadioGroup radioGroup = new RadioGroup(_context);
        radioGroup.setOrientation(_orientation);

        RadioButton rbPreview = new RadioButton(_context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            rbPreview.setId(View.generateViewId());
        } else {
            rbPreview.setId(ViewIdGenerator.generateViewId());
        }
        rbPreview.setText("Dynamic RadioButton");
        rbPreview.setTextAppearance(_context, _cbStyle);
        if (items.isEmpty()) {
            addView(rbPreview);
        } else {
            removeViewAt(0);

            // Add Item Set User
            for (int i = 0; i < items.size(); i++) {
                final RadioButton rb = new RadioButton(_context);
                rb.setTextAppearance(_context, _cbStyle);
                rb.setText(items.get(i).toString());
                rb.setId(i);
                rb.setChecked(position==i);
                radioGroup.addView(rb);
            }

            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    RadioButton radioBtn = findViewById(checkedRadioButtonId);
                    int id = radioBtn.getId();

                    if (onCheckedChangeListener != null) {
                        addToArray(items.get(id));
                    }
                }
            });

            attributes.recycle();
            addView(radioGroup);
        }
    }

    private <T> void addToArray(T data) {
        sendArray = new ArrayList<Object>();
        sendArray.add(data);

        onCheckedChangeListener.onCheckedChanged(sendArray.get(0));
    }

    @Override
    protected void removeDetachedView(View child, boolean animate) {
        super.removeDetachedView(child, false);
    }

    public DynamicRadioButton setSelectedItem(int position) {
        this.position = position;
        return this;
    }

    public interface OnCheckedChangeListener<T> {
        void onCheckedChanged(T item);
    }
}
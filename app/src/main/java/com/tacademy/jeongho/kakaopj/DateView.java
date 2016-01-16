package com.tacademy.jeongho.kakaopj;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.TextView;

/**
 * Created by Tacademy on 2016-01-16.
 */
public class DateView extends FrameLayout {
    public DateView(Context context) {
        super(context);
        init();
    }

    TextView messageView;
    DateData data;
    private void init() {
        inflate(getContext(), R.layout.view_data,this);
        messageView = (TextView)findViewById(R.id.text_clock);
    }

    public void setData(DateData data){
        this.data = data;
        messageView.setText(data.message);
    }
}

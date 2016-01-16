package com.tacademy.jeongho.kakaopj;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Tacademy on 2016-01-16.
 */
public class ChattingAdapter extends BaseAdapter {
    ArrayList<ChattingData> items = new ArrayList<ChattingData>(); //?
    private static final int VIEW_TYPE_COUNT = 3;
    private static final int VIEW_TYPE_RECEIVE = 0;
    private static final int VIEW_TYPE_SEND = 1;
    private static final int VIEW_TYPE_DATE = 2;

    public void add(ChattingData data) {
        items.add(data);
        notifyDataSetChanged(); //데이터가 추가될때 AdapterView를 다시 그려야 하기 때문에 추가 해야됨.
    }


    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return VIEW_TYPE_COUNT;
    }

    @Override
    public int getItemViewType(int position) {
        ChattingData data = items.get(position);
        if (data instanceof ReceiveData) {
            return VIEW_TYPE_RECEIVE;
        } else if (data instanceof SendData) {
            return VIEW_TYPE_SEND;
        } else {
            return VIEW_TYPE_DATE;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)) {
            case VIEW_TYPE_RECEIVE: {
                ReceiveView view;
                if (convertView != null && convertView instanceof ReceiveView) {
                    view = (ReceiveView) convertView;
                } else {
                    view = new ReceiveView(parent.getContext());
                }
                view.setData((ReceiveData) items.get(position));
                return view;
            }
            case VIEW_TYPE_SEND: {
                SendView view;
                if (convertView != null && convertView instanceof SendView) {
                    view = (SendView) convertView;
                } else {
                    view = new SendView(parent.getContext());
                }
                view.setData((SendData) items.get(position));
                return view;
            }
            case VIEW_TYPE_DATE:
            default: {
                DateView view;
                if (convertView != null && convertView instanceof DateView) {
                    view = (DateView) convertView;
                } else {
                    view = new DateView(parent.getContext());
                }
                view.setData((DateData) items.get(position));
                return view;
            }
        }

    }
}

package com.miworks.trendywriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;


public class FieldlistAdpter extends ArrayAdapter implements View.OnClickListener {

    private Activity _activity;

    public FieldlistAdpter(Context context, int resource, List objects) {
        super(context, resource, objects);
        this._activity = (Activity) context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View _row = convertView;
        if (_row == null) {

        }
        return _row;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(_activity, TopicsActivity.class);
        _activity.startActivity(intent);
    }
}

package com.miworks.trendywriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;


public class FieldlistAdpter extends ArrayAdapter implements View.OnClickListener {

    class LayoutForm {
        public TextView _percentage;
        public TextView _keyword;
        public TextView _date;
    }

    private Activity _activity;
    private LayoutForm item;

    public List<Map<String, String>> fieldList;

    public FieldlistAdpter(Context context, int resource, List<Map<String, String>> objects) {
        super(context, resource, objects);
        this._activity = (Activity) context;
        this.fieldList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View _row = convertView;
        if (_row == null) {
            LayoutInflater inflater = _activity.getLayoutInflater();
            _row = inflater.inflate(R.layout.adapter_fieldlist, null);
            item = new LayoutForm();
            item._percentage = (TextView) _row.findViewById(R.id.percentage_text);
            item._keyword = (TextView) _row.findViewById(R.id.keyword_text);
            item._date = (TextView) _row.findViewById(R.id.date_text);
            _row.setTag(item);
            _row.setOnClickListener(this);
        }
        item = (LayoutForm) _row.getTag();
        Map<String, String> map = fieldList.get(position);
        item._percentage.setText(map.get("PERCENTAGE"));
        item._keyword.setText(map.get("KEYWORD"));
        item._date.setText(map.get("DATE"));
        return _row;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(_activity, TopicsActivity.class);
        _activity.startActivity(intent);
    }
}

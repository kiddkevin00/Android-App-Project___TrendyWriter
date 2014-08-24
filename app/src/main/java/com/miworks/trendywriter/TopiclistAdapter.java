package com.miworks.trendywriter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;


public class TopiclistAdapter extends ArrayAdapter<Map<String, String>> implements View.OnClickListener {

    private class LayoutForm {
        private TextView _percentage;
        private TextView _keyword;
        private TextView _date;
    }

    private Activity _activity;
    private LayoutForm _item;

    public List<Map<String, String>> topicList = null;

    public TopiclistAdapter(Context context, int resource, List<Map<String, String>> objects) {
        super(context, resource, objects);
        this._activity = (Activity) context;
        this.topicList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View _row = convertView;
        if (_row == null) {
            LayoutInflater inflater = _activity.getLayoutInflater();
            _row = inflater.inflate(R.layout.adapter_topiclist, null);
            _item = new LayoutForm();
            _item._percentage = (TextView) _row.findViewById(R.id.percentage_text);
            _item._keyword = (TextView) _row.findViewById(R.id.keyword_text);
            _item._date = (TextView) _row.findViewById(R.id.date_text);
            _row.setTag(_item);
            _row.setOnClickListener(this);
        }
        _item = (LayoutForm) _row.getTag();
        Map<String, String> map = topicList.get(position);
        _item._percentage.setText(map.get("PERCENTAGE"));
        _item._keyword.setText(map.get("KEYWORD"));
        _item._date.setText(map.get("DATE"));
        return _row;
    }

    @Override
    public void onClick(View v) {

    }
}

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



public class FieldlistAdpter extends ArrayAdapter<Map<String, String>> implements View.OnClickListener {

    private class LayoutForm {
        private TextView _field;
    }

    private Activity _activity;
    private LayoutForm _item;

    public List<Map<String, String>> fieldList = null;

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
            _item = new LayoutForm();
            _item._field = (TextView) _row.findViewById(R.id.field_text);
            _row.setTag(_item);
            _row.setOnClickListener(this);
        }
        _item = (LayoutForm) _row.getTag();
        Map<String, String> map = fieldList.get(position);
        _item._field.setText(map.get("FIELD"));
        return _row;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(_activity, TopicsActivity.class);
        _activity.startActivity(intent);
    }
}

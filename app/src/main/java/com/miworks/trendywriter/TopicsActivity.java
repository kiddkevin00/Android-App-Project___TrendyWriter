package com.miworks.trendywriter;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TopicsActivity extends Activity {

    private TopiclistAdapter _adapter;
    private ListView _topicList;
    private Context _context;

    public List<Map<String, String>> topicList = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        this._context = this;

        generateSampleTopics();

        // set adapter
        _adapter = new TopiclistAdapter(_context, R.layout.adapter_topiclist, topicList);
        _topicList = (ListView) findViewById(R.id.listView);
        _topicList.setAdapter(_adapter);

    }

    public void generateSampleTopics() {
        topicList = new ArrayList<Map<String, String>>();
        Map sample01 = new HashMap();
        Map sample02 = new HashMap();
        Map sample03 = new HashMap();
        sample01.put("PERCENTAGE", "50%");
        sample01.put("KEYWORD", "william");
        sample01.put("DATE", "2014-08-10");

        sample02.put("PERCENTAGE", "100%");
        sample02.put("KEYWORD", "obama");
        sample02.put("DATE", "2014-08-20");

        sample03.put("PERCENTAGE", "80%");
        sample03.put("KEYWORD", "water");
        sample03.put("DATE", "2014-08-22");

        topicList.add(sample01);
        topicList.add(sample02);
        topicList.add(sample03);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.choice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

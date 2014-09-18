package com.miworks.trendywriter;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TopicsActivity extends Activity {

    private TopiclistAdapter _adapter;
    private ListView _topicList;
    private Context _context;

    private static final String TAG = "@miworks " + TopicsActivity.class.getName();
    public List<Map<String, String>> topicList = null;

    public RestApiGetRequest restApiGetRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        this._context = this;

        generateSampleTopics();

        restApiGetRequest = new RestApiGetRequest();
        restApiGetRequest.execute("");

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
        sample01.put("PERCENTAGE", "✩✩✩✩✩");
        sample01.put("KEYWORD", "william");

        sample02.put("PERCENTAGE", "✩✩✩✩");
        sample02.put("KEYWORD", "obama");

        sample03.put("PERCENTAGE", "✩✩");
        sample03.put("KEYWORD", "james");

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

    private class RestApiGetRequest extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            String resultDatas = null;
            URL url = null;
            URLConnection urlConnection = null;
            InputStreamReader inputStreamReader = null;
            BufferedReader bufferedReader = null;

            // get stock open price, stock name, price, trade data, trade time, etc.
            String attribute = "osl1d1t1c1ohgv";
            try {
                url = new URL("http://quote.yahoo.com/d/quotes.csv?s=" + "aa"
                        + "&f=" + attribute + "&e=.csv");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                urlConnection = url.openConnection();

                inputStreamReader = new InputStreamReader(
                        urlConnection.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
                resultDatas = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (DebugSetting.on) {
                Log.d(TAG, resultDatas);
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if (result != null) {
            } else {

            }
        }
    }
}



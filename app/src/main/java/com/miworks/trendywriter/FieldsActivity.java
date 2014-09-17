package com.miworks.trendywriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FieldsActivity extends Activity {

    private Context _context;
    private FieldlistAdpter _adapter;
    private ListView _fieldList;

    private static final String TAG = "## " + LoginActivity.class.getName();

    public List<Map<String, String>> fieldList = null;
    public String signupEmail;
    public String signupPassword;
    public String loginEmail;
    public String loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fields);
        this._context = this;

        generateSampleFields();

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        signupEmail = bundle.getString("SIGNUP_EMAIL");
        signupPassword = bundle.getString("SIGNUP_PASSWORD");
        if (DebugSetting.on == true)
            Log.d(TAG, "user signup : " + signupEmail + " ; " + signupPassword);
        // if click log-in button and type nothing, signupEmail == null; loginEmail.equals("");
        if (signupEmail != null && !signupEmail.equals("")) {
            Toast.makeText(FieldsActivity.this, "Welcome " + signupEmail + " ! "
                    , Toast.LENGTH_SHORT).show();
        }

        loginEmail = bundle.getString("LOGIN_EMAIL");
        loginPassword = bundle.getString("LOGIN_PASSWORD");
        if (DebugSetting.on == true)
            Log.d(TAG, "user login : " + loginEmail + " ; " + loginPassword);
        if (loginEmail != null && !loginEmail.equals("")) {
            Toast.makeText(FieldsActivity.this, "Welcome back " + loginEmail + " ! "
                    , Toast.LENGTH_SHORT).show();
        }

        // set adapter
        _adapter = new FieldlistAdpter(_context, R.layout.adapter_fieldlist, fieldList);
        _fieldList = (ListView) findViewById(R.id.listView);
        _fieldList.setAdapter(_adapter);

    }

    public void generateSampleFields() {
        fieldList = new ArrayList<Map<String, String>>();
        Map sample01 = new HashMap();
        Map sample02 = new HashMap();
        Map sample03 = new HashMap();
        Map sample04 = new HashMap();
        Map sample05 = new HashMap();
        Map sample06 = new HashMap();
        Map sample07 = new HashMap();
        Map sample08 = new HashMap();
        Map sample09 = new HashMap();
        Map sample10 = new HashMap();

        sample01.put("FIELD", "POLITICS");
        sample02.put("FIELD", "SPORT");
        sample03.put("FIELD", "TRAVEL");
        sample04.put("FIELD", "BUSINESS");
        sample05.put("FIELD", "ENTERTAIN");
        sample06.put("FIELD", "TECH");
        sample07.put("FIELD", "MEDIA");
        sample08.put("FIELD", "HEALTH");
        sample09.put("FIELD", "COMEDY");
        sample10.put("FIELD", "PET");

        fieldList.add(sample01);
        fieldList.add(sample02);
        fieldList.add(sample03);
        fieldList.add(sample04);
        fieldList.add(sample05);
        fieldList.add(sample06);
        fieldList.add(sample07);
        fieldList.add(sample08);
        fieldList.add(sample09);
        fieldList.add(sample10);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.topics, menu);
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

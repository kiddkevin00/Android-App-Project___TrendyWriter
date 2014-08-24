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


public class FieldsActivity extends Activity {

    private Context _context;
    private FieldlistAdpter _adapter;
    private ListView _fieldList;

    private static final String TAG = LoginActivity.class.getName();

    public String signupEmail;
    public String signupPassword;
    public String loginEmail;
    public String loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fields);
        this._context = this;

        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        signupEmail = bundle.getString("SIGNUP_EMAIL");
        signupPassword = bundle.getString("SIGNUP_PASSWORD");
        if (DebugSetting.on == true)
            Log.d(TAG, "user signup : " + signupEmail + " ; " + signupPassword);
        if (signupEmail != null && !signupEmail.equals("")) {
            Toast.makeText(FieldsActivity.this, "User signup : " + signupEmail + " ; "
                    + signupPassword, Toast.LENGTH_SHORT).show();
        }

        loginEmail = bundle.getString("LOGIN_EMAIL");
        loginPassword = bundle.getString("LOGIN_PASSWORD");
        if (DebugSetting.on == true)
            Log.d(TAG, "user login : " + loginEmail + " ; " + loginPassword);
        if (loginEmail != null && !loginEmail.equals("")) {
            Toast.makeText(FieldsActivity.this, "User login : " + loginEmail + " ; "
                    + loginPassword, Toast.LENGTH_SHORT).show();
        }

        // set adapter
        _adapter = new FieldlistAdpter(_context, R.layout.fieldlist_adpter, new ArrayList());
        _fieldList = (ListView) findViewById(R.id.listView);
        _fieldList.setAdapter(_adapter);

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

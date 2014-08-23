package com.miworks.trendywriter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends Activity {

    private Context _context;
    private EditText _email;
    private EditText _password;
    private Button _signup;
    private Button _login;
    private Button _skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this._context = this;
        _email = (EditText) findViewById(R.id.email_edittext);
        _password = (EditText) findViewById(R.id.password_edittext);
        _skip = (Button) findViewById(R.id.skip_button);
        _signup = (Button) findViewById(R.id.signup_button);
        _login = (Button) findViewById(R.id.login_button);

        _skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TopicsActivity.class);
                startActivity(intent);
            }
        });

        _signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, TopicsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("SIGNUP_EMAIL", _email.getText().toString());
                bundle.putString("SIGNUP_PASSWORD", _password.getText().toString());
                intent2.putExtras(bundle);
                startActivity(intent2);
            }
        });

        _login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(MainActivity.this, TopicsActivity.class);
                Bundle bundle2 = new Bundle();
                bundle2.putString("LOGIN_EMAIL", _email.getText().toString());
                bundle2.putString("LOGIN_PASSWORD", _password.getText().toString());
                intent3.putExtras(bundle2);
                startActivity(intent3);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

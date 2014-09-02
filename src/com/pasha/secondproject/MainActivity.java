package com.pasha.secondproject;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	Button submit;
	EditText input;
	TextView output;
	SharedPreferences prefs;
	Editor editor;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        output=(TextView) findViewById(R.id.tvshow);
        input=(EditText) findViewById(R.id.etinput);
        submit=(Button) findViewById(R.id.btnsubmit);
        prefs = getSharedPreferences("Settings",0);
        editor=prefs.edit();
     //   editor.putString("Email", "PASHA@yahoo.com");
       // editor.commit();
        String show= prefs.getString("Email", null);
        output.setText(show);
        
        submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			String str= input.getText().toString();
			output.setText(str);
			 editor.putString("Email", str);
		        editor.commit();
			}
		});
    

    
    
  //  String abc=prefs.getString("Email", null);
    //output.setText(abc);
    
    
    
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

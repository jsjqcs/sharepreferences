package com.example.sharePreference;


import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	private Button shareBtn;
	private Button getBtn;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        shareBtn = (Button)findViewById(R.id.btn);
        getBtn = (Button)findViewById(R.id.getbtn);
        shareBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				SharedPreferences.Editor editer = getSharedPreferences("data", 1).edit();
				editer.putString("username", "Jsjqcs");
				editer.putString("password", "jsjqcs123456");
				editer.putBoolean("married", false);
				editer.commit();
				Toast.makeText(MainActivity.this, "数据写入data文件成功", Toast.LENGTH_LONG).show();
			}
		});
        getBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) { 
				// TODO Auto-generated method stub
				SharedPreferences sharePreference = getSharedPreferences("data", MODE_PRIVATE);
				String username = sharePreference.getString("username", "");
				String password = sharePreference.getString("password", "");
				boolean flag = sharePreference.getBoolean("married", false);
				Log.d("MainActivity", username + " "+ password + " "+flag);
			}
		});
    }
}
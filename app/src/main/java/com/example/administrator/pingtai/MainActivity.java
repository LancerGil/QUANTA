package com.example.administrator.pingtai;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.pingtai.data.PingTai_Config;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String token = PingTai_Config.getCachedToken(this);
        if(token!=null){
            Intent intent = new Intent(this,MovementActivity.class);
            intent.putExtra(PingTai_Config.KEY_TOKEN,token);
            startActivity(intent);
        }else{
            startActivity(new Intent(this,LoginActivity.class));
        }

        finish();
    }
}
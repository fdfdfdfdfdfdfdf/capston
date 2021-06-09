package com.example.capston1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class connectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        Button actionFocusmode = (Button)findViewById(R.id.action_focusmode);
        Button loginStatus=(Button)findViewById(R.id.login_status);
        Button actionLimitmode=(Button)findViewById(R.id.action_limitmode);

        actionFocusmode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),selectpositiveActivity.class);
                startActivity(intent);
            }
        });
        actionLimitmode.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(getApplicationContext(),selectlimitActivity.class);
                startActivity(intent);
            }
        });

    }
}

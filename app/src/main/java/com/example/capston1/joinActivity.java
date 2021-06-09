package com.example.capston1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class joinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        EditText joinName=(EditText)findViewById(R.id.join_name);
        EditText joinId=(EditText)findViewById(R.id.join_id);
        EditText joinPassword=(EditText)findViewById(R.id.join_password);
        EditText joinPwck=(EditText)findViewById(R.id.join_pwck);
        EditText joinEmail=(EditText)findViewById(R.id.join_email);
        Button joinButton=(Button)findViewById(R.id.join_button);


        final String userName=joinName.getText().toString();
        final String userId=joinId.getText().toString();
        final String userPassword=joinPassword.getText().toString();
        final String userPwck=joinPwck.getText().toString();
        final String userEmail=joinEmail.getText().toString();

        joinButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(userPassword!=userPwck){
                    //비밀번호가 일치하지 않는다고 알림
                }
                if(userName.length()==0||userId.length()==0||userPassword.length()==0||userPwck.length()==0||userEmail.length()==0){
                    //입력되지 않은 항목이 있다고 알림림
               }else{
                    //DB에 입력된 정보 저장
                    //다시 로그인 페이지로 돌아감
                }
            }
        });
    }
}

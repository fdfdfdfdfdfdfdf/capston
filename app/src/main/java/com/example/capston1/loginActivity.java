package com.example.capston1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText loginId = (EditText)findViewById(R.id.login_id);
        final EditText loginPassword=(EditText)findViewById(R.id.login_password);
        Button loginNaverButton=(Button)findViewById(R.id.login_naver_button);
        Button loginKakaoButton=(Button)findViewById(R.id.login_kakao_button);
        Button loginButton=(Button)findViewById(R.id.login_button);
        Button loginJoin=(Button)findViewById(R.id.login_join);

        loginJoin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intentlogin=new Intent(getApplicationContext(),joinActivity.class);
                startActivity(intentlogin);
            }
        });

        loginNaverButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                네이버 ID로 로그인 되는 API 연결하기 -> 회원이 아닌경우 회원가입자동으로 하기
            }
        });

        loginKakaoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
//                카카오 ID로 로그인 되는 API 연동 -> 회원이 아닐경우 회원가입으로 연결
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View v) {
                    String userId = loginId.getText().toString();
                    String userPw = loginPassword.getText().toString();

                    if (userId.length() == 0) {
                        //아이디가 입력되지 않은 경우
                    }
                    if (userPw.length() == 0) {
                        //비밀번호가 입력되지 않은 경우
                    }
                    //입력한 아이디가 일치하지 않는경우
                    //입력한 비밀번호가 일치하지 않는 경우
                    //아이디와 비밀번호가 일치하는 경우

                    Intent intent = new Intent(getApplicationContext(), connectActivity.class);
                    startActivity(intent);
                }
        });


    }
}

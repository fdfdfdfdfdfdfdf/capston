package com.example.capston1;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Objects;

public class loginActivity extends AppCompatActivity {

    String loginstatus;

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
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
                public void onClick(View v) {

                final String userId = loginId.getText().toString();
                final String userPw = loginPassword.getText().toString();

                String signTure="T";
                String signFalse="F";

                if (userId.length() == 0) {
                    Toast.makeText(getApplicationContext(),"아이디를 입력해주세요.", Toast.LENGTH_SHORT).show();
                } else if (userPw.length() == 0) {
                    Toast.makeText(getApplicationContext(),"비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show();
                }else{
                    //입력한 아이디가 일치하지 않는경우
                    //입력한 비밀번호가 일치하지 않는 경우
                    //아이디와 비밀번호가 일치하는 경우

                    new Thread(){
                        public void run(){
                            try {
                                GetText(userId, userPw);
                            }catch (Exception ex){
                                System.out.println("error : " + ex);
                            }
                        }
                    }.start();

                    Toast.makeText(getApplicationContext(),loginstatus,Toast.LENGTH_SHORT).show();

                    if(loginstatus.equals(signFalse)){
                        Toast.makeText(getApplicationContext(),"아이디 혹은 비밀번호를 확인해주세요.",Toast.LENGTH_SHORT).show();
                    }else if (loginstatus.equals(signTure)){
                        Intent intent = new Intent(getApplicationContext(), connectActivity.class);
                        startActivity(intent);
                    }
                }


                }
        });


    }

    public  void  GetText(String id, String passwd)  throws UnsupportedEncodingException
    {
        // Set id value
        String userId = id;
        String userPw=passwd;

        // Create data
        //URL로 한국어를 보낼때 잘 안될 수도 있으므로 URLencoder를 이용
        String data = URLEncoder.encode("id", "UTF-8")
                + "=" + URLEncoder.encode(userId, "UTF-8")
                + URLEncoder.encode("passwd", "UTF-8")
                + "=" + URLEncoder.encode(userPw, "UTF-8");

        String text = "";
        BufferedReader reader=null;

        try {

            // Defined URL where to send data
            URL url = new URL("http://192.168.123.104:3000/user/login");

            // Send POST data request
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(data);
            wr.flush();

            // Get the server response
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;

            // Read Server Response
            while((line = reader.readLine()) != null)
            {
                // Append server response in string
                sb.append(line + "\n");
            }
            System.out.println(sb);
            text = sb.toString();
            System.out.println(text);


        } catch(Exception ex) {
            System.out.println("error : " + ex);
        }

        finally {
            try {
                reader.close();
            } catch(Exception ex) {
                System.out.println("error : " + ex);
            }
        }

        // Update global text
        loginstatus = text;
    }
}


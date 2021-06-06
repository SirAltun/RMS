package com.ertugrulaltun.restaurantmanagament;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.SQLException;
import Connection.ConnectionClass;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.security.auth.callback.PasswordCallback;

public class Login extends AppCompatActivity {

    EditText login_user,login_password;
    Button login_button;
    String UserName="";
    String Password="";
    Connection con ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login_user = (EditText)findViewById(R.id.UserName);
        login_password = (EditText)findViewById(R.id.Password);

        login_button = (Button) findViewById(R.id.LOGIN);

        Intent intent = new Intent(this, Tables.class);


        login_button.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Password = login_password.getText().toString();
                UserName = login_user.getText().toString();
                intent.putExtra("UserName",UserName);
                intent.putExtra("Password", Password);
                new Login.checkLogin().execute("");

            }
        });

    } public class checkLogin extends AsyncTask<String, String, String> {

        String z = null;
        Boolean isSuccess = false;

        @Override
        protected String doInBackground(String... strings) {

            try{
                con = ConnectionClass.connectionClass(ConnectionClass.user_name.toString(),ConnectionClass.password.toString(),ConnectionClass.database.toString(),ConnectionClass.server.toString());

                if(con == null){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(Login.this,"Check Internet Connection", Toast.LENGTH_LONG).show();
                        }
                    });
                    z = "On Internet Connection";
                }
                else {
                    try {
                        String sql = "SELECT * FROM Employee WHERE UserName = '" + login_user.getText() + "' AND Password = '" + login_password.getText() + "' ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);

                        if (rs.next()) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Login.this, "Login Success", Toast.LENGTH_LONG).show();
                                }
                            });
                            z = "Success";

                            Intent intent = new Intent(Login.this, Tables.class);
                            startActivity(intent);
                            finish();
                        } else {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(Login.this, "Check username or password", Toast.LENGTH_LONG).show();
                                }
                            });

                            login_user.setText("");
                            login_password.setText("");
                        }
                    } catch (Exception e) {
                        isSuccess = false;
                        Log.e("SQL Error : ", e.getMessage());
                    }
                }
            }
            catch (Exception e){
                isSuccess = false;
                z = e.getMessage();
            }
            return z;}

    }




}
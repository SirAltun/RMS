package com.ertugrulaltun.restaurantmanagament;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import Connection.ConnectionClass;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Tables extends AppCompatActivity {

    Connection con;
    String customerName="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView UserName_Text;

        UserName_Text = findViewById(R.id.UserName);
        Intent intent_text = getIntent();
        String UserName = intent_text.getStringExtra("UserName");
        UserName_Text.setText(UserName);

        Button myButton1 = (Button) findViewById(R.id.masa1);
        Button myButton2 = (Button) findViewById(R.id.masa2);
        Button myButton3 = (Button) findViewById(R.id.masa3);
        Button myButton4 = (Button) findViewById(R.id.masa4);
        Button myButton5 = (Button) findViewById(R.id.masa5);
        Button myButton6 = (Button) findViewById(R.id.masa6);
        Button myButton7 = (Button) findViewById(R.id.masa7);
        Button myButton8 = (Button) findViewById(R.id.masa8);
        Button myButton9 = (Button) findViewById(R.id.masa9);
        Button myButton10 = (Button) findViewById(R.id.masa10);
        Button myButton11 = (Button) findViewById(R.id.masa11);
        Button myButton12 = (Button) findViewById(R.id.masa12);

        Intent intent = new Intent(this, Order.class);
        Intent intent2 = new Intent(this, Order.class);
        Intent intent3 = new Intent(this, Order.class);
        Intent intent4 = new Intent(this, Order.class);
        Intent intent5 = new Intent(this, Order.class);
        Intent intent6 = new Intent(this, Order.class);
        Intent intent7 = new Intent(this, Order.class);
        Intent intent8 = new Intent(this, Order.class);
        Intent intent9 = new Intent(this, Order.class);
        Intent intent10 = new Intent(this, Order.class);
        Intent intent11 = new Intent(this, Order.class);
        Intent intent12 = new Intent(this, Order.class);
        con = ConnectionClass.connectionClass(ConnectionClass.user_name.toString(), ConnectionClass.password.toString(), ConnectionClass.database.toString(), ConnectionClass.server.toString());



        myButton1.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {


                try {
                    String sql = "SELECT * FROM CustomerOrder WHERE CustomerID=1";
                    Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery(sql);

                customerName = myButton1.getText().toString();
                intent.putExtra("customer",customerName);
                startActivity(intent);}

                catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        myButton2.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {
                customerName = myButton2.getText().toString();
                intent2.putExtra("customer",customerName);
                startActivity(intent2);;
            }
        });
        myButton3.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {
                customerName = myButton3.getText().toString();
                intent3.putExtra("customer",customerName);
                startActivity(intent3);;
            }
        });
        myButton4.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {
                customerName = myButton4.getText().toString();
                intent4.putExtra("customer",customerName);
                startActivity(intent4);;
            }
        });
        myButton5.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {
                customerName = myButton5.getText().toString();
                intent5.putExtra("customer",customerName);
                startActivity(intent5);;
            }
        });
        myButton6.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {
                customerName = myButton6.getText().toString();
                intent6.putExtra("customer",customerName);
                startActivity(intent6);;
            }
        });
        myButton7.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {
                customerName = myButton7.getText().toString();
                intent7.putExtra("customer",customerName);
                startActivity(intent7);;
            }
        });
        myButton8.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {
                customerName = myButton8.getText().toString();
                intent8.putExtra("customer",customerName);
                startActivity(intent8);
            }
        });
        myButton9.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {

                customerName = myButton9.getText().toString();
                intent9.putExtra("customer",customerName);
                startActivity(intent9);
            }
        });
        myButton10.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {
                customerName = myButton10.getText().toString();
                intent10.putExtra("customer",customerName);
                startActivity(intent10);
            }
        });
        myButton11.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {

                customerName = myButton11.getText().toString();
                intent11.putExtra("customer",customerName);
                startActivity(intent11);
            }
        });
        myButton12.setOnClickListener (new View.OnClickListener()
        {
            public void onClick(View v)
            {

                customerName = myButton12.getText().toString();
                intent12.putExtra("customer",customerName);
                startActivity(intent12);
            }
        });


    }

}
package com.example.easymech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MainActivity extends AppCompatActivity{

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;

    private EditText user_name;
    private EditText pass_word;
    private Button _login;
    public int counter = 5;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openHelper = new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        user_name = (EditText)findViewById(R.id._username);
        pass_word = (EditText)findViewById(R.id._password);
        _login = (Button)findViewById(R.id.login_btn);


        _login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                String username = user_name.getText().toString();
                String pass = pass_word.getText().toString();
                cursor = db.rawQuery("SELECT * FROM "+DatabaseHelper.TABLE_NAME+ " WHERE "
                        +DatabaseHelper.KEY_NAME+ "=? AND "+DatabaseHelper.KEY_PASS+"=?",
                        new String[]{username,pass});

                        if(username.equals("")){
                            user_name.setError("Enter the Username!");
                            user_name.requestFocus();
                            return;
                          }
                        else if(pass.equals("")){
                            pass_word.setError("Enter the password!");
                            pass_word.requestFocus();
                            return;
                        }

                        else if(cursor!=null){
                            if(cursor.getCount()>0){
                                cursor.moveToNext();
                                Toast.makeText(getApplicationContext(),"Login Successfull!.",Toast.LENGTH_LONG).show();
                                startActivity(new Intent(MainActivity.this,Services_LIsts.class));
                            }

                            else{
                                Toast.makeText(getApplicationContext(),"Incorrect Password or Username! Please Verify.",Toast.LENGTH_LONG).show();
                            }
                        }

            }
        });
    }

    public void sign_up_here(View v){
        TextView tv = (TextView) findViewById(R.id.sign_up_link);
        Intent int1 = new Intent(MainActivity.this, Sign_up_activity.class);
        startActivity(int1);
    }

}

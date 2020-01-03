package com.example.easymech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Sign_up_activity extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _sign_button;
    EditText editID, textname,textpass2, textphone, textemail, textpass;
    String id, name, phone, email,  pass1, pass2,code;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_activity);
        openHelper = new DatabaseHelper(this);

        _sign_button = (Button) findViewById(R.id.SignUp);
        textname = (EditText) findViewById(R.id.username);
        spinner = findViewById(R.id.Mobile_spinner);
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,CountryData.countryISO));
        textphone = (EditText) findViewById(R.id.phone);
        textemail = (EditText) findViewById(R.id.my_email);
        textpass = (EditText) findViewById(R.id.pass_word1);
        textpass2 = (EditText) findViewById(R.id.pass_word2);
        code = CountryData.countryCodes[spinner.getSelectedItemPosition()];
            _sign_button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    db=openHelper.getWritableDatabase();
                    String name = textname.getText().toString();
                    if(name.isEmpty() || (name.length()>25 && name.length()<5)){
                        textname.setError("Username is Required!");
                        textname.requestFocus();
                        return;
                    }
                    String phone = textphone.getText().toString();
                    if(phone.isEmpty() || phone.length()<10){
                        textphone.setError("Valid Number is Required!");
                        textphone.requestFocus();
                        return;
                    }
                    String mobile = "+"+ code + phone;
                    String email = textemail.getText().toString();
                    if(email.isEmpty()){
                        textemail.setError("Email Address is Required!");
                        textemail.requestFocus();
                        return;
                    }
                    else if(email.matches("[0-9a-zA-Z._-]+@[a-z]+\\.+[a-z]+")==false){
                        textemail.setError("Valid Email Address is Required!");
                        textemail.requestFocus();
                        return;
                    }
                    String pass1 = textpass.getText().toString();
                    if(pass1.isEmpty()){
                        textpass.setError("Password is Required!");
                        textpass.requestFocus();
                        return;
                    }
                    else if(pass1.length()<8){
                        Toast.makeText(getApplicationContext(),"Please Enter a Valid Password containing at least 8 characters",Toast.LENGTH_LONG).show();
                    }
                    String pass2 = textpass2.getText().toString();
                    if(pass2.isEmpty()){
                        textpass2.setError("Password is Required!");
                        textpass2.requestFocus();
                        return;
                    }

                    else if(pass2.length()<8){
                        Toast.makeText(getApplicationContext(),"Please Enter a Valid Password containing at least 8 characters",Toast.LENGTH_LONG).show();
                        return;
                    }
                    else if(pass1.equals(pass2)) {
                        insertData(name, mobile, email, pass2);
                        Toast.makeText(getApplicationContext(), "Your account is in progress! Please confirm your phone number", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Sign_up_activity.this, Mobile_OTP.class);
                        intent.putExtra("phonenumber", mobile);
                        startActivity(intent);
                    }
                    else {
                        textpass2.setError("Password Doesn't Match!");
                        textpass2.requestFocus();
                        return;
                    }


                }
            });

    }
    public void insertData(String username, String mobile, String email, String pass2){
        ContentValues val = new ContentValues();
        val.put(DatabaseHelper.KEY_NAME,username);
        val.put(DatabaseHelper.KEY_MOBILE,mobile);
        val.put(DatabaseHelper.KEY_EMAIL,email);
        val.put(DatabaseHelper.KEY_PASS,pass2);
        long id = db.insert(DatabaseHelper.TABLE_NAME,null,val);

    }



}

package com.example.easymech;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

class USER_DETAILS extends Base_Home{

    public String usernamess = Base_Home.username;
    public String passes = Base_Home.pass;

}

public class AccountFragment extends Fragment {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Cursor cursor;



    private TextView user_name, user_email, user_phone, profile_names, profile_emails;
    private Button user_update, user_logout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_account, container, false);

        openHelper = new DatabaseHelper(getContext());
        db=openHelper.getReadableDatabase();
        user_name = (TextView) rootView.findViewById(R.id.user_account_name);
        user_email = (TextView) rootView.findViewById(R.id.user_email);
        user_phone = (TextView) rootView.findViewById(R.id.user_phone);
        profile_emails = (TextView) rootView.findViewById(R.id.profile_email);
        profile_names = (TextView) rootView.findViewById(R.id.profile_name);


       // user_logout = (Button)rootView.findViewById(R.id.login_btn);
      /*  cursor = db.rawQuery("SELECT * FROM "+DatabaseHelper.TABLE_NAME+ " WHERE " +DatabaseHelper.KEY_NAME+ "=? AND" +
                " "+DatabaseHelper.KEY_PASS+"=?", new String[]{"Nova","12345678"}); */
        cursor = db.rawQuery("SELECT * FROM "+DatabaseHelper.TABLE_NAME, null);

        if(cursor.getCount()==0){
            Toast.makeText(getContext(),"Nothing found",Toast.LENGTH_LONG).show();
        }
        while (cursor.moveToNext()){
            user_name.setText(cursor.getString(1));
            user_email.setText(cursor.getString(3));
            user_phone.setText(cursor.getString(2));
            profile_names.setText(cursor.getString(1));
            profile_emails.setText(cursor.getString(3));
        }

        return rootView;
    }
}

package com.master.sharepreferenceexample;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public EditText edtInputValue;
    public TextView txtShow;


    public final String MY_SREFS_NAME = "myPref";
    final String NAME = "name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtInputValue = findViewById(R.id.edt_input_value);
        txtShow = findViewById(R.id.txt_show);
        findViewById(R.id.btn_submitData).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputValue = edtInputValue.getText().toString();
                txtShow.setText(inputValue);

                SharedPreferences.Editor editor = getSharedPreferences(MY_SREFS_NAME, MODE_PRIVATE).edit();
                editor.putString(NAME, inputValue);
                editor.apply();

            }
        });

        SharedPreferences preferences = getSharedPreferences(MY_SREFS_NAME, MODE_PRIVATE);
        String name = preferences.getString(NAME, "no value");
        txtShow.setText(name);
        edtInputValue.setText(name);
    }
}

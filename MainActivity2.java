package com.example.passingdata.sobolnikov303;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity2 extends AppCompatActivity {
    EditText editTextMessage2;
    Switch switch1;
    Switch switch2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextMessage2 = findViewById(R.id.editTextMessage2);
        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);

        Intent i = getIntent();
        String s = i.getStringExtra("abc");
        Boolean a_2 = i.getBooleanExtra("a1", false);
        Boolean b_2 = i.getBooleanExtra("b1", false);

        switch1.setChecked(a_2);
        switch2.setChecked(b_2);

        editTextMessage2.setText(s);
    }

    public void Ok_onClick(View view) {
        Intent i = new Intent();
        Boolean Checked1 = switch1.isChecked();
        Boolean Checked2 = switch2.isChecked();

        switch1.setChecked(Checked1);
        switch2.setChecked(Checked2);

        String s = editTextMessage2.getText().toString();
        i.putExtra("qwe", s);
        i.putExtra("a", switch1.isChecked());
        i.putExtra("b", switch2.isChecked());
        setResult(RESULT_OK, i);
        finish();
    }

    public void Cancel_onClick(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
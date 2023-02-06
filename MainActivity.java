package com.example.passingdata.sobolnikov303;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewMessage;
    EditText editTextMessage;
    CheckBox checkBoxFlag1;
    CheckBox checkBoxFlag2;
    String message = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = findViewById(R.id.editTextMessage);
        textViewMessage = findViewById(R.id.textViewMessage);
        checkBoxFlag1 = findViewById(R.id.checkBoxFlag1);
        checkBoxFlag2 = findViewById(R.id.checkBoxFlag2);
    }

    @Override
    protected void onActivityResult(int requesCode, int resultCode, @Nullable Intent data) {
        if (requesCode == 555 && data != null) {
            String s = data.getStringExtra("qwe");
            Boolean a_2 = data.getBooleanExtra("a", false);
            Boolean b_2 = data.getBooleanExtra("b", false);

            checkBoxFlag1.setChecked(a_2);
            checkBoxFlag2.setChecked(b_2);

            textViewMessage.setText(s);
        }

        super.onActivityResult(requesCode, resultCode, data);
    }

    public void OpenDialog_onClick(View view) {
        String s = editTextMessage.getText().toString();
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("abc", s);
        i.putExtra("a1", checkBoxFlag1.isChecked());
        i.putExtra("b1", checkBoxFlag2.isChecked());

        startActivityForResult(i, 555);
    }

    public void ExitApp_onClick(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Закрыть приложение?")
                .setIcon(R.drawable.icon)
                .setPositiveButton("Да", (arg0, arg1) -> finish())
                .setNegativeButton("Нет", (arg0, arg1) -> {})
                .show();
    }

    public void NewDialog_onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("Введите сообщение");

        final EditText input = new EditText(this);

        input.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(input);

        builder.setPositiveButton(R.string.infoOk, (dialog, which) -> {
            message = input.getText().toString();
            textViewMessage.setText(message);
        });

        builder.setNegativeButton(R.string.infoCancel, (dialog, which) -> dialog.cancel());

        builder.show();
    }
}
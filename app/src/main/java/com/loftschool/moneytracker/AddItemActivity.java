package com.loftschool.moneytracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {
    EditText nameItem;
    EditText priceItem;
    TextView addItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameItem = (EditText) findViewById(R.id.nameItemEditText);
        priceItem = (EditText) findViewById(R.id.priceItemEditText);
        addItem = (TextView) findViewById(R.id.addItemTextView);
        nameItem.addTextChangedListener(watcher);
        priceItem.addTextChangedListener(watcher);
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(AddItemActivity.this, R.string.toast_item_added, Toast.LENGTH_SHORT).show();
            }
        });
    }

    TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            addItem.setEnabled(!TextUtils.isEmpty(nameItem.getText().toString().trim()) && (!TextUtils.isEmpty(priceItem.getText().toString().trim())));
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };
}

package com.tacademy.jeongho.kakaopj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioGroup;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText inputView;
    RadioGroup categoryView;
    ChattingAdapter mAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputView = (EditText)findViewById(R.id.edit_input);
        categoryView = (RadioGroup)findViewById(R.id.category);
        listView = (ListView)findViewById(R.id.listView);
        mAdapter = new ChattingAdapter();
        listView.setAdapter(mAdapter);

        Button btn = (Button)findViewById(R.id.btn_insert);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id = categoryView.getCheckedRadioButtonId();
                switch (id){
                    case R.id.radio_receive:
                        ReceiveData rd = new ReceiveData();
                        rd.iconId = R.mipmap.ic_launcher;
                        rd.message = inputView.getText().toString();
                        mAdapter.add(rd);
                        break;

                    case R.id.radio_send:
                        SendData sd = new SendData();
                        sd.iconId = R.mipmap.ic_launcher;
                        sd.message = inputView.getText().toString();
                        mAdapter.add(sd);
                        break;

                    case R.id.radio_date:
                        DateData dd = new DateData();
                        dd.message = new Date().toString();
                        mAdapter.add(dd);
                        break;
                }
                inputView.setText("");
                listView.smoothScrollToPosition(mAdapter.getCount()-1);
            }
        });

    }
}

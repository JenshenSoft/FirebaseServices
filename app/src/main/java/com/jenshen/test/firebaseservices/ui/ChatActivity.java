package com.jenshen.test.firebaseservices.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.messaging.FirebaseMessaging;
import com.jenshen.test.firebaseservices.R;

public class ChatActivity extends AppCompatActivity {

    public static final String BROADCAST_ACTION = "com.jenshen.test.firebaseservices.chatbroadcast";
    public static final String MESSAGE_KEY = "Message";

    private ChatReceiver receiver;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        FirebaseMessaging.getInstance().subscribeToTopic("news");
        textView = findViewById(R.id.text);
        final EditText editText = findViewById(R.id.edittext);
        Button send = findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();

            }
        });
        IntentFilter filter = new IntentFilter(BROADCAST_ACTION);
        receiver = new ChatReceiver();
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }

    public class ChatReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            textView.setText(textView.getText() + "\n " + intent.getStringExtra(MESSAGE_KEY));
        }
    }
}

package com.droi.hava;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;

import com.droi.immodule.IMRong;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

public class MainActivity extends Activity {

    String Tag="MainActivity";

    @BindView(R.id.button)
    Button talkShoper;

    @BindView(R.id.button2)
    Button moreMsg;

    @OnClick(R.id.button) void goTalker(){
        if(!IMRong.getInstance().goCustomerService(this)){
            Log.d(Tag,"go customer service is failed!");
        }
    }

    @OnClick(R.id.button2) void goMoreMsg(){
        if(!IMRong.getInstance().goMsgManager(this)){
            Log.d(Tag,"go msg manager is failed!");
        }
    }

    @OnClick(R.id.button3) void goTest(){
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse("app://com.droi.hava/test")));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }
}

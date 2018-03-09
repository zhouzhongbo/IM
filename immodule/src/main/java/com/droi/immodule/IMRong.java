package com.droi.immodule;

import android.content.Context;
import android.util.Log;

import com.droi.immodule.util.Config;

import java.util.HashMap;
import java.util.Map;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.Conversation;

/**
 * Created by zzb on 2018/3/8.
 */

public class IMRong {
    Context mcontext;
    static IMRong im;
    String Tag = "RongIM";

    String Token="Ut5O3sNqJNXVUHmKDWV17p7rS/OOlkRUGdGUp7Uzhlk5DpGLoNSTte+ze7QdD+UaW44DgS0idjGWKv2iWMWXhkJfxHln1gxV";
    String userId="zhouzhongbo";

    String Token2="Mw+rPxFzFjj/spbiqI1VBmiQHby8cPZdhzsU1Toh22hwOQYP48j7psknMZy7JFJj59DDmpOS6UZiLwN7kjACaw==";
    String userId2="bobo";


    private IMRong(){
//        RongIM.init(context);
    }


    public void Init(Context context){
        RongIM.init(context);
        String imToken= getToken();
        RongServerConnect(imToken);
    }

    private String getToken(){
//        here do net Request,to get token
        return Token;
    }


    public void RongServerConnect(String token){
        RongIM.connect(token, new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                Log.d(Tag,"onTokenIncorrect");
            }

            @Override
            public void onSuccess(String s) {
                Log.d(Tag,"onSuccess："+s);
            }

            @Override
            public void onError(RongIMClient.ErrorCode errorCode) {
                Log.d(Tag,"onError："+errorCode);
            }
        });
    }


    public static IMRong getInstance(){
        if(im == null){
            im = new IMRong();
        }
        return im;
    }

    public boolean goCustomerService(Context activity){
        Boolean result  = true;
        if(RongIM.getInstance().getCurrentConnectionStatus() == RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED){
            RongIM.getInstance().startPrivateChat(activity, Config.baseCustomerService, "bobo");
        }else{
            Log.d(Tag,"now is not connect to rongcloud server!");
            result = false;
        }
        return result;
    }

    public boolean goMsgManager(Context activity){
        Boolean result =true;
        if(io.rong.imkit.RongIM.getInstance().getCurrentConnectionStatus() == RongIMClient.ConnectionStatusListener.ConnectionStatus.CONNECTED){
            Map<String, Boolean> map = new HashMap<>();
            map.put(Conversation.ConversationType.PRIVATE.getName(), false); // 会话列表需要显示私聊会话, 第二个参数 true 代表私聊会话需要聚合显示
            map.put(Conversation.ConversationType.GROUP.getName(), true);
            map.put(Conversation.ConversationType.APP_PUBLIC_SERVICE.getName(),true);
            map.put(Conversation.ConversationType.PUBLIC_SERVICE.getName(),true);
            map.put(Conversation.ConversationType.PUSH_SERVICE.getName(),true);
            map.put(Conversation.ConversationType.SYSTEM.getName(),false);
            RongIM.getInstance().startConversationList(activity,map);
        }else{
            result = false;
            Log.d(Tag,"now is not connect to rongcloud server!");
        }
        return result;
    }
}

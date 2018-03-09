package com.droi.immodule.receiver;


import android.content.Context;

import io.rong.push.notification.PushMessageReceiver;
import io.rong.push.notification.PushNotificationMessage;

/**
 * Created by zzb on 2018/3/8.
 */

public class HaveNotificationReceiver extends PushMessageReceiver {
    public HaveNotificationReceiver() {
        super();
    }

    @Override
    public boolean onNotificationMessageArrived(Context context, PushNotificationMessage pushNotificationMessage) {
        return false;
    }

    @Override
    public boolean onNotificationMessageClicked(Context context, PushNotificationMessage pushNotificationMessage) {
        return false;
    }
}

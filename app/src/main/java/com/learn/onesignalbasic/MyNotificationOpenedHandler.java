package com.learn.onesignalbasic;

import android.app.Application;
import android.util.Log;

import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

public class MyNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {

    public static final String INVITE_ME_ACTION_ID = "invite";
    public static final String TAG = "InviteMe";
    private Application application;

    public MyNotificationOpenedHandler(Application application) {
        this.application = application;
    }

    @Override
    public void notificationOpened(OSNotificationOpenResult result) {

        OSNotificationAction.ActionType actionType = result.action.type;
        JSONObject data = result.notification.payload.additionalData;
        String customKey;
        if (data != null) {
            customKey = data.optString("customkey", null);
            if (customKey != null)
                Log.i("OneSignalExample", "customkey set with value: " + customKey);
        }

        // 27-Aug-18
        if (actionType == OSNotificationAction.ActionType.ActionTaken) {

            Log.i(TAG, "Button pressed with id: " + result.action.actionID);

        }
    }
}

package com.doubledotlabs.senzil.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.preference.PreferenceManager;

import com.doubledotlabs.senzil.service.DeleteOldMessagesService;
import com.doubledotlabs.senzil.transaction.NotificationManager;
import com.doubledotlabs.senzil.ui.settings.SettingsFragment;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager.initQuickCompose(context, false, false);
        NotificationManager.create(context);

        SettingsFragment.updateAlarmManager(context, PreferenceManager.getDefaultSharedPreferences(context).getBoolean(SettingsFragment.NIGHT_AUTO, false));

        DeleteOldMessagesService.setupAutoDeleteAlarm(context);
    }
}

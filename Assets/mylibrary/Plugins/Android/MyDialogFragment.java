package com.example.fishwaffle.mylibrary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;

import com.unity3d.player.UnityPlayer;

public class MyDialogFragment extends DialogFragment {
    public static void showDialogFragment(String title, String message,
                                          String positiveMessage, String negativeMessage,
                                          boolean cancelable,
                                          String gameObjectName,
                                          String positiveCallbackName, String negativeCallbackName) {
        final MyDialogFragment dialog = new MyDialogFragment();
        final Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("message", message);
        bundle.putString("positiveMessage", positiveMessage);
        bundle.putString("negativeMessage", negativeMessage);
        bundle.putString("gameObjectName", gameObjectName);
        bundle.putString("positiveCallbackName", positiveCallbackName);
        bundle.putString("negativeCallbackName", negativeCallbackName);
        bundle.putBoolean("cancelable", cancelable);
        dialog.setArguments(bundle);

        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                dialog.show(UnityPlayer.currentActivity.getFragmentManager(), MyDialogFragment.class.getSimpleName());
            }
        });
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Bundle arguments = getArguments();
        final String title = arguments.getString("title");
        final String message = arguments.getString("message");
        final String positiveMessage = arguments.getString("positiveMessage");
        final String negativeMessage = arguments.getString("negativeMessage");
        final String gameObjectName = arguments.getString("gameObjectName");
        final String positiveCallbackName = arguments.getString("positiveCallbackName");
        final String negativeCallbackName = arguments.getString("negativeCallbackName");
        setCancelable(arguments.getBoolean("cancelable"));
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        if (!TextUtils.isEmpty(title)) {
            builder.setTitle(title);
        }
        if (!TextUtils.isEmpty(message)) {
            builder.setMessage(message);
        }
        if (!TextUtils.isEmpty(positiveMessage)) {
            builder.setPositiveButton(positiveMessage, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (!TextUtils.isEmpty(gameObjectName) && !TextUtils.isEmpty(positiveCallbackName)) {
                        UnityPlayer.UnitySendMessage(gameObjectName, positiveCallbackName, "");

                    }
                }
            });
        }
        if (!TextUtils.isEmpty(negativeMessage)) {
            builder.setNegativeButton(negativeMessage, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (!TextUtils.isEmpty(gameObjectName) && !TextUtils.isEmpty(negativeCallbackName)) {
                        UnityPlayer.UnitySendMessage(gameObjectName, negativeCallbackName, "");
                    }
                }
            });
        }
        return builder.create();
    }


}

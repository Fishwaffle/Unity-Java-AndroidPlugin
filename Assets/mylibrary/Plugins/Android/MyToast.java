/*
 * Copyright (c) 2018 FishWaffle.
 */

package com.example.fishwaffle.mylibrary;

import android.widget.Toast;

import com.unity3d.player.UnityPlayer;

public class MyToast {
    /**
     * トースト表示
     * @param text     表示文字
     * @param duration 表示時間 0:SHORT 1:LONG
     */
    public static void showToast(final String text, final int duration) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(UnityPlayer.currentActivity, text, duration).show();
            }
        });
    }
}

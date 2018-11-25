package com.example.fishwaffle.mylibrary;

import android.util.Log;

public class MyClass {
    public static void staticMethod() {
        Log.d("TEST", "staticMethod");

    }

    public void instanceMethod() {

        Log.d("TEST", "instanceMethod");
    }

  public   static class innerClass {
        public static void staticMethodInner() {
            Log.d("TEST", "staticMethodInner");
        }

        public void instanceMethodInner() {
            Log.d("TEST", "instanceMethodInner");
        }
    }
}

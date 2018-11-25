using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Test : MonoBehaviour
{
    public void staticMethod()
    {
        using (var javaClass = new AndroidJavaClass("com.example.fishwaffle.mylibrary.MyClass"))
        {
            javaClass.CallStatic("staticMethod");
        }
    }

    public void instanceMethod()
    {
        using (var javaObj = new AndroidJavaObject("com.example.fishwaffle.mylibrary.MyClass"))
        {
            javaObj.Call("instanceMethod");
        }

    }

    public void staticMethodInner()
    {
        using (var javaClass = new AndroidJavaClass("com.example.fishwaffle.mylibrary.MyClass$innerClass"))
        {
            javaClass.CallStatic("staticMethodInner");
        }
    }
    public void instanceMethodInner()
    {
        using (var javaObj = new AndroidJavaObject("com.example.fishwaffle.mylibrary.MyClass$innerClass"))
        {
            javaObj.Call("instanceMethodInner");
        }

    }

}

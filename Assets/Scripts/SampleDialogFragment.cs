using UnityEngine;
using AndroidPlugin;
using System;
public class SampleDialogFragment : MonoBehaviour
{
    public void onClick()
    {
        DialogFragment.showDialogFragment(title: "質問", message: "たい焼きはつぶ餡派?",
            positiveMessage: "YES",
            positiveCallbackName: ((Action)onDialogPositiveButton).Method.Name,
            negativeMessage: "NO",
            negativeCallbackName: ((Action)onDialogNegativeButton).Method.Name,
            gameObjectName: gameObject.name);
    }
    public void onDialogPositiveButton()
    {
        Toast.show("(*´ω｀*)", 0);
    }
    public void onDialogNegativeButton()
    {
        Toast.show("(´・ω・｀)", 0);
    }
}

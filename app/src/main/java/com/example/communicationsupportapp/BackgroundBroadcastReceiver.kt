package com.example.communicationsupportapp

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class BackgroundBroadcastReceiver : BroadcastReceiver() {

    private var db = Firebase.firestore

    override fun onReceive(context: Context, intent: Intent) {
        var action: String? = intent.getAction()
        if(action.equals(Intent.ACTION_SCREEN_ON)){
            Log.d("BackgroundBroadcastReceiver", "screen_on")
            var screen: String = "screen_on"
            val state: MutableMap<String, Any> = HashMap()
            state["screen"] = screen
            db.collection("states").document("t3inKlHDzNfGhgkfuMqC").update(state)
        } else if(action.equals(Intent.ACTION_SCREEN_OFF)){
            Log.d("BackgroundBroadcastReceiver", "screen_off")
            var screen: String = "screen_off"
            val state: MutableMap<String, Any> = HashMap()
            state["screen"] = screen
            db.collection("states").document("t3inKlHDzNfGhgkfuMqC").update(state)
        } else if(action.equals(Intent.ACTION_USER_PRESENT)){
            Log.d("BackgroundBroadcastReceiver", "screen_unlocked")
        }
    }
}

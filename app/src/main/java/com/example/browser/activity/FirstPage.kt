package com.example.browser.activity

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import androidx.cardview.widget.CardView
import com.example.browser.R
import com.example.browser.database.PreferencesGateway
import com.example.browser.databinding.ActivityFirstPageBinding
import com.example.browser.databinding.ActivityMainBinding

class FirstPage : AppCompatActivity() {

    lateinit var binding: ActivityFirstPageBinding
    private lateinit var preferences: PreferencesGateway

    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferences = PreferencesGateway(this)


        val uri = Uri.parse("content://com.lock.applock.provider/shared_prefs")

        val isBlacklistedChecked = getBooleanFromProvider(uri, "WebBlacklist", false)
        val isWhitelistedChecked = getBooleanFromProvider(uri, "WebWhitelist", false)
        val blockedWebsites = getListFromProvider(uri, "blockedWebsites")
        val allowedWebsites = getListFromProvider(uri, "allowedWebsites")

        Log.d("abdo", "isBlacklistedChecked $isBlacklistedChecked")
        Log.d("abdo", "isWhitelistedChecked $isWhitelistedChecked")
        Log.d("abdo", "blockedWebsites $blockedWebsites")
        Log.d("abdo", "allowedWebsites $allowedWebsites")






        binding.webCardView.setOnClickListener {
            val webIntent = Intent(this, MainActivity::class.java)
            startActivity(webIntent)
        }


    }

    // Function to fetch boolean value from the content provider
    fun getBooleanFromProvider(uri: Uri, key: String, defaultValue: Boolean): Boolean {
        val cursor = contentResolver.query(uri, null, key, null, null)
        val value = cursor?.use { cursor ->
            if (cursor.moveToFirst()) {
                cursor.getInt(cursor.getColumnIndexOrThrow("value")) == 1
            } else {
                defaultValue
            }
        } ?: defaultValue
        cursor?.close()
        return value
    }

    // Function to fetch list value from the content provider
    fun getListFromProvider(uri: Uri, key: String): List<String> {
        val cursor = contentResolver.query(uri, null, key, null, null)
        val value = mutableListOf<String>()
        cursor?.use { cursor ->
            while (cursor.moveToNext()) {
                value.add(cursor.getString(cursor.getColumnIndexOrThrow("value")))
            }
        }
        cursor?.close()
        return value
    }
}

//blackListed Switch
//        blackListSwitch = findViewById(R.id.blackList_switch2)
//        blackListSwitch.isChecked = preferences.loadBoolean("WebBlacklist",false)
//        blackListSwitch.setOnCheckedChangeListener { _, isChecked ->
//            if(isChecked){
//                whiteListSwitch.isChecked = false
//            }
//            // Save the state of the Switch to SharedPreferences
//            preferences.saveBoolean("WebBlacklist", isChecked)
//            Log.d("abdo", "black list value ${blackListSwitch.isChecked}")
//        }

//whiteList Switch
//        whiteListSwitch = findViewById(R.id.whiteListSwitch)
//        whiteListSwitch.isChecked = preferences.loadBoolean("WebWhitelist", false)
//        whiteListSwitch.setOnCheckedChangeListener { _, isChecked ->
//            if (isChecked){
//                blackListSwitch.isChecked = false
//            }
//            preferences.saveBoolean("WebWhitelist", isChecked)
//        }
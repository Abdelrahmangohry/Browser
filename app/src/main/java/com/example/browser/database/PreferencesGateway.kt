package com.example.browser.database

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

const val PREFERENCES_NAME = "PREFERENCES_NAME"

class PreferencesGateway(private val context: Context) {

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }
    private val gson = Gson()

    fun saveBoolean(key: String, value: Boolean) {
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .putBoolean(key, value)
            .apply()
    }

    //get shared preferences
    fun getPrefVal(context: Context): SharedPreferences {
        val sharedPreferences =
            context.getSharedPreferences("settings", Context.MODE_PRIVATE)
        return sharedPreferences
    }


    //set shared preferences
    fun setPrefVal(context: Context, key: String, value: String) {
        if (key != null) {
            val editor: SharedPreferences.Editor = getPrefVal(context).edit()
            editor.putString(key, value)
            editor.apply()
        }
    }


    //delete shared preferences
    fun delSharedVal(context: Context) {
        val editor: SharedPreferences.Editor = getPrefVal(context).edit()
        editor.clear()
        editor.apply()
    }

    fun loadBoolean(key: String, defaultValue: Boolean): Boolean {
        return context
            .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
            .getBoolean(key, defaultValue)
    }

    fun remove(key: String) {
        context
            .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .remove(key)
            .apply()
    }

    fun clearAll() {
        context
            .getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
            .edit()
            .clear()
            .apply()
    }

    // Save an ArrayList to SharedPreferences
    fun saveList(key: String, list: List<String>) {
        val jsonString = gson.toJson(list)
        sharedPreferences.edit().putString(key, jsonString).apply()
    }

    // Retrieve an ArrayList from SharedPreferences
    fun getList(key: String): ArrayList<String> {
        val jsonString = sharedPreferences.getString(key, null)
        return if (jsonString != null) {
            gson.fromJson(jsonString, object : TypeToken<ArrayList<String>>() {}.type)
        } else {
            ArrayList()
        }
    }
}
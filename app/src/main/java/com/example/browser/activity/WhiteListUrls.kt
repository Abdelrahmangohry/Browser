package com.example.browser.activity

//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.text.TextUtils
//import android.widget.Button
//import android.widget.EditText
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.example.browser.R
//import com.example.browser.adapter.WhiteListWebAdapter
//import com.example.browser.database.PreferencesGateway
//
//class WhiteListUrls : AppCompatActivity() , PublicClickListener{
//    private lateinit var recyclerWhite: RecyclerView
//    private lateinit var btnWhiteList: Button
//    private lateinit var etWhiteListWebsite: EditText
//    private lateinit var allowedWebsites: ArrayList<String>
//    private lateinit var adapterAllowed: WhiteListWebAdapter
//    private lateinit var preferences: PreferencesGateway
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_white_list_urls)
//        preferences = PreferencesGateway(this)
//
//        initView()
//        setUpData()
//        // Initialize views
//        btnWhiteList.setOnClickListener {
//            val strWhiteSite: String = etWhiteListWebsite.text.toString().trim()
//            if (!TextUtils.isEmpty(strWhiteSite)) {
//                if (!allowedWebsites.contains(strWhiteSite)) {
//                    allowedWebsites.add(strWhiteSite)
//                    preferences.saveList("allowedWebsites", allowedWebsites)
//                }
//            }
//
//            etWhiteListWebsite.text.clear()
//            adapterAllowed.setData(allowedWebsites)
//        }
//
//    }
//    private fun setUpData() {
//        allowedWebsites = ArrayList()
//        adapterAllowed = WhiteListWebAdapter(this, this)
//        recyclerWhite.adapter = adapterAllowed
//        preferences = PreferencesGateway(this)
//        allowedWebsites = preferences.getList("allowedWebsites")
//        adapterAllowed.setData(allowedWebsites)
//    }
//
//
//
//    private fun initView() {
//        etWhiteListWebsite = findViewById(R.id.etWhiteListWebsite)
//        recyclerWhite = findViewById(R.id.recyclerWhite)
//        btnWhiteList = findViewById(R.id.btnAddWhiteList)
//
//    }
//
//
//
//    override fun onDetailsClick(position: Int) {
//        allowedWebsites.toMutableList().apply {
//            removeAt(position)
//            allowedWebsites.removeAt(position)
//            preferences.saveList("allowedWebsites", this)
//            adapterAllowed.setData(allowedWebsites)
//
//        }
//
//    }
//
//}
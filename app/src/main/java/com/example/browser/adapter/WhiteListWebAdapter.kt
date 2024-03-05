package com.example.browser.adapter


//import com.example.browser.R
//import com.example.browser.activity.WhiteListUrls
//import com.example.browser.database.PreferencesGateway
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//import com.example.browser.activity.PublicClickListener


//class WhiteListWebAdapter(
//    private val context: Context,
//    private val mListener: PublicClickListener
//) : RecyclerView.Adapter<WhiteListWebAdapter.MyViewHolder>() {
//    private var myList = mutableListOf<String>()
//    private lateinit var sharedPrefManager: PreferencesGateway
//
//
//    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val itemList: TextView = itemView.findViewById(R.id.itemList)
//        val deleteItemButton: ImageView = itemView.findViewById(R.id.deleteItemButton)
//    }
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val view =
//            LayoutInflater.from(parent.context).inflate(R.layout.item_list_sites, parent, false)
//        sharedPrefManager = PreferencesGateway(context)
//
//        return MyViewHolder(view)
//    }
//
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//
//        holder.itemList.text = myList[position]
//
//        // Handle item deletion
//        holder.deleteItemButton.setOnClickListener {
//            val currentPos = holder.adapterPosition
//
//
//            mListener.onDetailsClick(currentPos)
//
//
//        }
//    }
//
//    override fun getItemCount(): Int {
//        return myList.size
//
//    }
//
//    fun setData(list: List<String>) {
//        myList.clear()  // Clear existing items in the list
//        myList.addAll(list)
//        notifyDataSetChanged()
//    }
//}

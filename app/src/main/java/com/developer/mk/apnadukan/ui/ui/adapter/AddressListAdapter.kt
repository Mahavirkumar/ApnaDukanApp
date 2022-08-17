package com.developer.mk.apnadukan.ui.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer.mk.apnadukan.R
import com.developer.mk.apnadukan.models.Address
import kotlinx.android.synthetic.main.item_address_layout.view.*

class AddressListAdapter(
    private val context: Context,
    private var list:ArrayList<Address>
) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return AddressListAdapter.MyViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_address_layout,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model=list[position]
        if(holder is MyViewHolder){
            holder.itemView.tv_address_full_name.text = model.name
            holder.itemView.tv_address_type.text = model.type
            holder.itemView.tv_address_details.text = "${model.address}, ${model.zipCode}"
            holder.itemView.tv_address_mobile_number.text = model.mobileNumber
        }
    }

    override fun getItemCount(): Int {
         return list.size
    }

    /**
     * A ViewHolder describes an item view and metadata about its place within the RecyclerView.
     */
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
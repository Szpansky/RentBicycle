package com.apps.mkacik.rentbicycle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.database.entity.Rent
import kotlinx.android.synthetic.main.item_layout_rented_bicycle.view.*

class RentedAdapter(private val rentList: List<Rent>) :
    RecyclerView.Adapter<RentedAdapter.ViewHolder>() {

    companion object {
        var rentedAdapterInterface: RentedAdapterInterface? = null
    }

    interface RentedAdapterInterface {
        fun onItemClick(rent: Rent)
    }

    fun bindInterface(rentedAdapterInterface: RentedAdapterInterface) {
        RentedAdapter.rentedAdapterInterface = rentedAdapterInterface
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_rented_bicycle, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(rentList[position])
    }

    override fun getItemCount(): Int {
        return rentList.size
    }

    override fun getItemId(position: Int): Long {
        return rentList[position].id.toLong()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(rent: Rent) {
            itemView.item_id.text = rent.bicycleId.toString()
            itemView.item_layout.setOnClickListener { rentedAdapterInterface?.onItemClick(rent) }
        }
    }
}
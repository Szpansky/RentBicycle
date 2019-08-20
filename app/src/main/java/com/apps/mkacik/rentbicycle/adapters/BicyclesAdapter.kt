package com.apps.mkacik.rentbicycle.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import kotlinx.android.synthetic.main.item_layout_bicycle.view.*

class BicyclesAdapter(private val bicycleList: List<BicycleEntity>) :
    RecyclerView.Adapter<BicyclesAdapter.ViewHolder>() {

    companion object {
        var bicycleAdapterInterface: BicycleAdapterInterface? = null
    }

    interface BicycleAdapterInterface {
        fun onItemClick(bicycleEntity: BicycleEntity)
        fun onRentClick(bicycleEntity: BicycleEntity)
    }

    fun bindInterface(bicycleAdapterInterface: BicycleAdapterInterface) {
        BicyclesAdapter.bicycleAdapterInterface = bicycleAdapterInterface
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_bicycle, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bicycleList[position])
    }

    override fun getItemCount(): Int {
        return bicycleList.size
    }

    override fun getItemId(position: Int): Long {
        return bicycleList[position].id.toLong()
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(bicycleEntity: BicycleEntity) {
            itemView.color.text = bicycleEntity.color
            itemView.brand.text = bicycleEntity.brand
            itemView.price.text =
                String.format("%.2f ${itemView.resources.getString(R.string.integer_extend)}", bicycleEntity.price)
            itemView.status.text = if (bicycleEntity.availability)
                itemView.resources.getString(BicycleEntity.BICYCLE_AVAILABILITY_TRUE)
            else
                itemView.resources.getString(BicycleEntity.BICYCLE_AVAILABILITY_FALSE)
            itemView.item_id.text = bicycleEntity.id.toString()
            itemView.item_layout.setOnClickListener { bicycleAdapterInterface?.onItemClick(bicycleEntity) }
            itemView.rent_bicycle.setOnClickListener { bicycleAdapterInterface?.onRentClick(bicycleEntity) }
        }
    }
}
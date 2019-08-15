package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.apps.mkacik.rentbicycle.R

class BicycleListFragment : Fragment() {

    companion object {
        val TAG = this::class.java.name
        const val NAME = "Bicycles List"

        fun newInstance(): BicycleListFragment {
            return BicycleListFragment()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_all_bicycle, container, false)
        setHasOptionsMenu(true)
        activity!!.title = NAME
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.all_bicycle_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.sort_by_cost_item -> true
            R.id.sort_by_status_item -> true
            R.id.sort_by_color_item -> true
            R.id.sort_by_brand_item -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
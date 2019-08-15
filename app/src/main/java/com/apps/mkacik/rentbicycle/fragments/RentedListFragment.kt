package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.apps.mkacik.rentbicycle.R

class RentedListFragment : Fragment() {

    companion object {
        val TAG = this::class.java.name
        const val NAME = "Rented Bicycles"

        fun newInstance(): RentedListFragment {
            return RentedListFragment()
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my_bicycle, container, false)
        setHasOptionsMenu(true)
        activity!!.title = NAME
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.rented_bicycle_menu, menu)
    }
}
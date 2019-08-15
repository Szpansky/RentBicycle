package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.ViewModels.BicyclesViewModel
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.utilities.InjectorUtils
import kotlinx.android.synthetic.main.fragment_all_bicycle.*

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

        val factory = InjectorUtils.provideBicyclesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory).get(BicyclesViewModel::class.java)

        viewModel.getBicycles().observe(this, Observer { bicycles ->
            val stringBuilder = StringBuilder()

            bicycles.forEach { bicycle ->
                stringBuilder.append("${bicycle.id}+${bicycle.brand}\n\n")
            }

            textView.text = stringBuilder.toString()
        })



        button.setOnClickListener {
            val bicycle = BicycleEntity(true, 12.5F, "red", "rower")
            Thread{viewModel.addBicycle(bicycle)}.start()

        }
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
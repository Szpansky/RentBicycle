package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.adapters.BicyclesAdapter
import com.apps.mkacik.rentbicycle.data.BicycleLoadingProvider
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.utilities.InjectorUtils
import com.apps.mkacik.rentbicycle.viewModels.BicyclesViewModel
import kotlinx.android.synthetic.main.fragment_all_bicycle.*

class BicycleListFragment : Fragment(), BicyclesAdapter.BicycleAdapterInterface {

    private lateinit var viewModel: BicyclesViewModel

    val lifecycleOwner: LifecycleOwner = this
    val bicycleAdapterInterface: BicyclesAdapter.BicycleAdapterInterface = this

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

        viewModel = ViewModelProviders.of(this, factory).get(BicyclesViewModel::class.java)

        loadBicycles()

        recycle_view.layoutManager = LinearLayoutManager(context)
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

    fun addBicycle() {
        val bicycle = BicycleEntity(true, 12.5F, "red", "rower")

        viewModel.addBicycle(bicycle, object : BicycleLoadingProvider.AddCallBack {
            override fun onSuccess() {
                infoToast("SUCCESS")
            }

            override fun onFail(throwable: Throwable) {
                infoToast("ERROR")
            }
        })
    }

    fun loadBicycles() {
        viewModel.getBicycles(object : BicycleLoadingProvider.GetCallBack {

            override fun onSuccess(bicycleList: LiveData<List<BicycleEntity>>) {
                bicycleList.observe(lifecycleOwner, Observer { bicycles ->

                    recycle_view.adapter = BicyclesAdapter(bicycles)
                    (recycle_view.adapter as BicyclesAdapter).bindInterface(bicycleAdapterInterface)

                })
            }

            override fun onFail(throwable: Throwable) {
                infoToast("ERROR")
            }
        })

    }

    override fun onItemClick(bicycleEntity: BicycleEntity) {
        infoToast("ITEM CLICK")
    }

    override fun onRentClick(bicycleEntity: BicycleEntity) {
        infoToast("RENT CLICK")
    }

    fun infoToast(info: String) {
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show()
    }
}
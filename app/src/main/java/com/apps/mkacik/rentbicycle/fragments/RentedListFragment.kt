package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.*
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.activities.RentedBicycleActivity
import com.apps.mkacik.rentbicycle.adapters.RentedAdapter
import com.apps.mkacik.rentbicycle.data.BicycleLoadingProvider
import com.apps.mkacik.rentbicycle.data.database.entity.Rent
import com.apps.mkacik.rentbicycle.utilities.InjectorUtils
import com.apps.mkacik.rentbicycle.viewModels.RentedViewModel
import kotlinx.android.synthetic.main.list_layout.*

class RentedListFragment private constructor() : BaseListFragment(), RentedAdapter.RentedAdapterInterface {

    private lateinit var viewModel: RentedViewModel

    val lifecycleOwner: LifecycleOwner = this
    val rentedAdapterInterface: RentedAdapter.RentedAdapterInterface = this

    companion object {
        val TAG = this::class.java.name
        const val NAME = "Rented Bicycles"
        const val SPAN_COUNT = 2

        fun newInstance(): RentedListFragment {
            return RentedListFragment()
        }
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_layout, container, false)
        val factory = InjectorUtils.provideRentedViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(RentedViewModel::class.java)
        return view
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.rented_bicycle_menu, menu)
    }


    override fun hasOptionMenuEnabled(): Boolean = true


    override fun setTitle(): CharSequence? = NAME


    override fun loadData() {
        viewModel.getRentedBicycles(object : BicycleLoadingProvider.GetRentBicyclesCallBack {
            override fun onSuccess(bicycleList: LiveData<List<Rent>>) {
                bicycleList.observe(lifecycleOwner, Observer { bicycles ->

                    recycle_view.adapter = RentedAdapter(bicycles)
                    (recycle_view.adapter as RentedAdapter).bindInterface(rentedAdapterInterface)

                })
            }

            override fun onFail(throwable: Throwable) {
                infoToast("ERROR ${throwable.message}")
            }
        })
    }


    override fun getRecycleView(): RecyclerView = recycle_view


    override fun setRecycleLayoutManager(recycle: RecyclerView) {
        recycle.layoutManager = StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
    }

    override fun onItemClick(rent: Rent) {
        requireContext().startActivity(RentedBicycleActivity.newIntent(requireContext(), rent))
    }
}
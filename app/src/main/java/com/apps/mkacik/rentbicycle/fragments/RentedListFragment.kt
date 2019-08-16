package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.adapters.RentedAdapter
import com.apps.mkacik.rentbicycle.data.BicycleLoadingProvider
import com.apps.mkacik.rentbicycle.data.database.entity.RentEntity
import com.apps.mkacik.rentbicycle.utilities.InjectorUtils
import com.apps.mkacik.rentbicycle.viewModels.RentedViewModel
import kotlinx.android.synthetic.main.fragment_all_bicycle.*

class RentedListFragment : Fragment(), RentedAdapter.RentedAdapterInterface {

    lateinit var viewModel: RentedViewModel

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = InjectorUtils.provideRentedViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(RentedViewModel::class.java)

        recycle_view.layoutManager = StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
        loadBicycles()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my_bicycle, container, false)
        setHasOptionsMenu(true)
        activity!!.title = NAME
        return view
    }


    fun loadBicycles() {
        viewModel.getRentedBicycles(object : BicycleLoadingProvider.GetRentBicyclesCallBack {
            override fun onSuccess(bicycleList: LiveData<List<RentEntity>>) {
                bicycleList.observe(lifecycleOwner, Observer { bicycles ->

                    recycle_view.adapter = RentedAdapter(bicycles)
                    (recycle_view.adapter as RentedAdapter).bindInterface(rentedAdapterInterface)

                })
            }

            override fun onFail(throwable: Throwable) {

            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.rented_bicycle_menu, menu)
    }


    override fun onItemClick(rentEntity: RentEntity) {

    }
}
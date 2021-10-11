package com.example.androidview.features.CarListings

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.di.AppModule
import com.di.DaggerAppComp
import com.example.androidview.databinding.FragmentPage1Binding
import entities.CarMake
import entities.CarResponse
import entities.Categorie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [CarListing.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarListing : Fragment() {
    private lateinit var bindingMain: FragmentPage1Binding
    var carlist: MutableList<CarMake> = mutableListOf()
    lateinit var carListAdapter: CarListAdapter
    lateinit var ctgListAdapter: CategorieAdapterAlt

    // @Inject
    // lateinit var carListingViewModel :CarListingViewModel
    private val vm: CarListingViewModel2 by viewModels {
        DaggerAppComp
            .builder()
            .appModule(AppModule(requireContext()))
            .build()
            .viewModelsFactory2()
    }//navGraphViewModels(R.id.nav_file)

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //viewbinding

        bindingMain = FragmentPage1Binding.inflate(inflater)

        //carlist adapter init

        carListAdapter = CarListAdapter()

        ctgListAdapter = CategorieAdapterAlt()

        //** alternate - viewmodel / livedata

        CarListingViewModel.resultdata.observe(this@CarListing.viewLifecycleOwner) {
            bindingMain.apply {
                vis(it.size)
                carListAdapter.submitList(it)
            }
        }

        // val carListingViewModel = ViewModelProvider(requireActivity()).get(CarListingViewModel::class.java)

        vm.test.observe(this@CarListing.viewLifecycleOwner) {

        }

        // @ends

        //rxjava alternate

        CarListingViewModel.loader
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::handelloader)

        CarListingViewModel.bs
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { Log.e("Pageviewmodel-doonnext", "dooennext") }
            .doOnError { }
            .subscribe(::myhandler)

        //rxjava alternate @ends


        //binding to views

        bindingMain.apply {
            carlist.apply {
                layoutManager = GridLayoutManager(bindingMain.root.context, 4)
            }
            categories.apply {
                adapter = ctgListAdapter
                layoutManager =
                    LinearLayoutManager(
                        bindingMain.root.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
            }
        }

        val cs: MutableList<Categorie> = mutableListOf(
            Categorie(0, "ford"),
            Categorie(1, "daimler"),
            Categorie(2, "bmw"),
            Categorie(3, "classic"),
            Categorie(5, "roads"),
        )

        ctgListAdapter.submitList(cs)

        return bindingMain.root
    }

    fun handelloader(res: Boolean?) {
        when (res) {
            true -> bindingMain.progressBar.visibility = VISIBLE
            false -> bindingMain.progressBar.visibility = INVISIBLE
        }
    }

    fun myhandler(car: CarResponse?) {
        bindingMain.carlist.adapter = carListAdapter
        vis(carlist.size)
    }

    fun vis(i: Int) {
        if (i < 3) {
            bindingMain.logo.visibility = View.VISIBLE
        } else {
            bindingMain.logo.visibility = View.GONE
        }
    }

}


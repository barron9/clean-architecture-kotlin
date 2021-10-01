package com.example.androidview

import android.os.Bundle
import android.view.*
import android.view.View.GONE
import android.widget.TextView
import androidx.core.view.size
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidview.databinding.FragmentPage1Binding
import entities.CarMake
import entities.CarResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*


/**
 * A simple [Fragment] subclass.
 * Use the [page1.newInstance] factory method to
 * create an instance of this fragment.
 */
class page1 : Fragment() {
    private lateinit var bindingMain: FragmentPage1Binding
    var carlist: MutableList<CarMake> = mutableListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingMain = FragmentPage1Binding.inflate(inflater)
        PagestartViewModel.bs
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::myhandler)

        bindingMain.carlist.layoutManager = GridLayoutManager(bindingMain.root.context,4)
            //LinearLayoutManager(bindingMain.root.context, LinearLayoutManager.VERTICAL, false)
        return bindingMain.root
    }

    fun myhandler(car: CarResponse?) {
        //  System.out.println("car res " + car?.Results!!.toMutableList())
        carlist = car?.Results!!.toMutableList()
        bindingMain.carlist.adapter = null
        bindingMain.carlist.adapter = Adapter(carlist)
        vis(carlist.size)
    }

    fun vis(i:Int){
        if (i <3) {bindingMain.logo.visibility=View.VISIBLE}else{
            bindingMain.logo.visibility=View.GONE
        }
    }

}


class Adapter(val cList: MutableList<CarMake>) :
    RecyclerView.Adapter<com.example.androidview.Adapter.ModelViewHolder>() {

    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val countryName: TextView = view.findViewById(R.id.carmake)
        val capitalName: TextView = view.findViewById(R.id.carmodel)

        fun bindItems(item: CarMake) {
            countryName.text = item.Make_Name
            capitalName.text = item.Mfr_Name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_car, parent, false)
        return ModelViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cList.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindItems(cList.get(position))
    }
}

package com.example.androidview

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.*
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidview.databinding.FragmentPage1Binding
import entities.CarMake
import entities.CarResponse
import entities.Categorie
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

    @SuppressLint("CheckResult")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bindingMain = FragmentPage1Binding.inflate(inflater)
        PagestartViewModel.loader
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::handelloader)

        PagestartViewModel.bs
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext { Log.e("Pageviewmodel-doonnext", "dooennext") }
            .doOnError { }
            .subscribe(::myhandler)

        bindingMain.carlist.layoutManager = GridLayoutManager(bindingMain.root.context, 4)
        //LinearLayoutManager(bindingMain.root.context, LinearLayoutManager.VERTICAL, false)
        bindingMain.categories.layoutManager =
            LinearLayoutManager(bindingMain.root.context, LinearLayoutManager.HORIZONTAL, false)

         bindingMain.carlist.addOnScrollListener(myscrolllistener(binding = bindingMain))

        val cs: MutableList<Categorie> = mutableListOf(
            Categorie(0, "ford"),
            Categorie(1, "daimler"),
            Categorie(2, "bmw"),
            Categorie(3, "classic"),
            Categorie(5, "roads"),
        )
        bindingMain.categories.adapter = CategorieAdapter(cs, bindingMain.categories)
        return bindingMain.root
    }

    fun handelloader(res: Boolean?) {
        when (res) {
            true -> bindingMain.progressBar.visibility = VISIBLE
            false -> bindingMain.progressBar.visibility = INVISIBLE
        }
    }

    fun myhandler(car: CarResponse?) {
        //  System.out.println("car res " + car?.Results!!.toMutableList())
        carlist = car?.Results!!.toMutableList()
        bindingMain.carlist.adapter = null
        bindingMain.carlist.adapter = Adapter(carlist)
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

class myscrolllistener(private val binding: FragmentPage1Binding) : RecyclerView.OnScrollListener() {
    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
    }
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        Log.e("scrollxy", "dx:${dx} , dy:${dy}")
        binding.categories.layoutParams = binding.categories.layoutParams.apply {

            this.height = this.height - dy
        }

        /*   else -> binding.categories.layoutParams = binding.categories.layoutParams.apply {
               if(this.height<100)
                   this.height = this.height + dy
               else
                   this.height = 100

           }*/
    }
    //binding.categories.invalidate()
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


class CategorieAdapter(val cList: MutableList<Categorie>, val recycle: RecyclerView) :
    RecyclerView.Adapter<CategorieAdapter.ModelViewHolder>() {

    class ModelViewHolder(view: View, val RC: RecyclerView, val list: MutableList<Categorie>) :
        RecyclerView.ViewHolder(view) {
        val c_item: Button = view.findViewById(R.id.item)
        fun bindItems(item: Categorie) {
            c_item.text = item.c_name
            c_item.setOnClickListener {
                RC.smoothScrollToPosition(0)
                RC.smoothScrollToPosition(list.indexOf(item))
                Observable.create<Unit> {
                    println("Pageviewmodel-test-" + Thread.currentThread().name)
                    PagestartViewModel.call(item.c_name)!!
                }
                    .subscribeOn(Schedulers.single())?.subscribe()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_ctg, parent, false)
        return ModelViewHolder(view, recycle, cList)
    }

    override fun getItemCount(): Int {
        return cList.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        holder.bindItems(cList[position])
    }
}

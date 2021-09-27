package com.example.androidview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.androidview.databinding.FragmentPage3Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [page3.newInstance] factory method to
 * create an instance of this fragment.
 */
class page3 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bindingMain: FragmentPage3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingMain = FragmentPage3Binding.inflate(inflater)
        bindingMain.tv1.setOnClickListener { Navigation.findNavController(bindingMain.root).navigate(R.id.page1) }
        return bindingMain.root
    }

}
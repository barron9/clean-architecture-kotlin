package com.example.androidview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.androidview.databinding.FragmentPage1Binding
import com.example.androidview.databinding.FragmentPage2Binding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [page2.newInstance] factory method to
 * create an instance of this fragment.
 */
class page2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var bindingMain: FragmentPage2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingMain = FragmentPage2Binding.inflate(inflater)
        bindingMain.tv3.setOnClickListener { Navigation.findNavController(bindingMain.root).navigate(R.id.page3) }
        return bindingMain.root
    }

}
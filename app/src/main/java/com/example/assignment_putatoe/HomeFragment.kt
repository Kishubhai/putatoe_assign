package com.example.assignment_putatoe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager

class HomeFragment : Fragment() {

    private lateinit var viewPager:ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_home, container, false)

        viewPager = view.findViewById(R.id.viewPager)

        val item = mutableListOf<ItemImageSlider>()
        item.add(0, ItemImageSlider(R.drawable.img1s))
        item.add(1,ItemImageSlider(R.drawable.img2s))
        item.add(2,ItemImageSlider(R.drawable.img3s))
        item.add(3,ItemImageSlider(R.drawable.img4s))

        val viewPagerAdapter = AutoImageSliderAdapter(requireContext(),item)

        viewPager.adapter = viewPagerAdapter
        viewPagerAdapter.autoslide(viewPager)

        return view
    }

    companion object {
      @JvmStatic
        fun newInstance() =
            HomeFragment().apply {

            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listitems = Constants.getlistiData()

        val itemAdapter = adapter(listitems)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerhome)
        recyclerView.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        recyclerView.adapter =itemAdapter

        val recyclerView2 = view.findViewById<RecyclerView>(R.id.recyclerhome2)
        recyclerView2.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)

        recyclerView2.adapter =itemAdapter


    }
}
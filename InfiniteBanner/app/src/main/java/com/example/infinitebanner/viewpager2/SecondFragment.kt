package com.example.infinitebanner.viewpager2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.infinitebanner.R
import com.example.infinitebanner.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private var sampleList: MutableList<Sample> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getSampleData()

        binding.infiniteViewPager.apply {
            adapter = InfiniteRecyclerAdapter(sampleList)
            currentItem = 1
        }

        onInfinitePageChangeCallback(sampleList.size + 2)
    }

    private fun getSampleData() {
        sampleList.add(Sample(1, "#91C555"))
        sampleList.add(Sample(2, "#F48E37"))
        sampleList.add(Sample(3, "#FF7B7B"))
    }

    private fun onInfinitePageChangeCallback(listSize: Int) {
        binding.infiniteViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)

                if (state == ViewPager2.SCROLL_STATE_IDLE) {
                    when (binding.infiniteViewPager.currentItem) {
                        listSize - 1 -> binding.infiniteViewPager.setCurrentItem(1, false)
                        0 -> binding.infiniteViewPager.setCurrentItem(listSize - 2, false)
                    }
                }
            }
        })
    }
}

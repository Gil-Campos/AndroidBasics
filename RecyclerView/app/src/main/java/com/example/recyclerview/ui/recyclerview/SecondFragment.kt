package com.example.recyclerview.ui.recyclerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.R
import com.example.recyclerview.data.getFriendsList
import com.example.recyclerview.data.model.Friend
import com.example.recyclerview.databinding.FragmentSecondBinding
import com.example.recyclerview.ui.FirstFragment

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val friendsAdapter = FriendsListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()
        initListeners()
    }

    private fun initRecyclerView() {
        binding.textViewInfo.text = getString(
            R.string.placeholder_friends_list,
            arguments?.getString(FirstFragment.USER_DATA)
        )

        with(binding.recyclerViewFriends) {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            overScrollMode = View.OVER_SCROLL_NEVER
            setHasFixedSize(false)
            adapter = friendsAdapter
        }

        friendsAdapter.submitList(getFriendsList())
    }

    private fun initListeners() {
        friendsAdapter.setFriendClickListeners {
            Toast.makeText(requireContext(), "Clicked ${it.name}", Toast.LENGTH_SHORT).show()
        }
    }

}
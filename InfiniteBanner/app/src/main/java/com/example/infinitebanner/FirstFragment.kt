package com.example.infinitebanner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infinitebanner.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    private lateinit var userListAdapter: UserListAdapter
    private val userList = listOf(
        UserData("A", "1111 1111"),
        UserData("B", "2222 2222"),
        UserData("C", "44444 44444"),
        UserData("D", "3333 3333"),
        UserData("E", "5555 5555"),
        UserData("F", "6666 6666"),
        UserData("G", "7777 7777"),
        UserData("H", "8888 8888")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userListAdapter = UserListAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = userListAdapter
        }

        userListAdapter.submitList(userList)
    }
}
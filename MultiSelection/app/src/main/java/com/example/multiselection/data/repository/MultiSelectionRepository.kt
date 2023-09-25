package com.example.multiselection.data.repository

import com.example.multiselection.data.model.DummyModel

class MultiSelectionRepository(private val dataList: MutableList<DummyModel>) {
    fun getData() = dataList

    fun addData(data: DummyModel) = dataList.add(data)
}
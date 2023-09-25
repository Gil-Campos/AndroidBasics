package com.example.multiselection.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.multiselection.MultiSelectionReviewerApplication
import com.example.multiselection.data.repository.MultiSelectionRepository

class MainViewModel(private val repository: MultiSelectionRepository) : ViewModel() {

    fun getDataList() = repository.getData()

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                // Get the Application object from extras
                val application =
                    checkNotNull(extras[APPLICATION_KEY] as MultiSelectionReviewerApplication)
                return MainViewModel(application.multiSelectionRepository) as T
            }
        }
    }
}
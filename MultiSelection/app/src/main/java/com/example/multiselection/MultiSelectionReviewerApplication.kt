package com.example.multiselection

import android.app.Application
import com.example.multiselection.data.repository.MultiSelectionRepository
import com.example.multiselection.data.repository.data

class MultiSelectionReviewerApplication : Application() {

    val multiSelectionRepository: MultiSelectionRepository by lazy {
        MultiSelectionRepository(data)
    }
}
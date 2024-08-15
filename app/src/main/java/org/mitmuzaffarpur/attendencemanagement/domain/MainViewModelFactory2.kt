package org.mitmuzaffarpur.attendencemanagement.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory2(
    private val repository: Repository2
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel2(repository) as T
    }
}
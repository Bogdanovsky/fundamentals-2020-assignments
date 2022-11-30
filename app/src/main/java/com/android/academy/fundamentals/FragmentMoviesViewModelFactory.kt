package com.android.academy.fundamentals

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FragmentMoviesViewModelFactory(
    ) : ViewModelProvider.Factory {

    override fun <T: ViewModel> create(modelClass: Class<T>): T = when (modelClass) {
        FragmentMoviesViewModel::class.java -> FragmentMoviesViewModel()
        else -> throw IllegalArgumentException("$modelClass is not registered ViewModel")
    } as T
}
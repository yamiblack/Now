package com.study.android.now

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val mIsLoading = MutableStateFlow(true)
    val isLoading = mIsLoading.asStateFlow()

    init {
        viewModelScope.launch {
            delay(1500)
            mIsLoading.value = false
        }
    }
}
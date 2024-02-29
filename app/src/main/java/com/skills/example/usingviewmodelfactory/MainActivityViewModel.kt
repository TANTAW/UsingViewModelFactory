package com.skills.example.usingviewmodelfactory

import androidx.lifecycle.ViewModel

class MainActivityViewModel(private val initValue: Int): ViewModel() {

    private var result: Int = 0
    init {
        result += initValue
    }

    fun add(num: Int): Int {
        result += num
        return result
    }

}
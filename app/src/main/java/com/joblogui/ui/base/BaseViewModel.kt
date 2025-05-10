package com.joblogui.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<in Event, State> : ViewModel() {

    protected val _state: MutableLiveData<ScreenState<State>> = MutableLiveData()

    val state: MutableLiveData<ScreenState<State>>
        get() = _state

    fun dispatch(event: Event) {
        handleEvent(event)
    }

    fun postState(state: State) {
        _state.postValue(ScreenState.Render(state))
    }

    fun setState(state: State) {
        _state.value = ScreenState.Render(state)
    }

    protected abstract fun handleEvent(publishedEvent: Event)
}

package com.joblogui.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.joblogui.repository.impl.LoginRepository
import com.joblogui.requestmodel.auth.AuthRequest
import com.joblogui.responsemodel.ResponseWrapper
import com.joblogui.ui.base.BaseViewModel
import com.joblogui.ui.base.ScreenState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginRepository: LoginRepository,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.IO
) : BaseViewModel<LoginEvent, LoginState>() {

    public override fun handleEvent(publishedEvent: LoginEvent) {
        when (publishedEvent) {
            is LoginEvent.OnLogin -> {
                // Handle login event
                val authRequest = AuthRequest(
                    email = publishedEvent.email,
                    password = publishedEvent.password
                )
                loginUser(authRequest)
            }
        }
    }

    private fun loginUser(authRequest: AuthRequest) {
        // Call the login repository to perform the login operation
        _state.value = ScreenState.Loading
        // Use the coroutine dispatcher to perform the network call
        viewModelScope.launch(coroutineDispatcher) {
            when (val response = loginRepository.loginUser(authRequest)) {
                is ResponseWrapper.Success -> {
                    response.data?.accessToken?.let {
                        LoginState.LoginSuccess(it)
                    }
                }
                is ResponseWrapper.Error -> {
                    response.error?.let {
                        postState(LoginState.LoginFailure(it))
                    }
                }
            }
        }
    }

    class LoginViewModelFactory(
        private val loginRepository: LoginRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                return LoginViewModel(loginRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}

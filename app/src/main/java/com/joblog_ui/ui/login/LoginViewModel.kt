package com.joblog_ui.ui.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.joblog_ui.repository.impl.LoginRepository
import com.joblog_ui.ui.base.BaseViewModel

class LoginViewModel: BaseViewModel<LoginEvent, LoginState>() {

    public override fun handleEvent(publishedEvent: LoginEvent) {
        when (publishedEvent){
            is LoginEvent.OnLogin -> {
                // Handle login event
                val email = publishedEvent.email
                val password = publishedEvent.password
                // loginRepository.login(email, password)
            }
        }
    }


    class LoginViewModelFactory(
        private val loginRepository: LoginRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
                return LoginViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}
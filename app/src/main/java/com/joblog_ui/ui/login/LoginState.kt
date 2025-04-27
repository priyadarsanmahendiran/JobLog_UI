package com.joblog_ui.ui.login

sealed class LoginState {
    object LoginSuccess : LoginState()
    class LoginFailure(val error: String) : LoginState()
}
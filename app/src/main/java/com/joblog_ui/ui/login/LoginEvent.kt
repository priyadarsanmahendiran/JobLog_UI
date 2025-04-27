package com.joblog_ui.ui.login

sealed class LoginEvent {

    class OnLogin(val email: String, val password: String) : LoginEvent()

}
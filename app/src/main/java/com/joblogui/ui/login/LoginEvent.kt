package com.joblogui.ui.login

sealed class LoginEvent {

    class OnLogin(val email: String, val password: String) : LoginEvent()
}

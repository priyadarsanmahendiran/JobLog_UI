package com.joblogui.ui.login

sealed class LoginState {
    class LoginSuccess(val token: String) : LoginState()
    class LoginFailure(val error: String) : LoginState()
}

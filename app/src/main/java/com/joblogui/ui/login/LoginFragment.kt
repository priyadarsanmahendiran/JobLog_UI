package com.joblogui.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.joblogui.R
import com.joblogui.databinding.FragmentLoginBinding
import com.joblogui.provider.TokenManager
import com.joblogui.repository.impl.LoginRepository
import com.joblogui.ui.base.BaseFragment
import com.joblogui.ui.base.ScreenState

class LoginFragment : BaseFragment(R.layout.fragment_login) {

    private var _binding: FragmentLoginBinding? = null
    private lateinit var loginRepository: LoginRepository

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val loginViewModel: LoginViewModel by viewModels {
        LoginViewModel.LoginViewModelFactory(loginRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loginRepository = LoginRepository()
        loginViewModel.state.observe(::getLifecycle, ::updateUI)

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString()
            val password = binding.etPassword.text.toString()
            loginViewModel.handleEvent(LoginEvent.OnLogin(email, password))
        }
    }

    private fun updateUI(state: ScreenState<LoginState>?) {
        when (state) {
            is ScreenState.Loading -> {
                showLoading()
            }
            is ScreenState.Render -> {
                processLoginState(state.renderState)
            }

            null -> {}
        }
    }

    private fun processLoginState(state: LoginState) {
        when (state) {
            is LoginState.LoginSuccess -> {
                context?.let {
                    TokenManager.saveToken(it, state.token)
                }
            }
            is LoginState.LoginFailure -> {
                showSnackbar("Login Failed!")
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

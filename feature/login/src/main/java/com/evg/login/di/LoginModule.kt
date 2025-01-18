package com.evg.login.di

import com.evg.login.data.repository.LoginRepositoryImpl
import com.evg.login.domain.repository.LoginRepository
import com.evg.login.domain.usecase.LoginUseCase
import com.evg.login.domain.usecase.LoginUseCases
import com.evg.login.domain.usecase.SaveUserTokenUseCase
import com.evg.login.presentation.mvi.LoginViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val loginModule = module {
    single<LoginRepository> { LoginRepositoryImpl(apiRepository = get()) }
    viewModel { LoginViewModel(loginUseCases = get()) }
    single { LoginUseCases(
        loginUseCase = get(),
        saveUserTokenUseCase = get(),
    ) }
    single { LoginUseCase(loginRepository = get()) }
    single { SaveUserTokenUseCase(sharedPrefsRepository = get()) }
}
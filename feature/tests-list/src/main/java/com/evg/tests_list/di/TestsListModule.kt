package com.evg.tests_list.di

import com.evg.tests_list.data.repository.TestsListRepositoryImpl
import com.evg.tests_list.domain.repository.TestsListRepository
import com.evg.tests_list.domain.usecase.GetAllTestsUseCase
import com.evg.tests_list.domain.usecase.GetAllTestsUseCaseUseCase
import com.evg.tests_list.domain.usecase.TestsListUseCases
import com.evg.tests_list.presentation.mvi.TestsListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val testsListModule = module {
    single<TestsListRepository> {
        TestsListRepositoryImpl(
            apiRepository = get(),
            testPageSourceRemote = get(),
        )
    }
    viewModel { TestsListViewModel(testsListUseCases = get()) }
    factory {
        TestsListUseCases(
            getAllTestsUseCase = get(),
            getAllTestsUseCaseUseCase = get()
        )
    }
    factory { GetAllTestsUseCase(testsListRepository = get()) }
    factory { GetAllTestsUseCaseUseCase(testsListRepository = get()) }
}
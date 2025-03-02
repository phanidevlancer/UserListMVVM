package com.phani.feature.userlist.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.phani.core.common.utils.ResultWrapper
import com.phani.feature.userlist.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserListViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<UserListState> = MutableStateFlow(UserListState())
    val state: StateFlow<UserListState> = _state.asStateFlow()

    init {
        loadUsers()
    }

    private fun loadUsers() {
        viewModelScope.launch {
            getUsersUseCase().collectLatest { result ->

                when (result) {
                    is ResultWrapper.Loading -> {
                        _state.update {
                            it.copy(
                                isLoading = true,
                                error = null
                            )
                        }
                    }

                    is ResultWrapper.Success -> {
                        _state.update {
                            it.copy(
                                users = result.data,
                                isLoading = false,
                                error = null
                            )
                        }
                    }

                    is ResultWrapper.Error -> {
                        _state.update {
                            it.copy(
                                isLoading = false,
                                error = result.exception.localizedMessage ?: "Unknown error"
                            )
                        }
                    }
                }

            }
        }

    }

    fun retry() {
        loadUsers()
    }
}
package com.phani.feature.userlist.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.phani.common.design_system.components.LoadingIndicator
import com.phani.common.design_system.components.UserListItem
import com.phani.common.design_system.components.UserListItemData
import com.phani.feature.userlist.domain.model.User


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(
    onUserClick: (Int) -> Unit,
    viewModel: UserListViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("User List") }
            )
        }
    ) { paddingValues ->
        when {
            state.isLoading -> {
                LoadingIndicator(
                    modifier = Modifier.padding(paddingValues)
                )
            }

            state.error != null -> {
                ErrorContent(
                    errorMessage = state.error!!,
                    onRetry = { viewModel.retry() },
                    modifier = Modifier.padding(paddingValues)
                )
            }

            state.users.isEmpty() -> {
                EmptyContent(
                    modifier = Modifier.padding(paddingValues)
                )
            }

            else -> {
                UserList(
                    users = state.users,
                    onUserClick = onUserClick,
                    contentPadding = paddingValues
                )
            }
        }
    }
}

@Composable
private fun UserList(
    users: List<User>,
    onUserClick: (Int) -> Unit,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = contentPadding
    ) {
        items(
            items = users,
            key = { it.id }
        ) { user ->
            UserListItem(
                user = UserListItemData(
                    id = user.id,
                    firstName = user.firstName,
                    lastName = user.lastName,
                    username = user.username,
                    email = user.email,
                    imageUrl = user.imageUrl,
                    role = user.role
                ),
                onUserClick = onUserClick
            )
        }
    }
}

@Composable
private fun EmptyContent(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "No users found",
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun ErrorContent(
    errorMessage: String,
    onRetry: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = errorMessage,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )
            Button(
                onClick = onRetry
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Retry"
                )
                Text(
                    text = "Retry",
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}
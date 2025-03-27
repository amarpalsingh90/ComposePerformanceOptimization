@file:OptIn(ExperimentalMaterial3Api::class)

package com.jio_hotstar.compose_performance.rememberusage

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun DerivedStateVsRemember(){
    val state = rememberLazyListState()

    var isEnabled = remember {
        mutableStateOf(true)
    }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        floatingActionButton = {
            ScrollToTopButton(
                state = state,
                isEnabled = isEnabled.value
            )
        }
    ) { padding ->
        LazyColumn(
            state = state,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(100) {
                Text(
                    text = "Item $it",
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable {
                            isEnabled.value = false
                        }
                )
            }
        }
    }
}


@Composable
fun ScrollToTopButton(
    state: LazyListState,
    isEnabled: Boolean
) {
    val scope = rememberCoroutineScope()

    val showScrollToTopButton by remember(isEnabled) {
        derivedStateOf {
            state.firstVisibleItemIndex >= 5 && isEnabled
        }
    }
/*
    val showScrollToTopButton = remember(state.firstVisibleItemIndex) {
        state.firstVisibleItemIndex >= 5
    }*/

    if(showScrollToTopButton) {
        FloatingActionButton(onClick = {
            scope.launch {
                state.animateScrollToItem(0)
            }
        }) {
            Icon(
                imageVector = Icons.Default.KeyboardArrowUp,
                contentDescription = null
            )
        }
    }
}
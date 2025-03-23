package com.jio_hotstar.compose_performance.stateReads.inlinedComposables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.jio_hotstar.compose_performance.common.ColumnWrapper


@Composable
fun StateReadsInlinedComposablesScreen() {
    var outerCount by remember { mutableStateOf(0) }

    //use WrappedColumn to fix state reads from too high scope
    Column {
        Text(text = "count: $outerCount")
        Button(onClick = { outerCount++ }) {
            Text(text = "count++")
        }
    }
}

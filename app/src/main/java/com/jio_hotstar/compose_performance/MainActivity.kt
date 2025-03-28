package com.jio_hotstar.compose_performance

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.fragment.app.FragmentActivity
import com.jio_hotstar.compose_performance.rememberusage.DerivedStateVsRemember
import com.jio_hotstar.compose_performance.stability.UnstableClassScreen
import com.jio_hotstar.compose_performance.stability.UnstableLambdaScreen
import com.jio_hotstar.compose_performance.stability.UnstableListScreen
import com.jio_hotstar.compose_performance.stateReads.ModifierLambdasScreen
import com.jio_hotstar.compose_performance.stateReads.inlinedComposables.StateReadsInlinedComposablesScreen
import com.jio_hotstar.compose_performance.stateReads.inlinedComposables.StateReadsInlinedComposablesSolution2Screen
import com.jio_hotstar.compose_performance.stateReads.stateReads.StateReadsAnnotationOptimizedScreen
import com.jio_hotstar.compose_performance.stateReads.stateReads.StateReadsLambdasOptimizedScreen
import com.jio_hotstar.compose_performance.stateReads.stateReads.StateReadsUnoptimizedScreen
import com.jio_hotstar.compose_performance.ui.theme.ComposeperformanceTheme

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeperformanceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                   //UnstableClassScreen()
                    //UnstableLambdaScreen()
                    //UnstableListScreen()

                   //StateReadsInlinedComposablesScreen()
                    //StateReadsInlinedComposablesSolution2Screen()

                    //StateReadsUnoptimizedScreen()
                    //StateReadsLambdasOptimizedScreen()
                  //StateReadsAnnotationOptimizedScreen()
                // StateReadsLowerStateReadsOptimizedScreen()
                    //ModifierLambdasScreen()
                    DerivedStateVsRemember()
                }
            }
        }
    }
}

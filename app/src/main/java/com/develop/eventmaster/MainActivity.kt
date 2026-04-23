package com.develop.eventmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.develop.eventmaster.ui.navigation.AppNavigation
import com.develop.eventmaster.ui.theme.EventMasterTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            EventMasterTheme {

                AppNavigation()
            }
        }
    }
}
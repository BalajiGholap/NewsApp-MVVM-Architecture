package com.bala.newsapp_mvvm_architecture.appui
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.bala.newsapp_mvvm_architecture.R

@Composable
fun FullScreenLoader(isLoading: Boolean) {
    //val isLoading by FullScreenLoadingManager.isLoading
    if (isLoading){
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(
                modifier = Modifier.width(64.dp),
                //color = MaterialTheme.colorScheme.secondary,
                color = colorResource(R.color.baby_blue),
                trackColor = colorResource(R.color.dark_navi_blue),
                //trackColor = MaterialTheme.colorScheme.surfaceVariant,
            )
        }

    }
}
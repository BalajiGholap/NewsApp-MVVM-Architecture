package com.bala.newsapp_mvvm_architecture.appui

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bala.newsapp_mvvm_architecture.R

@Composable
fun LanguageList(languagesList: List<String>) {
    var languages  = languagesList

    Column {
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.dark_navi_blue))
            .padding(20.dp),
            text = "Languages",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )
        LazyColumn(content = {
            itemsIndexed(languages, itemContent = {index, item ->
                LanguageListItem(item)
            })
        })
    }
}

@Composable
fun LanguageListItem(item: String) {
    var context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()
        .padding(20.dp)
        .clip(RoundedCornerShape(10.dp))
        .clickable {
            Toast.makeText(context,"Work in progress...",Toast.LENGTH_LONG).show()

        }) {
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.dark_purple)),
            text = item.toString(),
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        )
    }
}
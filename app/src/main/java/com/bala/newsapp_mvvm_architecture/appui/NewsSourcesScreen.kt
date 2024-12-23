package com.bala.newsapp_mvvm_architecture.appui

import android.content.Intent
import android.net.Uri
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
import com.bala.newsapp_mvvm_architecture.model.sources.Source

@Composable
fun NewsSources(result: List<Source>?) {
    var headLines  = result!!
    Column {
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.dark_navi_blue))
            .padding(30.dp),
            text = "News Sources",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )
        LazyColumn(content = {
            itemsIndexed(headLines, itemContent = {index, item ->
                SourceItem(item)
            })
        })
    }
}

@Composable
fun SourceItem(item: Source) {
    var context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()
        .padding(20.dp)
        .clip(RoundedCornerShape(10.dp))
        .clickable {
            // Toast.makeText(context,"${item.title}",Toast.LENGTH_LONG).show()
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
            context.startActivity(browserIntent)
        }) {
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.dark_purple)),
            text = "${item.name}",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        )
    }
}
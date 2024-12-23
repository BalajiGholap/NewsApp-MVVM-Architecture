package com.bala.newsapp_mvvm_architecture.appui

import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.bala.newsapp_mvvm_architecture.R
import com.bala.newsapp_mvvm_architecture.model.topheadlines.Article

@Composable
fun TopHeadlines(result: List<Article>?) {
    var headLines  = result!!
    Column {
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.dark_navi_blue))
            .padding(20.dp),
            text = "Top Headlines",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )
        LazyColumn(content = {
            itemsIndexed(headLines, itemContent = {index, item ->
                Log.i("ToppHeadlinesTitle",item.title)
                HeadlinesItem(item)
            })
        })
    }
}

@Composable
fun HeadlinesItem(item: Article) {
    var context = LocalContext.current
    Column(modifier = Modifier.fillMaxWidth()
        .padding(5.dp,10.dp,5.dp,20.dp)
        .clickable {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(item.url))
            context.startActivity(browserIntent)
        }) {
        AsyncImage(
            model = item.urlToImage,
            contentDescription = "NewsImage",
            modifier = Modifier.fillMaxWidth()
                .fillMaxHeight()
                .padding(5.dp)
                .clip(RoundedCornerShape(15.dp))
        )
        Text(modifier = Modifier.fillMaxWidth().padding(1.dp),
            text = "${item.title}",
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            color = Color.Black,
            fontSize = 22.sp,
            textAlign = TextAlign.Start
        )
        Text(modifier = Modifier.fillMaxWidth().padding(1.dp),
            text = "${item.description}",
            maxLines = 2,
            color = Color.Black,
            fontSize = 20.sp,
            textAlign = TextAlign.Start
        )
        Text(modifier = Modifier.fillMaxWidth().padding(1.dp),
            text = "Source: ${item.source.name}",
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Bold,
            maxLines = 3,
            color = Color.Black,
            fontSize = 18.sp,
            textAlign = TextAlign.Start
        )
    }
}

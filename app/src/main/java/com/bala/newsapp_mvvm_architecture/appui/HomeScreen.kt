package com.bala.newsapp_mvvm_architecture.appui

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.bala.newsapp_mvvm_architecture.CountryListMainActivity
import com.bala.newsapp_mvvm_architecture.LanguagesActivity
import com.bala.newsapp_mvvm_architecture.NewsHeadlinesActivity
import com.bala.newsapp_mvvm_architecture.NewsSourcesActivity
import com.bala.newsapp_mvvm_architecture.R

@Composable
fun MenuList() {
    var context = LocalContext.current
    Column {
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.dark_navi_blue))
            .padding(25.dp),
            text = "Global News",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 50.sp,
            textAlign = TextAlign.Center
        )
    }
    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth().padding(10.dp,150.dp,10.dp,150.dp),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,) {
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.navi_blue))
            .clickable {
                Intent(context,NewsHeadlinesActivity::class.java).also {
                    context.startActivity(it)
                }
            },
            text = "Top Headlines",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        )
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.navi_blue))
            .clickable {
                Intent(context,NewsSourcesActivity::class.java).also {
                    context.startActivity(it)
                }
            },
            text = "News Source",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        )
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.navi_blue))
            .clickable {
                Intent(context,CountryListMainActivity::class.java).also {
                    context.startActivity(it)
                }
            },
            text = "Countries",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        )
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.navi_blue))
            .clickable {
                Intent(context,LanguagesActivity::class.java).also {
                    context.startActivity(it)
                }
            },
            text = "Languages",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        )
        Text(modifier = Modifier.fillMaxWidth()
            .background(colorResource(R.color.navi_blue))
            .clickable {
                Toast.makeText(context,"Search",Toast.LENGTH_LONG).show()
            },
            text = "Search",
            color = Color.White,
            fontSize = 22.sp,
            lineHeight = 80.sp,
            textAlign = TextAlign.Center
        )

    }
}

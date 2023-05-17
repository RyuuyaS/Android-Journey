package com.example.ehcproject.ui.navigation.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ehcproject.R
import com.example.ehcproject.ui.navigation.AppViewModel
import com.example.ehcproject.ui.theme.EHCProjectTheme

@Composable
fun News(
    viewModel: AppViewModel = viewModel()
) {
    Surface(
        shadowElevation = 3.dp,
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(Color.Gray)
        ) {
            Image(
                painter = painterResource(id = R.drawable.git),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .padding(start = 15.dp, top = 20.dp, end = 15.dp, bottom = 10.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 25.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = "\uD83D\uDC14\uD83D\uDC23 Git & Github Noob \uD83D\uDC23\uD83D\uDC14",
                        fontSize = 24.sp
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.baseline_bookmark_24),
                        contentDescription = null,
                    )
                }
                Text(
                    text = "11 April 2023",
                    fontSize = 10.sp,
                    modifier = Modifier.padding(5.dp)
                )
                Text(
                    text = "Sau thời gian đi TeamBuilding để giải tỏa căng thẳng cũng như làm quen, thân thiết với nhau hơn của kỳ Spring 2023 thì tới đây chúng ta sẽ giới thiệu tiếp về Git và Github. Với sự góp mặt của 2 chiến thần, thủy tổ, trùm web Tuấn Giang, Tú Nguyễn thì hy vọng các bạn sẽ tham gia đầy đủ",
                    fontSize = 24.sp
                )
            }
        }
    }
}

@Composable
fun ListOfSrollingNews() {
   LazyColumn(){
       items(count = 3){
          News()
       }
   }
}

@Preview(showBackground = true)
@Composable
fun ListOfScrollingNewsPreview() {
    EHCProjectTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ListOfSrollingNews()
        }
    }
}


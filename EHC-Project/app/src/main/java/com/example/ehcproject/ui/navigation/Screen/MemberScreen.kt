package com.example.ehcproject.ui.navigation.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ehcproject.data.DataSource
import com.example.ehcproject.model.Member

@Composable
fun Member(
    member: Member,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = member.image),
            contentDescription = null,
            modifier = Modifier
                .size(80.dp)
                .clip(shape = CircleShape)
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(
                text = stringResource(id = member.name),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Text(
                text = stringResource(id = member.quote)
            )
        }
    }
}

@Composable
fun ListOfMember() {
    LazyColumn() {
        itemsIndexed(DataSource.memberData) { _, member ->
            Member(member = member, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListOfMemberPreview() {
    ListOfMember()
}
package com.example.ehcproject.data

import com.example.ehcproject.R
import com.example.ehcproject.model.Member
import com.example.ehcproject.model.News

object DataSource {
    val newsData = listOf<News>(

    )

    val memberData = listOf<Member>(
        Member(
            name = R.string.karim_name,
            quote = R.string.karim_quote,
            image = R.drawable.karim
        ),
        Member(
            name = R.string.ducgt_name,
            quote = R.string.ducgt_quote,
            image = R.drawable.ducgt
        ),
        Member(
            name = R.string.antoine_name,
            quote = R.string.antoine_quote,
            image = R.drawable.antoine
        ),
    )
}
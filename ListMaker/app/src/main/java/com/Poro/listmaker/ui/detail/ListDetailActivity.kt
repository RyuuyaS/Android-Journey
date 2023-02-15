package com.Poro.listmaker.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import com.Poro.listmaker.MainActivity
import com.Poro.listmaker.R
import com.Poro.listmaker.databinding.ActivityListDetailBinding
import com.Poro.listmaker.databinding.ListDetailFragmentBinding
import com.Poro.listmaker.models.TaskList
import com.Poro.listmaker.ui.detail.ui.detail.ListDetailFragment

class ListDetailActivity : AppCompatActivity() {

    lateinit var list: TaskList
    lateinit var binding: ActivityListDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.addTaskButton.setOnClickListener {
            showCreateTaskDialog()
        }
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)!!
        title = list.name
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListDetailFragment.newInstance())
                .commitNow()
        }
    }


}
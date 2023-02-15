package com.Poro.listmaker.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView.OnChildClickListener
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.Poro.listmaker.R
import com.Poro.listmaker.databinding.FragmentMainBinding
import com.Poro.listmaker.models.TaskList
import org.intellij.lang.annotations.JdkConstants.ListSelectionMode

interface MainFragmentInteractionListener {
    fun listItemTapped(list: TaskList)
}

class MainFragment(val clickListener: MainFragmentInteractionListener) : Fragment(),
    ListSelectionRecycleViewAdapter.ListSelectionRecyclerViewClickListener {

    private lateinit var binding: FragmentMainBinding

    companion object {
        fun newInstance(clickListener: MainFragmentInteractionListener) =
            MainFragment(clickListener)
    }

    private lateinit var viewModel: MainViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            requireActivity(),
            MainViewModelFactory(PreferenceManager.getDefaultSharedPreferences(requireActivity()))
        ).get(MainViewModel::class.java)
        val recyclerViewAdapter = ListSelectionRecycleViewAdapter(viewModel.lists, this)
        binding.listsRecycleview.adapter = recyclerViewAdapter
        viewModel.onListAdded = {
            recyclerViewAdapter.listUpdated()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        Log.d("CHECK", "$inflater")
        binding.listsRecycleview.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }

    override fun listItemClicked(list: TaskList) {
        clickListener.listItemTapped(list)
    }

}
package com.geeks.noteapp.ui.fragments.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.geeks.noteapp.R
import com.geeks.noteapp.data.NoteModel
import com.geeks.noteapp.databinding.FragmentNoteBinding
import com.geeks.noteapp.extensions.getBackStackData
import com.geeks.noteapp.ui.adapter.NoteAdapter



class NoteFragment : Fragment() {

    private lateinit var binding: FragmentNoteBinding
    private val noteAdapter = NoteAdapter()
    private val list: ArrayList<NoteModel> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initalize()
        setupListener()
        getData()
    }

    private fun initalize() {
        binding.noteRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = noteAdapter
        }
    }

    private fun setupListener() {
        binding.addBtn.setOnClickListener {
            findNavController().navigate(R.id.action_noteFragment_to_noteDetailFragment)
        }
    }

    /*private fun setupListener() = with(binding){
        val preferences = PreferenceHelper()
        preferences.unit(requireContext())
        saveBtn.setOnClickListener{
            val et = edText.text.toString()
            preferences.text = et
            saveTxt.text = et
        }
        saveTxt.text = preferences.text*/

    private fun getData() {
        getBackStackData<String>("key"){ data->
            val noteModel = NoteModel(data)
            list.add(noteModel)
            noteAdapter.submitList(list)
        }
    }


}
package com.study.android.now.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.study.android.now.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private lateinit var notesViewModel: NotesViewModel
    private var mbinding: FragmentNotesBinding? = null
    private val binding get() = mbinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notesViewModel =
            ViewModelProvider(this)[NotesViewModel::class.java]
        mbinding = FragmentNotesBinding.inflate(inflater, container, false)

        notesViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mbinding = null
    }
}
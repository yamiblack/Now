package com.study.android.now.notes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.study.android.now.databinding.FragmentNotesBinding

class NotesFragment : Fragment() {

    private val notesViewModel: NotesViewModel by activityViewModels()
    private var mBinding: FragmentNotesBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentNotesBinding.inflate(inflater, container, false)

        notesViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}
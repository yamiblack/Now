package com.study.android.now.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.study.android.now.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private val profileViewModel: ProfileViewModel by activityViewModels()
    private var mBinding: FragmentProfileBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentProfileBinding.inflate(inflater, container, false)

        profileViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}
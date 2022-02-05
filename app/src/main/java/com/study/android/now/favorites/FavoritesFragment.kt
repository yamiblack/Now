package com.study.android.now.favorites

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.study.android.now.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private val favoritesViewModel: FavoritesViewModel by activityViewModels()
    private var mBinding: FragmentFavoritesBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentFavoritesBinding.inflate(inflater, container, false)

        favoritesViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textView.text = it
        })
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }
}
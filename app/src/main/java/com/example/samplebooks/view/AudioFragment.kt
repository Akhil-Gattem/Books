package com.example.samplebooks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplebooks.common.ViewModelFactory
import com.example.samplebooks.databinding.FragmentAudioBinding
import com.example.samplebooks.repository.DataRepository
import com.example.samplebooks.viewmodel.DataViewModel

class AudioFragment : Fragment() {

    private var _binding: FragmentAudioBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DataViewModel
    private lateinit var adapter: AudioRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentAudioBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(requireActivity(), ViewModelFactory(DataRepository()))[DataViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.audioDataRv.layoutManager = LinearLayoutManager(requireActivity())
        viewModel.fetchAudioData.observe(viewLifecycleOwner) {
            adapter = AudioRecyclerViewAdapter(it.data)
            binding.audioDataRv.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
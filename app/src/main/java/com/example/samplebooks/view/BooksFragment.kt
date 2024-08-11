package com.example.samplebooks.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplebooks.common.ViewModelFactory
import com.example.samplebooks.databinding.FragmentBooksBinding
import com.example.samplebooks.repository.DataRepository
import com.example.samplebooks.viewmodel.DataViewModel

class BooksFragment : Fragment() {

    private var _binding: FragmentBooksBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: DataViewModel
    private lateinit var adapter: BooksRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBooksBinding.inflate(inflater, container, false)
        viewModel = ViewModelProviders.of(requireActivity(), ViewModelFactory(DataRepository()))[DataViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.booksDataRv.layoutManager = LinearLayoutManager(requireActivity())
        viewModel.fetchBookData.observe(viewLifecycleOwner) {
            adapter = BooksRecyclerViewAdapter(it.data)
            binding.booksDataRv.adapter = adapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
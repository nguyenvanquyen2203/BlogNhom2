package com.example.blognhom2.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.blognhom2.databinding.FragmentPostContentBinding
import com.example.blognhom2.model.PostInfo


class PostContentFragment : Fragment() {

    lateinit var post : PostInfo;
    private var _binding: FragmentPostContentBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPostContentBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        SetDataForPostContent()
        val view = binding.root
        return view
    }

    fun setData(post: PostInfo) {
        this.post = post
    }

    fun SetDataForPostContent(){
        binding.postTitle.text = "      "+ post.title
        binding.postContent.text =  "      "+ post.content
        binding.postUser.text = post.user
        binding.postCategories.text = post.category
        binding.postTime.text = post.time
        Glide.with(requireContext())
            .load(post.img)
            .into(binding.postImage)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
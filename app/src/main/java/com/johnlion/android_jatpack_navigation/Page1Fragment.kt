package com.johnlion.android_jatpack_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.navOptions
import kotlinx.android.synthetic.main.fragment_page_1.*

class Page1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page_1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val option = navOptions {
            anim {
                enter = R.anim.slide_in_right
                exit = R.anim.slide_out_left
                popEnter = R.anim.slide_in_left
                popExit = R.anim.slide_out_right
            }
        }

        btn_page1.setOnClickListener {
            val action = Page1FragmentDirections.actionPage1ToPage2(1,"hello",true)
            Navigation.findNavController(it).navigate(action, option)
        }

        btn_bundle.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("key", "Page1传递过来的bundle")
            Navigation.findNavController(it).navigate(R.id.action_page_1_to_page_2, bundle,option)
        }
    }
}
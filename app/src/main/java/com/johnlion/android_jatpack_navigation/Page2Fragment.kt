package com.johnlion.android_jatpack_navigation


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_page_2.*

class Page2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page_2, container, false)
    }


    val args: Page2FragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("data", "integer:" + args.myInteger)
        Log.d("data", "string:" + args.myString)
        Log.d("data", "boolean:" + args.myBoolean)

        tv_bundle.text = arguments?.getString("key") ?: ""

        btn_page2_1.setOnClickListener {
            Navigation.findNavController(it).navigateUp()
        }
        btn_page2_2.setOnClickListener {
            //            val navOption = NavOptions.Builder()
//                    //清栈
//                .setLaunchSingleTop(true)
//                .setPopUpTo(R.id.mobile_navigation, true)
//                .build()
            Navigation.findNavController(it).navigate(R.id.action_page_2_to_page_3)
        }
    }
}
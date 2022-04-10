package com.example.materialdesignapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.materialdesignapp.databinding.FragmentFirstBinding
import io.github.g00fy2.quickie.QRResult
import io.github.g00fy2.quickie.ScanQRCode

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private val scanQrCode = registerForActivityResult(ScanQRCode(), ::handleResult)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)


        binding.btn.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView,
                    SecondFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }

        binding.fabAddProduct.setOnClickListener {
            scanQrCode.launch(null)
        }

        return binding.root
    }

    private fun handleResult(result: QRResult) {
        Log.d("loger",(result as QRResult.QRSuccess).content.rawValue)
    }


}
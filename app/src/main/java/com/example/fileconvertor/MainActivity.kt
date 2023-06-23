package com.example.fileconvertor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.converterjpg.MainPresenter
import com.example.converterjpg.MainView
import com.example.fileconvertor.databinding.ActivityMainBinding
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private val presenter by moxyPresenter { MainPresenter(MainModel()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        with(binding) {
            loadPictureBtn.setOnClickListener {
                presenter.onButtonClick()
            }
        }
    }



    override fun setText() {

    }


}
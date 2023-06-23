package com.example.fileconvertor

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.converterjpg.MainPresenter
import com.example.converterjpg.MainView
import com.example.fileconvertor.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initPresenter()

        with(binding) {
            loadPictureBtn.setOnClickListener {
                presenter.onButtonClick()
            }
        }
    }

    private fun initPresenter() {
        presenter = MainPresenter(this)
    }

    override fun setText() {

    }


}
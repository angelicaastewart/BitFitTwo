package com.example.bitfittwo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bitfittwo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var waterItemViewModel: WaterItemViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        waterItemViewModel = ViewModelProvider(this).get(WaterItemViewModel::class.java)


      binding.fragment1Btn.setOnClickListener {
            replaceFragment(Fragment1())


        }
        binding.fragment2Btn.setOnClickListener {
           replaceFragment(Fragment2())
       }

        binding.button.setOnClickListener{
            NewWaterSheet(null).show(supportFragmentManager, "newWaterTag")
        }



        setRecyclerView()

    }

    private fun replaceFragment(fragment:Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer,fragment)
        fragmentTransaction.commit()
    }

    private fun setRecyclerView(){
        val mainActivity = this
        waterItemViewModel.waterItems.observe(this){
            binding.waterItemRecyclerView.apply{
                layoutManager = LinearLayoutManager(applicationContext)
                adapter = WaterItemAdapter(it)
            }
        }
    }
}
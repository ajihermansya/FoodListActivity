package com.rumahcerita.listinformation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rumahcerita.listinformation.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailedBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val time = intent.getStringExtra("time")
            val ingredients = intent.getIntExtra("ingredients", R.string.pecelpitik)
            val desc = intent.getIntExtra("desc", R.string.pecelpitikDesc)
            val image = intent.getIntExtra("image", R.drawable.pecelpitik)
            binding.detailName.text = name
            binding.detailTime.text = time
            binding.detailDesc.setText(desc)
            binding.detailIngredients.setText(ingredients)
            binding.detailImage.setImageResource(image)
        }
    }
}
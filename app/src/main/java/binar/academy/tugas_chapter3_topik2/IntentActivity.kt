package binar.academy.tugas_chapter3_topik2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.tugas_chapter3_topik2.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getIntentData()
    }

    private fun getIntentData() {
        binding.tvUmurIntent.text = "Umur Anda: ${intent.getIntExtra("umurintent",0)} tahun"
        binding.tvTinggiIntent.text = "Tinggi: ${intent.getDoubleExtra("tbintent", 0.0).toInt()} cm"
        binding.tvBeratBadanIntent.text = "Berat Badan: ${intent.getDoubleExtra("bbintent", 0.0).toInt()} kg"
        binding.tvBmiIntent.text = "Bmi Anda: ${intent.getIntExtra("bmiintent",0)}"
        binding.tvKategoriBmiIntent.text = "Kategori: ${intent.getStringExtra("kategoriintent")}"
    }
}
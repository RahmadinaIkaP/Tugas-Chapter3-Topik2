package binar.academy.tugas_chapter3_topik2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.tugas_chapter3_topik2.databinding.ActivityBundleBinding

class BundleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBundleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBundleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getBundleData()
    }

    private fun getBundleData(){
        val bundleData = intent.extras

        binding.tvUmurBundle.text = "Umur Anda: ${bundleData?.getInt("umurbundle")} tahun"
        binding.tvTinggiBundle.text = "Tinggi: ${bundleData?.getDouble("tbbundle")?.toInt()} cm"
        binding.tvBeratBadanBundle.text = "Berat Badan: ${bundleData?.getDouble("bbbundle")?.toInt()} kg"
        binding.tvBmiBundle.text = "Bmi Anda: ${bundleData?.getInt("bmibundle")}"
        binding.tvKategoriBmiBundle.text = "Kategori: ${bundleData?.getString("kategoribundle")}"
    }
}
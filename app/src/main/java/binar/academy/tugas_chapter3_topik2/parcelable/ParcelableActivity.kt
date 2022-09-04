package binar.academy.tugas_chapter3_topik2.parcelable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.tugas_chapter3_topik2.databinding.ActivityParcelableBinding

class ParcelableActivity : AppCompatActivity() {
    private lateinit var binding: ActivityParcelableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityParcelableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getParcelableData()
    }

    private fun getParcelableData() {
        val getDataBmi = intent.getParcelableExtra<DataBmiParcel>("databmiParcel")

        binding.tvUmurParcel.text = "Umur Anda: ${getDataBmi?.umur} tahun"
        binding.tvTinggiParcel.text = "Tinggi: ${getDataBmi?.tinggi?.toInt()} cm"
        binding.tvBeratBadanParcel.text = "Berat Badan: ${getDataBmi?.beratBadan?.toInt()} kg"
        binding.tvBmiParcel.text = "Bmi Anda: ${getDataBmi?.bmi}"
        binding.tvKategoriBmiParcel.text = "Kategori: ${getDataBmi?.kategori}"
    }
}
package binar.academy.tugas_chapter3_topik2.serializable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.tugas_chapter3_topik2.databinding.ActivitySerializableBinding

class SerializableActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySerializableBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySerializableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getSerializableData()
    }

    private fun getSerializableData() {
        val getDataBmi = intent.getSerializableExtra("databmiSerial") as DataBmiSerial

        binding.tvUmurSerial.text = "Umur Anda: ${getDataBmi.umur} tahun"
        binding.tvTinggiSerial.text = "Tinggi: ${getDataBmi.tinggi.toInt()} cm"
        binding.tvBeratBadanSerial.text = "Berat Badan: ${getDataBmi.beratBadan.toInt()} kg"
        binding.tvBmiSerial.text = "Bmi Anda: ${getDataBmi.bmi}"
        binding.tvKategoriBmiSerial.text = "Kategori: ${getDataBmi.kategori}"

    }
}
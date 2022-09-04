package binar.academy.tugas_chapter3_topik2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import binar.academy.tugas_chapter3_topik2.databinding.ActivityMainBinding
import binar.academy.tugas_chapter3_topik2.parcelable.DataBmiParcel
import binar.academy.tugas_chapter3_topik2.parcelable.ParcelableActivity
import binar.academy.tugas_chapter3_topik2.serializable.DataBmiSerial
import binar.academy.tugas_chapter3_topik2.serializable.SerializableActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var umur = 0
    var bbToDouble = 0.0
    var tinggiToDouble  = 0.0
    var bmi = 0.0
    var kategoriBmi = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hitungBmiSerializable()
        hitungBmiParcelable()
        hitungBmiBundle()
        hitungBmiIntent()

        binding.btnReset.setOnClickListener {
            reset()
        }
    }

    private fun reset(){
        binding.etUmur.setText("")
        binding.etTinggiBadan.setText("")
        binding.etBeratBadan.setText("")
    }

    private fun hitungBmiIntent() {
        binding.btnHitungIntent.setOnClickListener {
            when {
                binding.etUmur.text.isEmpty() -> binding.etUmur.error = "Umur tidak boleh kosong!"
                binding.etTinggiBadan.text.isEmpty() -> binding.etTinggiBadan.error =
                    "Tinggi badan tidak boleh kosong!"
                binding.etBeratBadan.text.isEmpty() -> binding.etBeratBadan.error =
                    "Berat badan tidak boleh kosong"
                else -> {
                    umur = binding.etUmur.text.toString().toInt()
                    bbToDouble = binding.etBeratBadan.text.toString().toDouble()
                    tinggiToDouble = binding.etTinggiBadan.text.toString().toDouble()

                    bmi = bbToDouble / ((tinggiToDouble * tinggiToDouble) * 0.0001)

                    tentukanKategori(bmi)

                    val intent = Intent(this, IntentActivity::class.java)
                    intent.putExtra("umurintent", umur)
                    intent.putExtra("tbintent", tinggiToDouble)
                    intent.putExtra("bbintent", bbToDouble)
                    intent.putExtra("bmiintent", bmi.toInt())
                    intent.putExtra("kategoriintent", kategoriBmi)
                    startActivity(intent)
                }
            }
        }
    }

    private fun hitungBmiBundle(){
        binding.btnHitungBundle.setOnClickListener {
            when {
                binding.etUmur.text.isEmpty() -> binding.etUmur.error = "Umur tidak boleh kosong!"
                binding.etTinggiBadan.text.isEmpty() -> binding.etTinggiBadan.error =
                    "Tinggi badan tidak boleh kosong!"
                binding.etBeratBadan.text.isEmpty() -> binding.etBeratBadan.error =
                    "Berat badan tidak boleh kosong"
                else -> {
                    umur = binding.etUmur.text.toString().toInt()
                    bbToDouble = binding.etBeratBadan.text.toString().toDouble()
                    tinggiToDouble = binding.etTinggiBadan.text.toString().toDouble()

                    bmi = bbToDouble / ((tinggiToDouble * tinggiToDouble) * 0.0001)

                    tentukanKategori(bmi)

                    val bundle = Bundle()
                    bundle.putInt("umurbundle", umur)
                    bundle.putDouble("tbbundle", tinggiToDouble)
                    bundle.putDouble("bbbundle", bbToDouble)
                    bundle.putInt("bmibundle", bmi.toInt())
                    bundle.putString("kategoribundle", kategoriBmi)

                    val intent = Intent(this, BundleActivity::class.java)
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
            }
        }
    }

    private fun hitungBmiSerializable(){
        binding.btnHitungSerial.setOnClickListener {
            when {
                binding.etUmur.text.isEmpty() -> binding.etUmur.error = "Umur tidak boleh kosong!"
                binding.etTinggiBadan.text.isEmpty() -> binding.etTinggiBadan.error =
                    "Tinggi badan tidak boleh kosong!"
                binding.etBeratBadan.text.isEmpty() -> binding.etBeratBadan.error =
                    "Berat badan tidak boleh kosong"
                else -> {
                    umur = binding.etUmur.text.toString().toInt()
                    bbToDouble = binding.etBeratBadan.text.toString().toDouble()
                    tinggiToDouble = binding.etTinggiBadan.text.toString().toDouble()

                    bmi = bbToDouble / ((tinggiToDouble * tinggiToDouble) * 0.0001)

                    tentukanKategori(bmi)

                    val dataBmiSerial = DataBmiSerial(umur, tinggiToDouble, bbToDouble, bmi.toInt(), kategoriBmi)
                    val intent = Intent(this, SerializableActivity::class.java)
                    intent.putExtra("databmiSerial", dataBmiSerial)
                    startActivity(intent)
                }
            }
        }

    }

    private fun hitungBmiParcelable(){
        binding.btnHitungParcel.setOnClickListener {
            when {
                binding.etUmur.text.isEmpty() -> binding.etUmur.error = "Umur tidak boleh kosong!"
                binding.etTinggiBadan.text.isEmpty() -> binding.etTinggiBadan.error =
                    "Tinggi badan tidak boleh kosong!"
                binding.etBeratBadan.text.isEmpty() -> binding.etBeratBadan.error =
                    "Berat badan tidak boleh kosong"
                else -> {
                    umur = binding.etUmur.text.toString().toInt()
                    bbToDouble = binding.etBeratBadan.text.toString().toDouble()
                    tinggiToDouble = binding.etTinggiBadan.text.toString().toDouble()

                    bmi = bbToDouble / ((tinggiToDouble * tinggiToDouble) * 0.0001)

                    tentukanKategori(bmi)

                    val dataBmiParcel = DataBmiParcel(umur, tinggiToDouble, bbToDouble, bmi.toInt(), kategoriBmi)
                    val intent = Intent(this, ParcelableActivity::class.java)
                    intent.putExtra("databmiParcel", dataBmiParcel)
                    startActivity(intent)
                }
            }
        }

    }

    private fun tentukanKategori(bmi : Double){
        when {
            bmi < 16.0 -> kategoriBmi = "Terlalu Kurus"
            bmi in 16.0..17.0 -> kategoriBmi = "Cukup Kurus"
            bmi in 17.0..18.5 -> kategoriBmi = "Sedikit Kurus"
            bmi in 18.5..25.0 -> kategoriBmi = "Normal"
            bmi in 25.0..30.0 -> kategoriBmi = "Gemuk"
            bmi in 30.0..35.0 -> kategoriBmi = "Obesitas Kelas I"
            bmi in 35.0..40.0 -> kategoriBmi = "Obesitas Kelas II"
            bmi > 40.0 -> kategoriBmi = "Obesitas Kelas III"
        }
    }
}
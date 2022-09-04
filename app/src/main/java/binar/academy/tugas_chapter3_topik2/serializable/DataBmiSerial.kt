package binar.academy.tugas_chapter3_topik2.serializable

import java.io.Serializable

data class DataBmiSerial(
    val umur : Int,
    val tinggi : Double,
    val beratBadan : Double,
    val bmi : Int,
    val kategori : String
): Serializable

package binar.academy.tugas_chapter3_topik2.parcelable

import android.os.Parcel
import android.os.Parcelable

data class DataBmiParcel(
    val umur : Int,
    val tinggi : Double,
    val beratBadan : Double,
    val bmi : Int,
    val kategori : String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(umur)
        parcel.writeDouble(tinggi)
        parcel.writeDouble(beratBadan)
        parcel.writeInt(bmi)
        parcel.writeString(kategori)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataBmiParcel> {
        override fun createFromParcel(parcel: Parcel): DataBmiParcel {
            return DataBmiParcel(parcel)
        }

        override fun newArray(size: Int): Array<DataBmiParcel?> {
            return arrayOfNulls(size)
        }
    }
}

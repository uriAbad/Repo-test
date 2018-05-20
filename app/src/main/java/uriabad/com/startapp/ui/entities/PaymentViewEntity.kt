package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class PaymentViewEntity(val id: Long, val date: String, val product: String,
                             val currency: String, val price: Double) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(date)
        parcel.writeString(product)
        parcel.writeString(currency)
        parcel.writeDouble(price)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PaymentViewEntity> {
        override fun createFromParcel(parcel: Parcel): PaymentViewEntity {
            return PaymentViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<PaymentViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}
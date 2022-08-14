package com.developer.mk.apnadukan.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * A data model class for Cart item with required fields.
 */
@Parcelize
data class CartItem(
    val user_id: String = "",
    val product_id: String = "",
    val title: String = "",
    val price: String = "",
    val image: String = "",
    val cart_quantity: String = "",
    var stock_quantity: String = "",
    var id: String = "",
) : Parcelable
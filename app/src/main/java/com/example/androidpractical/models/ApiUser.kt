package com.example.androidpractical.models

import com.google.gson.annotations.SerializedName

data class ApiUser(
    @SerializedName("page")
    var page: Int? = null,
    @SerializedName("per_page")
    var perPage: Int? = null,
    @SerializedName("total")
    var total: Int? = null,
    @SerializedName("total_pages")
    var totalPages: Int? = null,
    @SerializedName("data")
    var data: ArrayList<Data> = arrayListOf(),
    @SerializedName("support")
    var support: Support? = Support()
) {
    data class Data(
        @SerializedName("id")
        var id: Int,
        @SerializedName("email")
        var email: String,
        @SerializedName("first_name")
        var firstName: String,
        @SerializedName("last_name")
        var lastName: String,
        @SerializedName("avatar")
        var profilePIc: String
    )

    data class Support(
        @SerializedName("url")
        var url: String? = null,
        @SerializedName("text")
        var text: String? = null
    )
}
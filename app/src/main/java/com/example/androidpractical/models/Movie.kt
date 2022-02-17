package com.example.androidpractical.models

data class Movie(
    var name: String,
    var realName: String,
    var team: String,
    var firstAppearance: String,
    var createdBy: String,
    var publisher: String,
    var imageUrl: Int,
    var bio: String,
    var isExpanded: Boolean
)

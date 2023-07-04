package com.aliazaz.composeapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ArtShowCaseModel(
    @DrawableRes var artImage: Int,
     var artName: String,
     var artistName: String,
     var artPublishedYear: String
)
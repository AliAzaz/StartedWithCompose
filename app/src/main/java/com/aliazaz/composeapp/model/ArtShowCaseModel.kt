package com.aliazaz.composeapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ArtShowCaseModel(
    @DrawableRes var artImage: Int,
    @StringRes var artName: Int,
    @StringRes var artistName: Int,
    @StringRes var artPublishedYear: Int
)
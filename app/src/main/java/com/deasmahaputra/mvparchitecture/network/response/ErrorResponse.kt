package com.deasmahaputra.mvparchitecture.network.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(@SerializedName("message") var error: String?)
package me.sargunvohra.lib.pokekotlin.client

import okhttp3.ResponseBody

class ErrorResponse(val body: ResponseBody): Throwable()
package com.example.volley

import com.android.volley.toolbox.HurlStack
import com.squareup.okhttp.OkHttpClient
import com.squareup.okhttp.OkUrlFactory
import okio.IOException
import java.net.HttpURLConnection
import java.net.URL


class OkHttpStack @JvmOverloads constructor(okUrlFactory: OkUrlFactory? = OkUrlFactory(OkHttpClient())) :
    HurlStack() {
    private val okUrlFactory: OkUrlFactory

    @Throws(IOException::class)
    override fun createConnection(url: URL?): HttpURLConnection {
        return okUrlFactory.open(url)
    }

    init {
        if (okUrlFactory == null) {
            throw NullPointerException("Client must not be null.")
        }
        this.okUrlFactory = okUrlFactory
    }
}
package com.example.volley

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {

    val TAG = "TAG"
    lateinit var stringRequest: StringRequest
    lateinit var queue: RequestQueue

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)

        // Instantiate the RequestQueue.
        queue = Volley.newRequestQueue(this)
        val url = "https://www.google.com"

        // Request a string response from the provided URL.
        stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.
                textView.text = "Response is: ${response.substring(0, 500)}"
            },
            { textView.text = "That didn't work!" })

        // Set the tag on the request.
        stringRequest.tag = TAG

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    override fun onStop() {
        super.onStop()
            super.onStop()
            queue.cancelAll(TAG)
    }
}
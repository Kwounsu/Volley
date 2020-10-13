package com.example.volley

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
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
        queue = Volley.newRequestQueue(this, OkHttpStack())
        val url = "https://api.github.com/zen"

        // Request a string response from the provided URL.
        stringRequest = StringRequest(
            Request.Method.GET, url,
            { response ->
                // Display the first 500 characters of the response string.
                textView.text = "$response"
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
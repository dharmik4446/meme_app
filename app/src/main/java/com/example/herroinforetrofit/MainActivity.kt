package com.example.herroinforetrofit

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.herroinforetrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        binding.btnNewMeme.setOnClickListener {
            getData()
        }
    }



    private fun getData() {


        val progressDialog= ProgressDialog(this)
        progressDialog.setMessage("Please wait while data is being fetch")
        progressDialog.show()



        RetrofitInstance.apiInterface.getData().enqueue(object : Callback<responedaclass?> {
            override fun onResponse(
                call: Call<responedaclass?>,
                response: Response<responedaclass?>
            ) {

                binding.memeTitle.text=response.body()?.title
                binding.memeAuthor.text=response.body()?.author
                Glide.with(this@MainActivity).load(response.body()?.url).into(binding.memeImage);


                progressDialog.dismiss()
            }

            override fun onFailure(call: Call<responedaclass?>, t: Throwable) {
                Toast.makeText(this@MainActivity,"${t.localizedMessage}",Toast
                    .LENGTH_SHORT).show()
                progressDialog.dismiss()
            }
        })

    }
}
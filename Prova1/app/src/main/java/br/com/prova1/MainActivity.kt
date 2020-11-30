package br.com.prova1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnConsultar = findViewById(R.id.btnConsultar) as Button

        btnConsultar.setOnClickListener {
            //Obtem dados dos campos do app
            val latitudeString = (findViewById(R.id.latitudeText) as TextView).text.toString()     //EX: 37.8267
            val longitudeString = (findViewById(R.id.longitudeText) as TextView).text.toString()  //EX: -122.4233

            //Obtem retorno da API darksky
            val serviceRetrofit = RetrofitService()

            serviceRetrofit.api?.getByLatitudeLongetude(latitudeString.toDouble(), longitudeString.toDouble())?.enqueue(
                object: Callback<DarkskyWeather> {
                    override fun onResponse(call: Call<DarkskyWeather>?, response: Response<DarkskyWeather>?) {
                        var dw: DarkskyWeather? = response?.body()
                        var currently: Currently? = dw?.currently

                        //Seta imagem de acordo com o retorno
                        for (value in WheaterType.values()) {
                            if (currently?.icon == value.nome) imagemClima.setImageResource(value.imgId)
                        }
                    }
                    override fun onFailure(call: Call<DarkskyWeather>?, t: Throwable?) {

                        Log.e("Erro", "************** erro **********\n"+t?.message.toString())
                    }
                }
            )
        }
    }
}
package br.com.prova1

import br.com.prova1.DarkskyWeather
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface EndPointApi {
    @GET("forecast/8eeafa93fa171bb970bfac9b03caa3a3/{latitude},{longitude}?exclude=minutely,hourly,daily,flags,alerts")
    fun getByLatitudeLongetude(@Path("latitude") latitude: Double?, @Path("longitude") longitude: Double?): Call<DarkskyWeather>
}
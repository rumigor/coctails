package ru.rumigor.drinks.data.api


import okhttp3.Interceptor
import okhttp3.Response
import ru.rumigor.drinks.BuildConfig.API_KEY

object DrinksApiInterceptor : Interceptor {


    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("x-rapidapi-host", "the-cocktail-db.p.rapidapi.com")
                .addHeader("x-rapidapi-key", API_KEY)
                .build()
        )

}
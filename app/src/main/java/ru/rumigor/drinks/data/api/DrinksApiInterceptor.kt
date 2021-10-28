package ru.rumigor.drinks.data.api


import okhttp3.Interceptor
import okhttp3.Response


object DrinksApiInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response =
        chain.proceed(
            chain.request()
                .newBuilder()
                .addHeader("x-rapidapi-host", "the-cocktail-db.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "2d55321602msh33c8d91c041d686p1bd305jsn6b6ee598e59a")
                .build()
        )

}
package ru.rumigor.drinks.data.di.modules


import dagger.Module
import dagger.Provides
import dagger.Reusable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.rumigor.drinks.data.api.DrinksApi
import ru.rumigor.drinks.data.api.DrinksApiInterceptor
import javax.inject.Named

@Module
class DrinksApiModule {

    @Named("drinks_api")
    @Provides
    fun provideBaseUrlProd(): String = "https://the-cocktail-db.p.rapidapi.com/popular.php/"


    @Reusable
    @Provides
    fun provideGitHubApi(@Named("drinks_api") baseUrl: String): DrinksApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(DrinksApiInterceptor)
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DrinksApi::class.java)

}
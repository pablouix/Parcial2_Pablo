package edu.ucne.consumiendoapi.di

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.ucne.consumiendoapi.remota.dto.VerbosApi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideMoshi(): Moshi
    {
        return Moshi
            .Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    }


    @Singleton
    @Provides
    fun provideSagApi(moshi: Moshi): VerbosApi {
        val BASE_URL = "https://private-a127e-verbos.apiary-mock.com/verbos"

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(VerbosApi::class.java)
    }

}
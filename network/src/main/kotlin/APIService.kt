package network

import interfaces.NetworkInterface
import io.reactivex.Single
import entities.Repo
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

//https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json
interface APIServiceInterface {
    @GET("users/{user}/repos")
    fun listRepos (@Path("user") user:String): Call<List<Repo>>
}

class APIService @Inject constructor() : NetworkInterface {
    var rf:Retrofit = Retrofit.Builder()
         .baseUrl("https://api.github.com/")
         .addConverterFactory(GsonConverterFactory.create())
         .build()

    fun getservice():APIServiceInterface{
       return rf.create(APIServiceInterface::class.java)
    }

    override fun listRepos(user: String): Single<List<Repo>> {
        return Single.just(getservice().listRepos(user).execute().body())
    }
}

fun main(){
    print(APIService().getservice().listRepos("barron9").execute().body())
}
package network

import entities.CarMake
import entities.CarResponse
import interfaces.NetworkInterface
import io.reactivex.Single
import entities.Repo
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Inject

//https://vpic.nhtsa.dot.gov/api/vehicles/getallmakes?format=json
//https://vpic.nhtsa.dot.gov/api/vehicles/GetMakeForManufacturer/renault?format=json
interface APIServiceInterface {
    @GET("users/{user}/repos") //api.github.com
    fun listRepos (@Path("user") user:String): Call<List<Repo>>

}

interface CarAPIInterface {
    @GET("api/vehicles/GetMakeForManufacturer/{make}?format=json")
    fun GetMakeForManufacturer (@Path("make") make:String): Call<CarResponse>
}

class APIService @Inject constructor() : NetworkInterface {
    var rf:Retrofit = Retrofit.Builder()
         .baseUrl("https://vpic.nhtsa.dot.gov/")
         .addConverterFactory(GsonConverterFactory.create())
         .build()

    fun getservice():CarAPIInterface{
       return rf.create(CarAPIInterface::class.java)
    }

  //  override fun listRepos(user: String): Single<List<Repo>> {
   //     return Single.just(getservice().listRepos(user).execute().body())
   // }

    override fun GetMakeForManufacturer(make: String): Observable<CarResponse?> {
        var res= getservice().GetMakeForManufacturer(make).execute()

        return Single.just(res.body()!!).toObservable()
    }

}

fun main(){
   // print(APIService().getservice().listRepos("barron9").execute().body())
}


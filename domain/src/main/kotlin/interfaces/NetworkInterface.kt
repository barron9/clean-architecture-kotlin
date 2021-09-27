package interfaces

import entities.CarResponse
import io.reactivex.Single
import entities.Repo
import io.reactivex.Observable

interface NetworkInterface {
  //  fun listRepos(user:String):Single<List<Repo>>
    fun GetMakeForManufacturer(make:String):Observable<CarResponse?>

}
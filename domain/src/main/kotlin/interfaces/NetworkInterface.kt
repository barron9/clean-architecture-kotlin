package interfaces

import io.reactivex.Single
import entities.Repo

interface NetworkInterface {
    fun listRepos(user:String):Single<List<Repo>>
}
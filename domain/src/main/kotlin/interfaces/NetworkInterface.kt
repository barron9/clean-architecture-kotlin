package interfaces

import io.reactivex.Single
import models.Repo

interface NetworkInterface {
    fun listRepos(user:String):Single<List<Repo>>
}
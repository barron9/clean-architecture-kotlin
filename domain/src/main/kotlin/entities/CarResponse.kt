package entities

data class CarResponse (
    val Count:Int,val Message:String,val SearchCriteria:String,val Results:List<CarMake>
        )
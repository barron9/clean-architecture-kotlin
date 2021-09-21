package usecases

import interfaces.DataInterface
import interfaces.UsecaseExecutor
import javax.inject.Inject

class DefaultUseCase @Inject constructor(val datacachefactory: DataInterface):UsecaseExecutor{

    //inject datalayerResponder#1

    override fun exec(){
        //default test action
        this.datacachefactory.getCar()
    }
}
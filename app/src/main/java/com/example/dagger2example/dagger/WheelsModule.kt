package com.example.dagger2example.dagger

import com.example.dagger2example.car.Rims
import com.example.dagger2example.car.Tires
import com.example.dagger2example.car.Wheels
import dagger.Module
import dagger.Provides

/*  (11)
    Since the purpose of this class to create wheels, we call it WheelsModule
    Modules: Annotates a class that contributes to the object graph. (by methods)

    We need wheels, but for wheel we need rims and tires.
*/

@Module
class WheelsModule {

    @Provides
    fun provideRims() = Rims() // Here we tell dagger how to provide rims.

    @Provides
    fun provideTires() = Tires()

    /*  (12)
        Now, dagger knows how to create rims and tires.
        So, we can pass those objects as arguments to this method.
        When dagger calls this provides method, it will pass rims and tires by getting upper two
        methods.
    */
    @Provides
    fun provideWheels(rims: Rims, tires: Tires) = Wheels(rims, tires)
}

/*  (13)
    Now dagger knows how to create all of these objects although they are not our classes.
    Only thing left to tell dagger to use this module. (add in component)
*/
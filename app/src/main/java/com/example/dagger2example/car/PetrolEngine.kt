package com.example.dagger2example.car

import android.util.Log
import javax.inject.Inject

/*  (16)
    Since we own these classes (PetrolEngine, DieselEngine), we can use constructor injection.
    So, now dagger can instantiate these classes and provide them.

    *** Still one problem !!
    Our car class defines an engine interface in its constructor. And dagger doesn't know whether
    provide DieselEngine or PetrolEngine. And it cannot pick one randomly!

    Therefore, we have to create a module to solve that issue.
    Let's start with one, PetrolEngineModule.
*/

class PetrolEngine @Inject constructor() : Engine {
    override fun start() {
        Log.i("Car", "Petrol engine started...")
    }
}
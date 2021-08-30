package com.example.dagger2example.car

import android.util.Log
import javax.inject.Inject

/*  (1)
    Providing objects as constructor parameters is actually dependency injection.
    By doing that, we are not implementing the instantiation of objects.
    So, Car class only does what it needs, drive. --> Single Responsibility.
    ***This is about Dependency Injection, not Dagger***

*/

/*  (3)
    When we write @Inject at the beginning of constructor, dagger knows that this the way of
    instantiating a car object
    After that, dagger now can inject this constructor

    **** But it also needs to know how instantiate engine and wheels objects.
    We should inject them, too.

    After that, dagger knows everything it needs to know.
*/

/*  (8)
    Injection order : Constructor -> Field -> Method
    If we have constructor injection, other injections are triggered automatically.
    If we don't have inject annotated constructor, we have to trigger field and method injection
    manually (by calling inject on the component (Like in the MainActivity)).
*/

// Constructor injection
class Car @Inject constructor(private val engine: Engine, private val wheels: Wheels) {
    fun drive() {
        engine.start()
        Log.i("Car", "Driving...")
    }
}
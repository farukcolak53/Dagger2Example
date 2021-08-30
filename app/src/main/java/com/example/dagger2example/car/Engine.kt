package com.example.dagger2example.car

// import javax.inject.Inject

/*  (15)
    ** Dependency on an interface
    If Engine would be an interface instead of a class, we couldn't inject it, because interfaces
    cannot be instantiated. Interfaces don't have constructors, so we cannot use constructor
    injection.
    So, when dagger tries to create car, it cannot instantiate an engine -> compile error.
    But of course we can create classes that implement engine interface. And we can use constructor
    injection on them.
*/

//class Engine @Inject constructor()

interface Engine {
    fun start()
}
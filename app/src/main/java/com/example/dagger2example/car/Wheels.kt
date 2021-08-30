package com.example.dagger2example.car

/*  (10)
    Let's say this is a 3rd party class, we cannot annotate it with @Inject
    ** We have to use modules here.
*/

class Wheels constructor(private val rims: Rims, private val tires: Tires) {
}
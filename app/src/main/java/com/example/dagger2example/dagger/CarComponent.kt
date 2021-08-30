package com.example.dagger2example.dagger

import dagger.Component

/*  (4)
    Creates and stores the objects, and then provides them to us. (Injector)
    Dagger will implement this interface in the compile time, and create all the necessary code
    We don't have to specify how the "getCar" method works, dagger does that.
    This is our access point. Without that, dagger wouldn't work.
*/
/*  (7)
    We have to add different inject methods for every activity we would like to use dagger.
    We cannot use directly the parent (AppCompatActivity). *****
    Name of the method doesn't matter. Important part is the argument.
    So, we don't need getCar method anymore.
*/
/*  (14)
    (modules = [WheelsModule::class]
    Now dagger puts this module into our CarComponent, and knows that whenever it needs wheels,
    rims or tires, it gets them from WheelsModule.
*/

/*  (19)
    Here, we can easily swap our modules. --> We can easily test our app.
    Because, we can also have a fake module to test.
    But we cannot put both DieselEngineModule and PetrolEngineModule together.
    Because dagger wouldn't know which engine to use.
*/


@Component(modules = [WheelsModule::class, /*PetrolEngineModule::class,*/ DieselEngineModule::class])
interface CarComponent {
    //fun getCar(): Car
    fun inject(activity: MainActivity)
}
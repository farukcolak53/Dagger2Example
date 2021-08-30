package com.example.dagger2example.dagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger2example.R
import com.example.dagger2example.car.Car
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    /*  (2)
        Here, we can create car object by ourselves. But it needs wheel and engine objects.
        So, we also need to create them. Let's say they are also dependent on other objects,
        like tyres and rims, so we need to create them, too. And, if there has to be change,
        we have to change them at everywhere. This goes and goes.
        **** Dagger solves this. ****
        We teach dagger how to construct those objects, and then it creates them at the
        right time and at the right order. It saves us from the boilerplate code.
    */
    /*  (6)
        We can also inject that car object with dagger (field injection). But dagger doesn't
        support field injection for private members. Because component cannot access it.
        Also, it cannot be 'val', because it will change later.
        To do that, we should add inject method to CarComponent. Then call it from here.
        By calling inject method, we tell dagger to take our activity, and inject our
        member variables (members of activity).
    */

    @Inject
    lateinit var car: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*  (5)
            Here, we need an instance of our CarComponent, to get the car.
            But, it is an interface, we cannot instantiate it.
            *** But, since we annotated it, and compiled it successfully, dagger created the
            DaggerCarComponent for us. --> Implementation of CarComponent interface
        */

        val carComponent: CarComponent = DaggerCarComponent.create()

        /*  (9)
            In MainActivity, we cannot do constructor injection. So, we have to trigger the
            injection process manually, by calling inject method on component and passing the
            activity.
        */

        //car = carComponent.getCar()
        carComponent.inject(this)
        car.drive()
    }
}
package com.example.dagger2example.dagger

import com.example.dagger2example.car.DieselEngine
import com.example.dagger2example.car.Engine
import dagger.Binds
import dagger.Module

@Module
abstract class DieselEngineModule {

    /*  (17)
        Since we used constructor injection in DieselEngine, we can pass it as argument here.
        Because dagger knows how to create a DieselEngine instance.

        After that, add this module to the CarComponent.
    */

    /*  (18)
        **Optimization
        provideEngine method is redundant.
        Delete the method body. Turn it into an abstract method, and also class. And instead of
        provides, annotate as @Binds. Change the method name to bindEngine.

        Still works!

        Why more optimized?
        * Dagger never creates an implementation for this class or for this method and never
        calls this method. It just instantiates a DieselEngine directly. Provides better
        performance.
        *** Whenever you just want to bind an implementation to an interface --> use @Binds

        @Binds takes a single argument which is the implementation of the interface.
        (DieselEngine is the argument which is the implementation of the Engine interface).

        You cannot use @Provides here, because this class is never implemented by dagger. Because
        provider methods needs instances.
    */

    //@Provides
    //fun provideEngine(engine: DieselEngine): Engine = engine

    @Binds
    abstract fun bindEngine(engine: DieselEngine): Engine
}
package com.example.dagger2example.dagger

import com.example.dagger2example.car.Engine
import com.example.dagger2example.car.PetrolEngine
import dagger.Binds
import dagger.Module

@Module
abstract class PetrolEngineModule {

    /*  (17)
        Since we used constructor injection in PetrolEngine, we can pass it as argument here.
        Because dagger knows how to create a PetrolEngine instance.

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
        calls this method. It just instantiates a PetrolEngine directly. Provides better
        performance.
        ***** Whenever you just want to bind an implementation to an interface --> use @Binds

        @Binds takes a single argument which is the implementation of the interface.
        (PetrolEngine is the argument which is the implementation of the Engine interface).

        You cannot use @Provides here, because this class is never implemented by dagger. Because
        provider methods needs instances.
    */

    //@Provides
    //fun provideEngine(engine: PetrolEngine): Engine = engine

    @Binds
    abstract fun bindEngine(engine: PetrolEngine): Engine
}
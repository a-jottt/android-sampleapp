package pl.neducatio.myapplication.services;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import pl.neducatio.myapplication.RetrofitFactory;

@Module
public class RestServiceModule {
    @Provides
    @Singleton
    IPService provideIPService() {
        return  RetrofitFactory.getAdapter().create(IPService.class);
    }
}

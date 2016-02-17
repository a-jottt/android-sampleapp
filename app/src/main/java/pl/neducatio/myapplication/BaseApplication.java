package pl.neducatio.myapplication;

import javax.inject.Singleton;

import dagger.Component;
import pl.neducatio.myapplication.activities.MainActivity;
import pl.neducatio.myapplication.services.RestServiceModule;

public class BaseApplication extends android.app.Application {

    @Singleton
    @Component(modules = RestServiceModule.class)
    public interface ApplicationComponent {
        void inject(BaseApplication application);
        void inject(MainActivity mainActivity);
    }

    private ApplicationComponent component;

    @Override public void onCreate() {
        super.onCreate();

        component = DaggerBaseApplication_ApplicationComponent.builder()
                .restServiceModule(new RestServiceModule())
                .build();
        component().inject(this);
    }

    public void setComponent(ApplicationComponent component) {
        this.component = component;
    }

    public ApplicationComponent component() {
        return component;
    }
}

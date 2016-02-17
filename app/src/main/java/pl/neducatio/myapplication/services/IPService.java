package pl.neducatio.myapplication.services;

import pl.neducatio.myapplication.models.IPModel;
import retrofit2.http.GET;
import rx.Observable;

public interface IPService {

    @GET("/")
    Observable<IPModel> getMyIp();
}

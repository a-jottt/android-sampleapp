package pl.neducatio.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class IPModel {

    @SerializedName("ip")
    protected String ip;

    public String getIp() {
        return ip;
    }
}

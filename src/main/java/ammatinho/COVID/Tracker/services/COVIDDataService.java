package ammatinho.COVID.Tracker.services;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class COVIDDataService {

    private static String COVID_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    public void fetchCOVIDData() {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(COVID_DATA_URL))
                .build();
    }
}

package com.asi.kursasiandek.Networking;

import com.asi.kursasiandek.Model.StackQuestions;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StackService {
    @GET("2.2/questions?order=desc&sort=activity&tagged=Android&site=stackoverflow")
    Call<StackQuestions> getQuestion();
}

package com.example.toycathon.utilities;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.toycathon.SplashActivity;
import com.example.toycathon.dto.Questions;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApiHelper {
    private static final String CHAPTER_ENDPOINT = "Chapter.json";
    private static String BASE_URL = "https://toycathon-rash-default-rtdb.firebaseio.com/chapter.json";
    Context context;

    public ApiHelper(Context context) {
        this.context = context;
    }

    public void fetchQuestions(SplashActivity splashActivity) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                processQuestions(response, splashActivity);
            }
        }, null);
        VolleySingleton.getInstance(context).getRequestQueue().add(jsonObjectRequest);

    }

    private void processQuestions(JSONObject response, SplashActivity splashActivity) {
        List<Questions> questions = new ArrayList<>();
        if (null != response) {
            Iterator<String> keys = response.keys();

            while (keys.hasNext()) {
                String key = keys.next();
                try {
                    if (response.get(key) instanceof JSONObject) {
                        // do something with jsonObject here
                        JSONObject temp = response.getJSONObject(key);

                        Questions question = new Questions();
                        question.setId(temp.getString("id"));
                        question.setQuestion(temp.getString("question"));
                        question.setChoice01(temp.getString("choice01"));
                        question.setChoice02(temp.getString("choice02"));
                        question.setChoice03(temp.getString("choice03"));
                        question.setChoice04(temp.getString("choice04"));
                        question.setCrtAns(temp.getString("crtAns"));
                        question.setCategories(temp.getString("categories"));
                        question.setDescription(temp.getString("description"));
                        question.setThumb(temp.getString("thumb"));
                        questions.add(question);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        splashActivity.onDataReceived(questions);
    }
}

package com.example.toycathon.utilities;

import com.example.toycathon.dto.Questions;

import java.util.List;

public interface ServerCallback {
    public void onDataReceived(List<Questions> data);
}

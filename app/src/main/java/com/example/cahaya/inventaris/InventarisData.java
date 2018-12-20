package com.example.cahaya.inventaris;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InventarisData {
    @SerializedName("data")
    public List<InventarisData> data;
}

package me.kaungmyatmin.jobseeker.model

import com.google.gson.annotations.SerializedName

class Job (
    @SerializedName("id") val id:String,
    @SerializedName("type") val type:String,
    @SerializedName("url") val url:String,
    @SerializedName("created_at") val created_at:String,
    @SerializedName("company") val company:String,
    @SerializedName("company_url") val company_url:String,
    @SerializedName("location") val location:String,
    @SerializedName("title") val title:String,
    @SerializedName("description") val description:String,
    @SerializedName("how_to_apply") val how_to_apply:String,
    @SerializedName("company_logo") val company_logo:String
)
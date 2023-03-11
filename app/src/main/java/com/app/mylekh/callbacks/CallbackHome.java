package com.app.mylekh.callbacks;

import com.app.mylekh.models.BannerData;
import com.app.mylekh.models.PostData;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CallbackHome implements Serializable {

    public String status = "";
    public List<PostData> allPost = new ArrayList<>();
    public List<BannerData> bannerList = new ArrayList<>();


}

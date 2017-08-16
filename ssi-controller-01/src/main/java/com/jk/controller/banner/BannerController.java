package com.jk.controller.banner;

import com.jk.service.banner.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/8/16.
 */
@Controller
@RequestMapping("banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;
}

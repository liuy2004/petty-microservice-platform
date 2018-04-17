package com.github.pettyfer.basic.basicinfoserver.controller;

import com.github.pettyfer.basic.basicinfoserver.service.IValidateCodeService;
import com.github.pettyfer.basic.common.exception.BaseException;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * 验证码服务
 *
 * @author Petty
 */
@Controller
@Slf4j
@RequestMapping("/code")
public class ValidateCodeController {

    private final IValidateCodeService validateCodeService;

    private final DefaultKaptcha captchaProducer;

    @Autowired
    public ValidateCodeController(DefaultKaptcha captchaProducer, IValidateCodeService validateCodeService) {
        this.captchaProducer = captchaProducer;
        this.validateCodeService = validateCodeService;
    }


    /**
     * 创建验证码
     *
     * @param machineCode 机器码
     * @param request     HttpServletRequest
     * @param response    HttpServletResponse
     * @throws Exception 异常抛出
     */
    @RequestMapping("/create/{machineCode}")
    public void createCode(@PathVariable String machineCode, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String randomStr = captchaProducer.createText();
        BufferedImage image = captchaProducer.createImage(randomStr);
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "JPEG", out);
        validateCodeService.saveCode(machineCode,randomStr);
        out.flush();
        out.close();
    }
}

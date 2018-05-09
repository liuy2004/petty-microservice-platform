package com.github.pettyfer.basic.basicinfoserver.service.impl;

import com.github.pettyfer.basic.basicinfoserver.service.IValidateCodeService;
import com.github.pettyfer.basic.common.constant.SecurityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Petty
 */
@Service("validateCodeService")
public class ValidateCodeServiceImpl implements IValidateCodeService {

    private final RedisTemplate redisTemplate;

    @Autowired
    public ValidateCodeServiceImpl(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 保存生成的验证码
     *
     * @param machineCode  机器码
     * @param validateCode 验证码
     * @return 是否保存成功
     */
    @Override
    public boolean saveCode(String machineCode, String validateCode) {
        boolean result = false;
        StringBuffer stringBuffer = new StringBuffer(SecurityConstant.VALIDATE_CODE_KEY);
        stringBuffer.append(":");
        stringBuffer.append(machineCode);
        try {
            redisTemplate.opsForValue().set(stringBuffer.toString(), validateCode, SecurityConstant.VALIDATE_CODE_EXPIRY, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //清空
            stringBuffer.setLength(0);
        }
        return result;
    }
}

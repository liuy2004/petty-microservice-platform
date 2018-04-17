package com.github.pettyfer.basic.basicinfoserver.service;

/**
 * @author Petty
 * @since 2018-04-16
 */
public interface IValidateCodeService {

    /**
     * 保存生成的验证码
     * @param machineCode 机器码
     * @param validateCode 验证码
     * @return 是否保存成功
     */
    boolean saveCode(String machineCode,String validateCode);
}

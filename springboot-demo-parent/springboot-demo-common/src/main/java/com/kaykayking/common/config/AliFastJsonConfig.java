package com.kaykayking.common.config;/**
 * @author: hk
 * @Descripiton:
 * @Date: Created in 10:32 下午 2022/7/26.
 * @Modified By:
 */

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * todo
 *
 * @author hk
 * @version Id: FastJsonConfig.java, v 0.1 2022/7/26 10:32 下午 Exp $$
 */
@Configuration
public class AliFastJsonConfig extends WebMvcConfigurationSupport {

    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config =  new FastJsonConfig();
        config.setSerializerFeatures(
                //保留map空的字段
                SerializerFeature.WriteMapNullValue,
                //将String类型的null转为""
                SerializerFeature.WriteNullStringAsEmpty,
                //将Number类型的null 转为0
                SerializerFeature.WriteNullNumberAsZero,
                //将List类型的null 转成[]
                SerializerFeature.WriteNullListAsEmpty,
                //将boolean类型的null 转成false
                SerializerFeature.WriteNullBooleanAsFalse,
                //避免循环引用
                SerializerFeature.DisableCircularReferenceDetect);

        converter.setFastJsonConfig(config);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        List<MediaType> mediaTypesList = new ArrayList<>();
        mediaTypesList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypesList);
        converters.add(converter);




    }
}
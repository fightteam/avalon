package org.fightteam.avalon.web.controller.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.*;

/**
 * 资源控制
 * User: faith
 * Date: 13-8-13
 * Time: 上午9:38
 * 在这控制全局的载入资源方便页面获取
 * 2个map在返回的时候会进行合并
 * 所以尽量不要重复map的key
 * 推荐 styles 放 stylesheet 库文件
 * 推荐 scripts 放 javascript 库文件
 */
@ControllerAdvice
public class ResourceControllerAdvice {
    private Date date;
    private Map<String,String> styles;
    private Map<String,String> scripts;
    @Autowired
    private Properties scriptsProps;
    @Autowired
    private Properties stylesProps;

    public ResourceControllerAdvice() {
        this.scripts = new HashMap<String,String>();
        this.styles = new HashMap<String,String>();

    }

    /**
     * 设置 style 路径
     * @param model
     */
    @ModelAttribute
    public void setStyles(Model model){
       for(String key:stylesProps.stringPropertyNames()){
           styles.put(key,stylesProps.getProperty(key));
       }
       model.addAttribute("styles",styles);
    }

    /**
     * 设置 script 路径
     * @param model
     */
    @ModelAttribute
    public void setScript(Model model){
        for(String key:scriptsProps.stringPropertyNames()){
            scripts.put(key,scriptsProps.getProperty(key));
        }
        model.addAttribute("scripts",scripts);
    }

    /**
     * 设置语言环境
     * @param model
     * @param locale
     */
    @ModelAttribute
    public void setLang(Model model,Locale locale){
        String lang = locale.getLanguage();
        if (locale.getCountry()!=null && !locale.getCountry().equals("")){
            lang +="_"+locale.getCountry();
        }
        model.addAttribute("lang", lang);
    }

    /**
     * 获取当前时间
     * @param model
     */
    @ModelAttribute
    public void setDate(Model model){
        model.addAttribute("date", new Date());
    }
}

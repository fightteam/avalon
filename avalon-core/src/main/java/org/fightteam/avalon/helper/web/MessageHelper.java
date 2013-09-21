package org.fightteam.avalon.helper.web;

import org.springframework.ui.Model;

/**
 * 控制层信息工具, 定义了产生信息的相关辅助方法
 *
 * @author excalibur
 * @since 0.0.1
 */
public final class MessageHelper {

    /**
     * 重置model中信息，让其处于初始状态
     * @param model
     */
    public static void setup(Model model) {
        model.addAttribute("error", false);
        model.addAttribute("success", false);
        model.addAttribute("alert", false);
        model.addAttribute("info", false);
    }

    /**
     * 在model中增加错误信息
     * @param message 错误信息
     * @param model
     */
    public static void addError(String message, Model model) {
        model.addAttribute("error", true);
        model.addAttribute("errorMessage", message);
    }

    /**
     *  在model中增加成功信息
     * @param message 成功信息
     * @param model
     */
    public static void addSuccess(String message, Model model) {
        model.addAttribute("success", true);
        model.addAttribute("successMessage", message);
    }

    /**
     * 在model中增加警告信息
     * @param message  警告信息
     * @param model
     */
    public static void addAlert(String message, Model model) {
        model.addAttribute("alert", true);
        model.addAttribute("alertMessage", message);
    }

    /**
     * 在model中增加提示信息
     * @param message 提示信息
     * @param model
     */
    public static void addInfo(String message, Model model) {
        model.addAttribute("info", true);
        model.addAttribute("infoMessage", message);
    }


}

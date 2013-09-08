package org.fightteam.avalon.tools.persistence.web;

import org.springframework.ui.Model;

/**
 * 控制层信息工具
 * User: faith
 * Date: 13-7-3
 * Time: 上午11:08
 * 定义了产生信息的相关辅助方法
 */
public final class MessageHelper {

    // Helper methods
    public static void setup(Model model) {
        model.addAttribute("error", false);
        model.addAttribute("success", false);
        model.addAttribute("alert", false);
        model.addAttribute("info", false);
        model.addAttribute("loggedIn", false);
    }

    public static void addError(String message, Model model) {
        model.addAttribute("error", true);
        model.addAttribute("errorMessage", message);
    }

    public static void addSuccess(String message, Model model) {
        model.addAttribute("success", true);
        model.addAttribute("successMessage", message);
    }

    public static void addAlert(String message, Model model) {
        model.addAttribute("alert", true);
        model.addAttribute("alertMessage", message);
    }

    public static void addInfo(String message, Model model) {
        model.addAttribute("info", true);
        model.addAttribute("infoMessage", message);
    }
}

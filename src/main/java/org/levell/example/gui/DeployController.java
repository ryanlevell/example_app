package org.levell.example.gui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/deploy")
public class DeployController {

    @GetMapping("/home")
    public String deploy() {
        return "deploy";
    }
}

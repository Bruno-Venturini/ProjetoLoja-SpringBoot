package com.satc.satcloja.health;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @GetMapping("/health")
    public String healthCheck() {
        return """
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠛⠉⠉⠛⠛⠛⠿⢿⣿⣿⣿⣿ \s
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠁⠄⠄⠄⠄⠄⠄⠄⠄⠄⠹⣿⣿⣿ \s
                ⣿⣿⣿⣿⣿⠻⠟⣻⣿⣟⠛⣿⣿⣿⠋⠄⠄⢀⣤⣤⣴⣶⣶⣤⣀⠄⠄⠘⢻⣿ \s
                ⣿⣿⣿⣿⣧⢀⣀⣻⣿⣿⣦⣿⣿⣯⠄⠄⠄⢾⣿⣿⣿⣿⣿⣿⣿⣧⠄⠄⠄⣿ \s
                ⣿⣿⣿⣿⣿⣿⣿⣿⢻⣿⣿⣿⣿⡓⠄⠄⠄⣝⣭⠉⠩⣽⡍⠉⢐⣿⡆⠄⠄⣸ \s
                ⣿⣿⣿⣿⣿⣿⣿⣆⣄⣶⣿⣿⣿⣧⣄⠄⢸⣿⣾⣾⣾⣿⣷⣾⣿⣿⡇⠄⣰⣿ \s
                ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠄⢿⣿⡿⠷⠂⠒⢿⣿⣿⠃⢀⣿⣿ \s
                ⣿⠉⢹⣿⡏⠉⡏⠉⣿⡏⠉⣿⣿⣿⠉⠉⠃⠄⠙⠁⢠⠄⠠⠄⠈⠁⠄⢸⣿⣿ \s
                ⣿⠄⢸⣿⡇⠄⡇⠄⣿⡇⠄⣿⣿⡏⠄⠄⠰⠄⠄⠄⠄⠄⠄⠄⠄⠄⢠⣼⣿⣿ \s
                ⣿⠄⠸⠿⡇⠄⠇⠄⣾⡇⠄⠿⢿⠇⠄⡀⠄⣇⡀⠄⠄⠄⠄⠄⠄⠄⣼⣿⣿⣿ \s
                ⣿⠤⢤⣤⣷⣦⣤⠶⢿⡧⠤⡤⠼⢤⣼⣿⠶⠾⠿⣦⣤⣤⣤⣦⣤⣴⣿⣿⣿⣿ \s
                ⣿⠄⢸⣿⡏⠄⢹⠄⢸⠇⢠⡇⠄⡀⠈⢻⠄⢀⣀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ \s
                ⣿⠄⢸⣿⡇⠄⢸⡇⠈⠄⢸⡇⠄⠁⢀⣾⠄⢀⣀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ \s
                ⣿⣀⣈⣁⣇⣀⣼⣿⣀⣀⣿⣇⣀⣇⣀⣹⣀⣀⣉⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿
                """;
    }
}

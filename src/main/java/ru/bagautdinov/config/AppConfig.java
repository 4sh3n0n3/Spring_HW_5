package ru.bagautdinov.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.bagautdinov.beans.components")
@ComponentScan("ru.bagautdinov.beans.controllers")
public class AppConfig {}

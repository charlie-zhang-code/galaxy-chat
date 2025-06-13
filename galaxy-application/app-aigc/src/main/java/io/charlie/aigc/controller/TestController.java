package io.charlie.aigc.controller;

import dev.langchain4j.model.ollama.OllamaChatModel;
import io.charlie.aigc.config.Assistant;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 10/06/2025
 * @description TODO
 */
@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {
    private final OllamaChatModel ollamaChatModel;
    private final Assistant assistant; // 注入Assistant

    @GetMapping("/ollama")
    public String ollama(@RequestParam String question) {
        return ollamaChatModel.chat(question);
    }

    @GetMapping(value = "/ollama-streaming", produces = "text/event-stream")
    public Flux<String> ollamaStreaming(@RequestParam String question) {
        return assistant.chat(1, question);
    }
}

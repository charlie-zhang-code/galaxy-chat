package io.charlie.aigc.config;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.UserMessage;
import reactor.core.publisher.Flux;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 12/06/2025
 * @description TODO
 */
public interface Assistant {

    Flux<String> chat(@MemoryId int memoryId, @UserMessage String userMessage);

}

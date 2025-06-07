package io.github.charlie.base;

import lombok.Data;

/**
 * @author Charlie Zhang
 * @version v1.0
 * @date 29/05/2025
 * @description 基础文件信息类
 */
@Data
public class BaseFileInfo {
    private String fileName;
    private String fileUrl;
    private String fileType;
    private Long fileSize;
}
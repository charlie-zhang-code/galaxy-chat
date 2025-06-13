# 🌌 Galaxy · Chat - 多模态智能对话平台

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](./LICENSE)
[![Java](https://img.shields.io/badge/JDK-17+-red?logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.1.5-brightgreen?logo=spring)](https://spring.io/projects/spring-boot)
[![Spring AI](https://img.shields.io/badge/Spring%20AI-1.0.0-blue)](https://spring.io/projects/spring-ai)
[![LangChain](https://img.shields.io/badge/LangChain-0.1.0-orange?logo=python)](https://python.langchain.com/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue?logo=mysql)](https://www.mysql.com/)
[![Redis](https://img.shields.io/badge/Redis-7.0+-red?logo=redis)](https://redis.io/)

> 目前在开发中，欢迎提issue和PR。

基于AI大模型的聚合多模态对话平台，整合多种大语言模型能力，支持NoSQL数据库存储和AI知识库构建。

## ✨ 特性

- **多模型支持**：集成DeepSeek Qwen3等主流大语言模型
- **统一API**：通过Spring AI提供的统一接口调用不同模型
- **对话链**：利用LangChain实现复杂对话流程和记忆管理
- **知识库**：支持向量数据库存储和检索(RAG架构)
- **可扩展**：模块化设计，轻松添加新模型和功能
- **多场景支持**：支持知识库问答、知识库检索、知识库问答、知识库问答等场景
- **会话管理**：支持会话管理，用户信息存储

## 🛠 技术栈与版本要求

| 技术              | 版本要求   | 用途说明     |
|-----------------|--------|----------|
| **JDK**         | 21+    |          |
| **Spring Boot** | 3.2.x  | 基础框架     |
| **Spring AI**   | 1.0.0  | 统一AI接口   |
| **LangChain**   | 0.1.0  | 对话链和工具集成 |
| **MySQL**       | 8.0+   | 结构化数据存储  |
| **Redis**       | 7.0+   | 缓存和会话管理  |
| **MongoDB**     | 6.0+   | 非结构化数据存储 |
| **Docker**      | 20.10+ | 容器化部署    |

## � 快速开始

### 前提条件

- JDK 21+
- Maven
- MongoDB
- Redis

📜 许可证

MIT © 2025 Galaxy·Chat
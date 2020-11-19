# dddbook
领域驱动设计Demo
[参考文章](https://yq.aliyun.com/articles/719251?utm_content=g_1000078181)

### 各个模块
#### Type
Type 模块可以保存对外暴露的 Domain Primitive，因为 Domain Primitive 包含无状态的逻辑，可以对外暴露，所以经常包含在对外暴露的API接口中

#### Domain
Domain 模块是核心业务逻辑模块，包含有状态的 Entity、Domain Service 、以及各种外部依赖的接口类（如 Repository\ACL\中间件）
注意这里仅仅是包含外部依赖的接口类，具体实现不在这里
#### Application 
Application 模块主要包含 Application Service 和一些相关的类，依赖 Domain 模块，不依赖任何框架
#### Infrastructure
Infrastructure 模块包含了 Persistence\Messaging\External 等模块，是外部依赖的具体实现的各个模块

#### Web 
具体的web接口，比如Spring mvc

#### start
Spring boot 启动类
#### 概念

- DO 领域对象 - domain object
    - 从现实世界中抽象出来的有形或无形的业务实体
    
- VO 视图对象 - view object
    - 用于展示层
    - 它的作用是把某个指定页面（或组件）的所有数据封装起来。
    
- DTO 数据传输对象 - data transfer object
    - 这个概念来源于 J2EE 的设计模式，原来的目的是为了 EJB 的分布式应用提供粗粒度的数据实体，以减少分布式调用的次数，从而提高分布式调用的性能和降低网络负载。
    - 但在这里，我泛指用于`展示层`与`服务层`之间的数据传输对象。
    
- PO 持久化对象 - persistent object
    - 它跟持久层（通常是关系型数据库）的数据结构形成一一对应的映射关系，如果持久层是关系型数据库，那么，数据表中的每个字段（或若干个）就对应PO的一个（或若干个）属性。
    
#### VO 与 DTO 的区别

- 服务层只负责业务，与具体的表现形式无关，因此，它返回的 DTO，不应该出现与表现形式的耦合。
- VO 负责展示，这里各种终端，不同门户有不同展示需求，比如: 男/女/未指定 or 帅哥/美女/秘密
    
#### VO 与 DTO 的应用

- VO 和 DTO 合二为一
    - 当需求非常清晰稳定，而且客户端很明确只有一个的时候，没有必要把VO和DTO区分开来。
    - 如果客户端能够用某种技术（脚本或其他机制）实现转换，同样可以让 VO 退隐。
- VO 和 DTO 并存
    - 如果页面出现一个“大视图”，而组成这个大视图的所有数据需要调用多个服务，返回多个DTO来组装。
        
#### DTO 与 DO 的区别
    
首先是概念上的区别，DTO 是展示层和服务层之间的数据传输对象，而 DO 是对现实世界各种业务角色的抽象，这就引出了两者在数据上的区别，例如 UserInfo 和 User，对于一个 getUser 方法来说，本质上它永远不应该返回用户的密码，
因此 UserInfo 至少比 User 少一个 password 的数据。而在领域驱动设计中，正如第一篇系列文章所说，DO 不是简单的 POJO，它具有领域业务逻辑。
    
#### DTO 与 DO 的应用

对于 DO 来说，还有一点需要说明：为什么不在服务层中直接返回 DO 呢？这样可以省去 DTO 的编码和转换工作，原因如下：

- 两者在本质上的区别可能导致彼此并不一一对应，一个 DTO 可能对应多个 DO，反之亦然
- DO 具有一些不应该让展示层知道的数据

对于 DTO 来说，也有一点必须进行说明:
- DTO 应该是一个“扁平的二维对象”

举个例子来说明：如果User会关联若干个其他实体（例如Address、Account、Region等），那么getUser()返回的UserInfo，是否就需要把其关联的对象的DTO都一并返回呢？如果这样的话，必然导致数据传输量的大增，对于分布式应用来说，由于涉及数据在网络上的传输、序列化和反序列化，这种设计更不可接受。如果getUser除了要返回User的基本信息外，还需要返回一个AccountId、AccountName、RegionId、RegionName，那么，请把这些属性定义到UserInfo中，把一个“立体”的对象树“压扁”成一个“扁平的二维对象”.
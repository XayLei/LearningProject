### 关于数据落地 ###

**落地数据**：就是被持久化的数据，这种数据一般放在硬盘或是其他的持久化存储设备里，例如：图片、系统日志、在页面上显示的数据以及保存在关系数据库里的数据等等，落地数据一定会有一个固定的载体，他们不会瞬时消失的。

**不落地数据**：一般指存储在内存或者是网络传输里的数据，这些数据是瞬时，使用完毕就会消失，例如：我们在浏览器发送给服务器的请求；从数据库读取出来的一直到页面展示前的数据等等。
“不落地”传输能够满足用户在性能上的要求。

使用SQL数据库还是NOSQL数据库，非关系型数据库对事物的支持不好，追求高性能，高可用和分布式存储。所以选择具有良好事物机制的关系型数据库

在MySQL数据库中建立了一个seckill数据库，这个库中有两张表，一个是seckill表，存储秒杀项目
另一个是successkill表，存储成功秒杀的对象。

在entity包中对应每个表建一个实体类，实体类中的属性就是表中的字段，在successkill类中多了一个seckill属性。

DAO层关注的是对数据库的操作，DAO层中写了两个接口

基于mybatis实现DAO

DAO实现原理
![](http://img.mukewang.com/591991100001bfff12800720.jpg)

需要解决两个问题，SQL语句写在哪？如何实现DAO接口

SQL写在XML文件中，通过Mapper机制来实现DAO接口

首先创建一个mybatis全局配置文件mybatis-config.xml，再创建一个mapper文件夹，用于存放映射配置文件

配置完mybatis的全局配置后，就要关注如何实现DAO接口

创建映射配置文件，数据库中的每个表对应entity中的一个类，那么这里的映射文件名要与DAO中的接口名相同。即DAO中有一个SeckillDao,则映射配置文件就有一个SeckillDao.xml文件。

映射配置文件中的每条SQL对应DAO层接口中的一个方法，Id是接口方法名，resultType就是接口方法的返回类型，返回类型如果是集合，则类型为集合中元素的类型。parameterType是接口方法中的参数类型，只有查询语句才会用到，查询标签中也不用特意声明，mybatis会自动识别。

接下来就是spring与mybatis的整合

在resources文件夹中创建spring文件夹，用于存放spring配置文件，创建spring-dao.xml，用于存放spring所有与DAO层相关的配置。

在spring-dao.xml中配置整合mybatis过程：

1:配置数据库相关参数properties的属性：${url} 

2:数据库连接池

3:配置SqlSessionFactory对象

4:配置扫描Dao接口包，动态实现Dao接口，注入到spring容器中

classpath在maven项目中就是main下的Java目录和resource目录 

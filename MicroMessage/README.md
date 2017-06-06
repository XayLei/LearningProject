## 这个项目用于学习mybatis框架 ##


MessageDao.java中的36行：

    messageList = sqlSession.selectList("Message.queryMessageList",message);

Mybatis中的接口试编程即mybatis找到一个接口作为该表操作的代言：

1、namespace 

2、与sql关联的id

3、传入的参数

4、返回值

作用：1、规范mybatis中访问配置文/

2、遇到spring时{

1、总配置文件中的数据源配置托管给spring管理

2、db层（getsqlsession）会消失

3、组织对象代码移交给service层（即传入的参数）

4、sql执行代码由spring实现

5、dao层就剩接口文件（小三上位）与配置文件}

这四种潜在风险（即编译无法判断是否对应或正确），需要使用接口式编程来避免风险。
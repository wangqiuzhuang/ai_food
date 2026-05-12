项目名称：ai_food  
项目作用：sw项目后端  
语言：Java + dart  
技术栈： spring + springMVC + springBoot + springCloud + mysql + redis + junit + 代码覆盖率工具jicoco + 自动化工具
# 接口文档：   
# redis  
- 查看redis进程 brew services list | grep redis
- 启动redis  redis-server
- 命令行界面 redis-cli ping

## 注册：
- url: https://localhost:8081/swUser/register  
- input：{
  "userName": "jack",
  "password": "123456"
  }
- output：{
	"sysCode": "0000",
	"sysMessage": "操作成功",
	"data": "注册成功"
}
## 登录：  
- url:https://localhost:8081/swUser/login  
  input:{
    "userId":1,
  "userName": "jack",
  "password": "123456"
}  
output: {
	"sysCode": "0000",
	"sysMessage": "操作成功",
	"data": "LOGIN_TOKEN:719e7f5b-d5c2-4d41-8c43-b14863207463"
}  
## 登出  
- url: https://localhost:8081/swUser/logout  
- header中加Authorization字段	25312817-06a4-4517-acae-ddd4051c3b33  
- {
	"sysCode": "0000",
	"sysMessage": "操作成功",
	"data": "登出成功"
}


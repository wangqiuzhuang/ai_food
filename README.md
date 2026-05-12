项目名称：ai_food  
项目作用：sw项目后端  
语言：Java + dart  
技术栈： spring + springMVC + springBoot + springCloud + mysql + redis  
# 接口文档：   
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

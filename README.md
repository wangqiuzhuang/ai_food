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
##  根据商户id查询餐食列表  
- url: https://localhost:8081/swFood/findFoodByMerchantId/1  
- output: {
	"sysCode": "0000",
	"sysMessage": "操作成功",
	"data": [
		{
			"foodId": 1,
			"merchantId": 1,
			"foodName": "burger",
			"price": 18.32,
			"stock": 10,
			"status": 1,
			"foodImg": "",
			"createTime": "2026-05-12T14:06:37",
			"updateTime": "2026-05-12T14:06:37",
			"jpaVersion": 0
		}
	]
}
##  查询全部商户列表
- url: https://localhost:8081/swMerchant/list  
- output: {
	"sysCode": "0000",
	"sysMessage": "操作成功",
	"data": [
		{
			"merchantId": 1,
			"merchantName": "川菜馆",
			"phone": "01080588126",
			"address": "uijeong",
			"status": 1,
			"merchantImg": "",
			"createTime": "2026-05-12T14:14:41",
			"updateTime": "2026-05-12T14:16:05",
			"jpaVersion": 0
		},
		{
			"merchantId": 3,
			"merchantName": "湘菜馆",
			"phone": "01080588126",
			"address": "uijeong",
			"status": 1,
			"merchantImg": "",
			"createTime": "2026-05-12T14:16:05",
			"updateTime": "2026-05-12T14:16:05",
			"jpaVersion": 0
		}
	]
} 
##  查询用户下的购物车详情  
- url:https://localhost:8081/swCart/1
- output:{
	"sysCode": "0000",
	"sysMessage": "操作成功",
	"data": [
		{
			"cartId": 1,
			"userId": 1,
			"merchantId": 1,
			"foodId": 1,
			"foodNum": 1,
			"foodPrice": 18.32,
			"foodImg": "",
			"foodName": "水煮肉",
			"selected": 1,
			"jpaVersion": 0,
			"createTime": "2026-05-12T14:25:15",
			"updateTime": "2026-05-12T14:25:15"
		}
	]
}

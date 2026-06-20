项目名称：ai_food  
项目作用：sw项目后端   
访问地址： http://15.165.195.197/ 
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
##  查询全部商户列表（首页默认查询全部商户列表）
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
## 根据商户名称查询商户信息（首页搜索框支持检索上餐品和商户信息）
- URL：https://localhost:8081/swMerchant/merchantName?merchantName=湘菜馆  
- output：{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": [
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
## 根据餐食id查询餐食详情
- URL：https://localhost:8081/swFood/findFoodByFoodId/1
- output：{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": {
  "foodId": 1,
  "merchantId": 1,
  "foodName": "水煮肉",
  "price": 18.32,
  "stock": 10,
  "status": 1,
  "foodImg": "",
  "createTime": "2026-05-12T14:06:37",
  "updateTime": "2026-05-12T14:24:41",
  "jpaVersion": 0
  }
  }  
## 加购物车  
- url:https://localhost:8081/swCart/addCart  
- input:{
  "userId":1,
  "foodId":1,
  "merchantId":1,
  "foodNum":2,
  "foodPrice":18.32,
  "foodName":"水煮肉片"
  }  
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": "加购物车成功"
  }  
## 删除购物车  
- url: https://localhost:8081/swCart/delete/1  
- input:https://localhost:8081/swCart/delete/1  
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": "删除成功"
  } 
## 根据用户id查询购物车内容
- url:https://localhost:8081/swCart/findByUserId/1
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": [
  {
  "cartId": 2,
  "userId": 1,
  "merchantId": 1,
  "foodId": 1,
  "foodNum": 2,
  "foodPrice": 18.32,
  "foodImg": "",
  "foodName": "水煮肉片",
  "selected": 1,
  "jpaVersion": 0,
  "createTime": "2026-05-12T15:42:15",
  "updateTime": "2026-05-12T15:42:15"
  }
  ]
  }
##  查询客户下所有订单
- url:https://localhost:8081/swOrder/findByUserId/1
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": [
  {
  "orderId": 1,
  "orderNo": "111",
  "userId": 1,
  "merchantId": 1,
  "addressId": 0,
  "totalPrice": 100,
  "orderStatus": 0,
  "createTime": "2026-05-12T23:57:09",
  "updateTime": "2026-05-12T23:57:09",
  "jpaVersion": 0
  },
  {
  "orderId": 3,
  "orderNo": "222",
  "userId": 1,
  "merchantId": 1,
  "addressId": 0,
  "totalPrice": 100,
  "orderStatus": 0,
  "createTime": "2026-05-12T23:59:07",
  "updateTime": "2026-05-12T23:59:07",
  "jpaVersion": 0
  }
  ]
  }
## 提交订单
- url:https://localhost:8081/swOrder/save/
- input:{
  "orderNo":"111",
  "userId":1,
  "merchantId":1,
  "addressId":0,
  "totalPrice":100,
  "orderStatus":0
  }
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": "提交成功"
  }
## 删除订单
- url:https://localhost:8081/swOrder/delete/1
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": "删除成功"
  }
## 查询客户下所有订单
- url:https://localhost:8081/swOrder/findByUserId/1
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": [
  {
  "orderId": 3,
  "orderNo": "222",
  "userId": 1,
  "merchantId": 1,
  "addressId": 0,
  "totalPrice": 100,
  "orderStatus": 0,
  "createTime": "2026-05-12T23:59:07",
  "updateTime": "2026-05-12T23:59:07",
  "jpaVersion": 0
  }
  ]
  }
## 根据订单id查询订单详情
- url:https://localhost:8081/swOrderItem/findOrderItemByOrderId/222
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": []
  }
## 删除评价
- URL：https://localhost:8081/swComments/delete/1
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": "评价删除成功"
  }
## 新增评价
- url:https://localhost:8081/swComments/save/
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": "评价成功"
  }
## 查询指定用户发表的全部评价
- url:https://localhost:8081/swComments/queryCommentsByUserId/1
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": [
  {
  "commentId": 1,
  "foodId": "1",
  "userId": 1,
  "merchantId": 1,
  "commentMsg": "very good...",
  "start": 2.5,
  "createTime": "2026-05-13T00:29:32",
  "updateTime": "2026-05-13T00:29:32",
  "jpaVersion": 0
  }
  ]
  }
## 查询指定商户下指定商品的的全部评价
- url:https://localhost:8081/swComments/queryCommentsByFoodIdAndMerchantId/1/1/
- output:{
  "sysCode": "0000",
  "sysMessage": "操作成功",
  "data": [
  {
  "commentId": 1,
  "foodId": "1",
  "userId": 1,
  "merchantId": 1,
  "commentMsg": "very good...",
  "start": 2.5,
  "createTime": "2026-05-13T00:29:32",
  "updateTime": "2026-05-13T00:29:32",
  "jpaVersion": 0
  }
  ]
  }
## TODO
## 筛选功能需要做吗？？？
## 秒杀库存控制
## solr搜索实现
## 支付订单
## 订单状态更新
## 上传图片
## AI落地
## 定时任务
##



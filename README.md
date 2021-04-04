# ToCountOrNot

ToCountOrNot是安卓记账软件 [爱记不记](https://github.com/ThisisKKya/ToCountOrNotApp) 的后端服务器。

## 接口

### User

#### POST user/register

`localhost:8080/user/register`

注册界面：新注册的用户名与密码存入数据库

成功注册
```
{
  "code": 200,
  "message": "success",
  "data": null
}
```

用户名已被占用
```
{
  "code": 400,
  "message": "User name already taken",
  "data": null
}
```

##### Body raw (json)
```
{
  "name": "jerry",
  "password": "I am jerry"
}
```

#### POST user/login

`localhost:8080/user/login`

登录界面：发用户名和密码到数据库，检验是否正确

成功登录，返回token，须附加到后续请求的header中
```
{
  "code": 200,
  "message": "success",
  "data": "********************************"
}

```

用户不存在
```
{
  "code": 400,
  "message": "User does not exist",
  "data": null
}
```

密码错误
```
{
  "code": 400,
  "message": "Wrong password, login failed",
  "data": null
}
```

##### Body raw (json)
```
{
  "name": "jerry",
  "password": "I am jerry"
}
```

### Bill

#### POST bill/insert
`localhost:8080/bill/insert`

新建账单

成功，返回账单id，可用于查找，删除和更新
```
{
  "code": 200,
  "message": "success",
  "data": 1
}
```

无token
```
{
  "code": 401,
  "message": "no token found, please login",
  "data": null
}
```

非法token
```
{
  "code": 500,
  "message": "failed to decode token",
  "data": null
}
```

##### Body raw (json)
```
{
  "first": "出行",
  "second": "打车",
  "price": 25,
  "card": "微信",
  "member": "我",
  "date": "2021-04-01",
  "year": "2021",
  "month": "4",
  "week": "13",
  "type": "out"
}
```

#### GET bill/{id}
`localhost:8080/bill/1`

通过id查找账单

成功
```
{
  "code": 200,
  "message": "success",
  "data": {
    "id": 1,
    "first": "出行",
    "second": "打车",
    "price": 25,
    "card": "微信",
    "member": "我",
    "date": "2021-04-01",
    "year": "2021",
    "month": "4",
    "week": "13",
    "type": "out",
    "uid": 0
  }
}
```

账单不存在
```
{
  "code": 404,
  "message": "Bill does not exist",
  "data": null
}
```

#### PUT bill/update/{id}
`localhost:8080/bill/update/1`

根据id更改账单

成功
```
{
  "code": 200,
  "message": "success",
  "data": null
}
```

账单不存在
```
{
  "code": 404,
  "message": "Bill does not exist",
  "data": null
}
```

##### Body raw (json)
```
{
  "first": "出行",
  "second": "地铁",
  "price": 5,
  "card": "微信",
  "member": "我",
  "date": "2021-04-01",
  "year": "2021",
  "month": "4",
  "week": "13",
  "type": "out"
}
```

#### DEL bill/delete/{id}
`localhost:8080/bill/delete/1`

根据id删除账单

成功
```
{
  "code": 200,
  "message": "success",
  "data": null
}
```

账单不存在
```
{
  "code": 404,
  "message": "Bill does not exist",
  "data": null
}
```

### Card

#### POST card/insert
`localhost:8080/card/insert`

新建账户

成功，返回账单id，可用于查找，更新和删除
```
{
  "code": 200,
  "message": "success",
  "data": 1
}
```

##### Body raw (json)
```
{
  "name": "浦发",
  "note": "浦东发展银行",
  "image": 4,
  "income": 2500,
  "expense": 2000,
  "balance": 500
}
```

#### GET card/{id}
`localhost:8080/card/1`

根据id查找账户

成功
```
{
  "code": 200,
  "message": "success",
  "data": {
    "id": 1,
    "name": "浦发",
    "note": "浦东发展银行",
    "image": 4,
    "income": 2500,
    "expense": 2000,
    "balance": 500,
    "uid": 0
  }
}
```

账户不存在
```
{
  "code": 404,
  "message": "Card does not exist",
  "data": null
}
```

#### PUT card/update/{id}
`localhost:8080/card/update/1`

根据id更新账户

成功
```
{
  "code": 200,
  "message": "success",
  "data": null
}
```

账户不存在
```
{
  "code": 404,
  "message": "Card does not exist",
  "data": null
}
```

##### Body raw (json)
```
{
  "name": "浦发",
  "note": "浦东发展银行",
  "image": 4,
  "income": 5000,
  "expense": 2000,
  "balance": 3000
}
```

#### DEL card/delete/{id}
`localhost:8080/card/delete/1`

根据id删除账户

成功
```
{
  "code": 200,
  "message": "success",
  "data": null
}
```

账户不存在
```
{
  "code": 404,
  "message": "Card does not exist",
  "data": null
}
```

### Flow

#### GET flow/date/{date}
`localhost:8080/flow/date/2021-04-01`

日流水

成功
```
{
  "code": 200,
  "message": "success",
  "data": {
    "date": "2021-04-01",
    "income": "3000.0",
    "expense": "140.0",
    "list": [
      {
        "id": 2,
        "first": "出行",
        "second": "打车",
        "price": 25,
        "card": "微信",
        "member": "我",
        "date": "2021-04-01",
        "year": "2021",
        "month": "4",
        "week": "13",
        "type": "out",
        "uid": 0
      },
      {
        "id": 3,
        "first": "饮食",
        "second": "午餐",
        "price": 15,
        "card": "微信",
        "member": "我",
        "date": "2021-04-01",
        "year": "2021",
        "month": "4",
        "week": "13",
        "type": "out",
        "uid": 0
      },
      {
        "id": 4,
        "first": "日用",
        "second": "购物",
        "price": 100,
        "card": "微信",
        "member": "我",
        "date": "2021-04-01",
        "year": "2021",
        "month": "4",
        "week": "13",
        "type": "out",
        "uid": 0
      },
      {
        "id": 5,
        "first": "工资",
        "second": "实习",
        "price": 3000,
        "card": "微信",
        "member": "我",
        "date": "2021-04-01",
        "year": "2021",
        "month": "4",
        "week": "13",
        "type": "in",
        "uid": 0
      }
    ]
  }
}
```

##### GET flow/week/{year}/{week}
`localhost:8080/flow/week/2021/13`

周流水

成功
```
{
  "code": 200,
  "message": "success",
  "data": {
    "year": "2021",
    "week": "13",
    "income": "3000.0",
    "expense": "140.0",
    "list": [
      {
        "date": "2021-04-01",
        "income": "3000.0",
        "expense": "140.0",
        "list": [
          {
            "id": 2,
            "first": "出行",
            "second": "打车",
            "price": 25,
            "card": "微信",
            "member": "我",
            "date": "2021-04-01",
            "year": "2021",
            "month": "4",
            "week": "13",
            "type": "out",
            "uid": 0
          },
          {
            "id": 3,
            "first": "饮食",
            "second": "午餐",
            "price": 15,
            "card": "微信",
            "member": "我",
            "date": "2021-04-01",
            "year": "2021",
            "month": "4",
            "week": "13",
            "type": "out",
            "uid": 0
          },
          {
            "id": 4,
            "first": "日用",
            "second": "购物",
            "price": 100,
            "card": "微信",
            "member": "我",
            "date": "2021-04-01",
            "year": "2021",
            "month": "4",
            "week": "13",
            "type": "out",
            "uid": 0
          },
          {
            "id": 5,
            "first": "工资",
            "second": "实习",
            "price": 3000,
            "card": "微信",
            "member": "我",
            "date": "2021-04-01",
            "year": "2021",
            "month": "4",
            "week": "13",
            "type": "in",
            "uid": 0
          }
        ]
      }
    ]
  }
}
```

#### GET flow/month/{year}/{month}
`localhost:8080/flow/month/2021/4`

月流水

成功
```
{
  "code": 200,
  "message": "success",
  "data": {
    "year": "2021",
    "month": "4",
    "income": "3000.0",
    "expense": "140.0",
    "list": [
      {
        "date": "2021-04-01",
        "income": "3000.0",
        "expense": "140.0",
        "list": [
          {
            "id": 2,
            "first": "出行",
            "second": "打车",
            "price": 25,
            "card": "微信",
            "member": "我",
            "date": "2021-04-01",
            "year": "2021",
            "month": "4",
            "week": "13",
            "type": "out",
            "uid": 0
          },
          {
            "id": 3,
            "first": "饮食",
            "second": "午餐",
            "price": 15,
            "card": "微信",
            "member": "我",
            "date": "2021-04-01",
            "year": "2021",
            "month": "4",
            "week": "13",
            "type": "out",
            "uid": 0
          },
          {
            "id": 4,
            "first": "日用",
            "second": "购物",
            "price": 100,
            "card": "微信",
            "member": "我",
            "date": "2021-04-01",
            "year": "2021",
            "month": "4",
            "week": "13",
            "type": "out",
            "uid": 0
          },
          {
            "id": 5,
            "first": "工资",
            "second": "实习",
            "price": 3000,
            "card": "微信",
            "member": "我",
            "date": "2021-04-01",
            "year": "2021",
            "month": "4",
            "week": "13",
            "type": "in",
            "uid": 0
          }
        ]
      }
    ]
  }
}
```
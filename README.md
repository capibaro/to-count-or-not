# to-count-or-not

to-count-or-not 是安卓记账软件爱记不记的后端 RESTful Web 服务。

## 依赖

| Dependency | GroupId |
| ---------- | ------- |
| spring-boot-starter-web | org.springframework.boot |
| spring-boot-starter-validation | org.springframework.boot |
| mybatis-spring-boot-starter | org.mybatis.spring.boot |
| mysql-connector-java | mysql |
| java-jwt | com.auth0 |
| lombok | org.projectlombok |

## 接口

### 用户

| Action | Method | URI |
| --- | --- | --- |
| 注册 | POST | user/register |
| 登录 | POST | user/login | 
| 注销 | DELETE | user |
| 修改密码 | PUT | user |

### 账户

| Action | Method | URI |
| --- | --- | --- |
| 新增 | POST | card |
| 删除 | DELETE | card/{id} |
| 修改 | PUT | card/{id} |
| 查找 | GET | card/{id} |
| 全部 | GET | cards |

### 成员

| Action | Method | URI |
| --- | --- | --- |
| 新增 | POST | member |
| 删除 | DELETE | member/{id} |
| 修改 | PUT  | member/{id} |
| 查找 | GET | member/{id} |
| 全部 | GET | members |

### 一级分类

| Action | Method | URI |
| --- | --- | --- |
| 新增 | POST | division |
| 删除 | DELETE | division/{id} |
| 修改 | PUT | division/{id} |
| 查找 | GET | division/{id} |
| 全部 | GET | divisions |

### 二级分类

| Action | Method | URI |
| --- | --- | --- |
| 新增 | POST | category |
| 删除 | DELETE | category/{id} |
| 修改 | PUT | category/{id} |
| 查找 | GET | category/{id} |
| 全部 | GET | categories/{division} |

### 账单

| Action | Method | URI |
| --- | --- | --- |
| 新增 | POST | bill |
| 删除 | DELETE | bill/{id} |
| 修改 | PUT | bill/{id} |
| 查找 | GET | bill/{id} |

### 流水

| Action | Method | URI |
| --- | --- | --- |
| 月流水 | GET | flow/month/{year}/{month} |
| 日流水 | GET | flow/day/{year}/{month}/{day} |

### 收入

| Action | Method | URI |
| --- | --- | --- |
| 按账户统计 | GET | income/cards/{year}/{month} |
| 按成员统计 | GET | income/members/{year}/{month} |
| 按一级分类统计 | GET | income/divisions/{year}/{month} |
| 按二级分类统计 | GET | income/categories/{division}/{year}/{month} |

### 支出

| Action | Method | URI |
| --- | --- | --- |
| 按账户统计 | GET | expense/cards/{year}/{month} |
| 按成员分类统计 | GET | expense/members/{year}/{month} |
| 按一级分类统计 | GET | expense/divisions/{year}/{month} |
| 按二级分类统计 | GET | expense/categories/{division}/{year}/{month} |

## 文档

- [用户](https://github.com/capibaro/to-count-or-not/blob/master/docs/user.md)
- [账户](https://github.com/capibaro/to-count-or-not/blob/master/docs/card.md)
- [成员](https://github.com/capibaro/to-count-or-not/blob/master/docs/member.md)
- [一级分类](https://github.com/capibaro/to-count-or-not/blob/master/docs/division.md)
- [二级分类](https://github.com/capibaro/to-count-or-not/blob/master/docs/category.md)
- [账单](https://github.com/capibaro/to-count-or-not/blob/master/docs/bill.md)
- [流水](https://github.com/capibaro/to-count-or-not/blob/master/docs/flow.md)
- [收支](https://github.com/capibaro/to-count-or-not/blob/master/docs/balance.md)

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

[接口文档](https://capibaro.github.io/2021/05/03/tocountornot-user)

### 账户

| Action | Method | URI |
| --- | --- | --- |
| 新增 | POST | card |
| 删除 | DELETE | card/{id} |
| 修改 | PUT | card/{id} |
| 查找 | GET | card/{id} |
| 全部 | GET | cards |

[接口文档](https://capibaro.github.io/2021/05/03/tocountornot-card)

### 成员

| Action | Method | URI |
| --- | --- | --- |
| 新增 | POST | member |
| 删除 | DELETE | member/{id} |
| 修改 | PUT  | member/{id} |
| 查找 | GET | member/{id} |
| 全部 | GET | members |

[接口文档](https://capibaro.github.io/2021/05/03/tocountornot-member)

### 一级分类

| Action | Method | URI |
| --- | --- | --- |
| 新增 | POST | division |
| 删除 | DELETE | division/{id} |
| 修改 | PUT | division/{id} |
| 查找 | GET | division/{id} |
| 全部 | GET | divisions |

[接口文档](https://capibaro.github.io/2021/05/03/tocountornot-division)

### 二级分类

| Action | Method | URI |
| --- | --- | --- |
| 新增 | POST | category |
| 删除 | DELETE | category/{id} |
| 修改 | PUT | category/{id} |
| 查找 | GET | category/{id} |
| 全部 | GET | categories/{division} |

[接口文档](https://capibaro.github.io/2021/05/03/tocountornot-category)

### 账单

| Action | Method | URI |
| --- | --- | --- |
| 新增 | POST | bill |
| 删除 | DELETE | bill/{id} |
| 修改 | PUT | bill/{id} |
| 查找 | GET | bill/{id} |

[接口文档](https://capibaro.github.io/2021/05/03/tocountornot-bill)

### 流水

| Action | Method | URI |
| --- | --- | --- |
| 月流水 | GET | flow/month/{year}/{month} |
| 日流水 | GET | flow/day/{year}/{month}/{day} |

[接口文档](https://capibaro.github.io/2021/05/03/tocountornot-flow)

### 收入

| Action | Method | URI |
| --- | --- | --- |
| 按账户统计 | GET | income/cards/{year}/{month} |
| 按成员统计 | GET | income/members/{year}/{month} |
| 按一级分类统计 | GET | income/divisions/{year}/{month} |
| 按二级分类统计 | GET | income/categories/{division}/{year}/{month} |

[接口文档](https://capibaro.github.io/2021/05/03/tocountornot-balance)

### 支出

| Action | Method | URI |
| --- | --- | --- |
| 按账户统计 | GET | expense/cards/{year}/{month} |
| 按成员分类统计 | GET | expense/members/{year}/{month} |
| 按一级分类统计 | GET | expense/divisions/{year}/{month} |
| 按二级分类统计 | GET | expense/categories/{division}/{year}/{month} |

[接口文档](https://capibaro.github.io/2021/05/03/tocountornot-balance)
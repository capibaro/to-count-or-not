# to-count-or-not

to-count-or-not 是安卓记账软件爱记不记的后端RESTful Web服务。

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

完整接口文档参见 [to-count-or-not](https://maotouyingxia.github.io//tocountornot//docs)

### User

#### 注册

##### POST /user/register

#### 登录

##### POST /user/login

#### 修改密码

##### PUT /user

#### 删除用户

##### DELETE /user

### Card

#### 新增账户

##### POST /card

#### 修改账户

##### PUT /card/{id}

#### 删除账户

##### DELETE card/{id}

#### 查找账户

##### GET card/{id}

#### 所有账户

##### GET /cards

### Member

#### 新增成员

##### POST /member

#### 修改成员

##### PUT /member/{id}

#### 删除成员

##### DELETE /member/{id}

#### 查找成员

#####  GET /member/{id}

#### 所有成员

##### GET /members

### Division

#### 新增一级分类

##### POST /division

#### 修改一级分类

###### PUT /division/{id}

#### 删除一级分类

##### DELETE /division/{id}

#### 查找一级分类

##### GET /division/{id}

#### 所有一级分类

##### GET /divisions

### Category

#### 新增二级分类

##### POST /category

#### 修改二级分类

##### PUT /category/{id}

#### 删除二级分类

##### DELETE /category/{id}

#### 查找二级分类

##### GET /category/{id}

#### 所有二级分类

##### GET /categories/{division}

### Bill

#### 新增账单

##### POST /bill

#### 修改账单

##### PUT /bill/{id}

#### 删除账单

##### DELETE /bill/{id}

#### 查找账单

##### GET /bill/{id}

### Flow

#### 月流水

##### GET /flow/month/{year}/{month}

#### 日流水

##### GET /flow/day/{year}/{month}/{day}

### Income

#### 按账户分类统计收入

##### GET /income/cards/{year}/{month}

#### 按成员分类统计收入

##### GET /income/members/{year}/{month}

#### 按一级分类分类统计收入

##### GET /income/divisions/{year}/{month}

#### 按二级分类分类统计收入

##### GET /income/categories/{division}/{year}/{month}

### Expense

#### 按账户分类统计支出

##### GET /expense/cards/{year}/{month}

#### 按成员分类统计支出

##### GET /expense/members/{year}/{month}

#### 按一级分类分类统计支出

##### GET /expense/divisions/{year}/{month}

#### 按二级分类分类统计支出

##### GET /expense/categories/{division}/{year}/{month}
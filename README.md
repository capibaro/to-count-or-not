# ToCountOrNot

ToCountOrNot是安卓记账软件 [爱记不记](https://github.com/ThisisKKya/ToCountOrNotApp) 的后端服务器。

| Dependency | GroupId |
| ---------- | ------- |
| spring-boot-starter-web | org.springframework.boot |
| mybatis-spring-boot-starter | org.mybatis.spring.boot |
| mysql-connector-java | mysql |
| spring-boot-starter | org.springframework.boot |
| spring-boot-starter-test | org.springframework.boot |
| lombok | org.projectlombok |
| java-jwt | com.auth0 |

## 接口

### User

#### POST user/register

新注册的用户名与密码存入数据库

#### POST user/login

发用户名和密码到数据库，检验是否正确

成功登录，返回token，须附加到后续请求的header中

### Bill

#### POST bill/insert

新建账单

#### GET bill/{id}

通过id查找账单

#### PUT bill/update/{id}

根据id更改账单

#### DEL bill/delete/{id}

根据id删除账单

### Card

#### POST card/insert

新建账户

#### GET card/{id}

根据id查找账户

#### PUT card/update/{id}

根据id更新账户

#### DEL card/delete/{id}

根据id删除账户

### Flow

#### GET flow/date/{date}

日流水

##### GET flow/week/{year}/{week}

周流水

#### GET flow/month/{year}/{month}

月流水

### Stat

#### GET stat/first/year/{year}/{type}

按年统计一级分类收入支出

#### GET stat/first/month/{year}/{month}/{type}

按月统计一级分类收入支出

#### GET stat/first/week/{year}/{week}/{type}

按周统计一级分类收入支出

#### GET stat/first/date/{date}/{type}

按天统计一级分类收入支出

#### GET stat/second/year/{year}/{type}/{first}

按年、一级分类统计二级分类收入支出

#### GET stat/second/month/{year}/{month}/{type}/{first}

按月、一级分类统计二级分类收入支出

#### GET stat/second/week/{year}/{week}/{type}/{first}

按周、一级分类统计二级分类收入支出

#### GET stat/second/date/{date}/{type}/{first}

按天、一级分类统计二级分类收入支出

#### GET stat/member/year/{year}/{type}

按年、成员统计收入支出

#### GET stat/member/month/{year}/{month}/{type}

按月、成员统计收入支出

#### GET stat/member/week/{year}/{week}/{type}

按周、成员统计收入支出

#### GET stat/member/date/{date}/{type}

按天、成员统计收入支出
# springboot-oauth2

Spring Boot Oauth2.0

# 测试

## 1.运行工程

## 2.无token时，访问接口：

POST 

http://localhost:8080/bar 

接口响应：

```javascript
{
    "error": "unauthorized",
    "error_description": "Full authentication is required to access this resource"
}
```

## 3.获取token

POST:

http://localhost:8080/oauth/token

Headers:

Authorization : Basic dGVzdDoxMjM0NTY=

form-data:

grant_type : password
username : test-user2
password : 123452

响应:

```javascript
{
    "access_token": "7f787f49-c78f-4d6c-9292-e6992b292ec0",
    "token_type": "bearer",
    "refresh_token": "05e1b86f-fc69-4abf-95a1-107616d1572b",
    "expires_in": 9999,
    "scope": "read write"
}
```

## 3.使用token，再次访问接口：

POST：

http://localhost:8080/bar 

Headers:

Authorization : bearer 7f787f49-c78f-4d6c-9292-e6992b292ec0

接口响应：

```javascript
test-user2:123452
```
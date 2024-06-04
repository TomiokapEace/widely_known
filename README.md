# 启动项目

- 所需环境：NodeJs、Vue、maven、JDK11、MySQL、VSCode、tomcat
- 建议安装：Git（代码管理）、Navicat或者dBeaver（数据库管理），VSCode可以使用MYSQL插件

备注：
nodejs版本v16.20.2 JDK11
以上环境在设置环境变量时需要将文件夹权限全部打开，以免遇到麻烦。教程网上都比较全。

## 前端

项目[widely_data](https://github.com/TomiokapEace/widely_data)

请确保安装配置好了NodeJs环境，并在`widely_data`文件夹下输入`npm install`命令，安装所需依赖，随后运行`npm run dev`命令，启动前端。

若终端出现以下信息，并且能在浏览器中成功显示[http://localhost:8080/](http://localhost:8000/)页面，说明前端启动成功

![pic1](readme_pic/pic1.jpg)

## 后端

请确保安装配置好了NodeJs、Vue、maven、JDK11、MySQL、tomcat、idea

1. 配置数据库

powershell运行`widely_known`文件夹下的.sql文件，直接建表，通过数据库管理软件查看数据库。应当有这些数据表（三个），且每个数据表中都应有相关数据。

![pic2](readme_pic/pic2.jpg)

2. 加载所需依赖、启动后端服务

依赖已上传，环境配置无误后，项目可在idea中直接运行。终端出现以下图片说明后端开始运行。

![pic3](readme_pic/pic3.jpg)

## 验证

另建终端运行前端。

未运行前端的话，重新进入到`widely_data`文件夹下运行`npm run dev`启动前端。

此时可以返回前端的网页，随便点点看看是否能够操作成功。

默认管理员用户名同密码：admin

点击登录后出现首页
![Alt text](readme_pic/%E9%A6%96%E9%A1%B5.jpg)

## 项目架构

![Alt text](readme_pic/%E6%9E%B6%E6%9E%84%E5%9B%BE.jpg)

## 系统功能设计

![Alt text](readme_pic/%E7%B3%BB%E7%BB%9F%E5%8A%9F%E8%83%BD%E8%AE%BE%E8%AE%A1.jpg)

## 数据库连接池

内嵌的Tomcat作为Servlet容器
![Alt text](readme_pic/%E6%95%B0%E6%8D%AE%E5%BA%93%E8%BF%9E%E6%8E%A5%E6%B1%A0.jpg)

## 数据库表设计

![Alt text](readme_pic/%E8%A1%A8%E6%A0%BC%E7%9A%84%E7%89%A9%E7%90%86%E8%AE%BE%E8%AE%A11.jpg)
![Alt text](readme_pic/%E8%A1%A8%E6%A0%BC%E7%9A%84%E7%89%A9%E7%90%86%E8%AE%BE%E8%AE%A12.jpg)
![Alt text](readme_pic/%E8%A1%A8%E6%A0%BC%E7%9A%84%E7%89%A9%E7%90%86%E8%AE%BE%E8%AE%A13.jpg)

## 展望

系统可朝着工程性项目发展，增强数据增加的安全性。
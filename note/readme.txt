--1.技术实现：java、SpringBoot、MyBatis、MySQL、正则表达式

--2、数据库
库名：uav
账号：root 密码：123456
程序配置文件：application.yml
username: root
password: 123456
driver-class-name: com.mysql.jdbc.Driver
url: jdbc:mysql://localhost:3306/uav
type: com.alibaba.druid.pool.DruidDataSource

另外附上表sql脚本

--3.运行
方案1——IDEA导入工程启动com.chinasoftinternational.uav.UavApplication.java（springboot启动器）
方案2——java -jar uav-0.0.1-SNAPSHOT.jar 直接命令运行jar包启动

--4.测试用例以及页面返回值（说明：页面发请求）

http://localhost:8080/getCoordinateInfo?signalIndex=0&textContext=plane1 1 1 1
返回：plane1 0 1 1 1

http://localhost:8080/getCoordinateInfo?signalIndex=1&textContext=plane1 1 1 1 1 2 3
返回：plane1 1 2 3 4

http://localhost:8080/getCoordinateInfo?signalIndex=2&textContext=Plane1 2 3 4 1 1 1
返回：Plane1 2 3 4 5

http://localhost:8080/getCoordinateInfo?signalIndex=3&textContext=Plane1 3 4 5
返回：error3

http://localhost:8080/getCoordinateInfo?signalIndex=4&textContext=plane1 1 1 1 1 2 3
返回：Cannot find 4
![result](http://25.io/mou/Mou_128.png)

###如何运行单元测试
本单元测试运用junit4框架，在eclipse中运行，打包在test包中，有4个单项测试类和一个打包测试类

####单项测试类
修改Parameters下的Collection data然后在junit中运行即可
* GenerateSummaryTest.java
    *  input：格式化字符串，如"2016-06-02 20:00~22:00 7"
    *  output：期望的字符串输出，如"2016-06-02 20:00~22:00 +210 -240 -30"


* GetWeekTest.java
    *  date：格式化日期字符串，如"2016-06-02"
    *  week：期望的星期数字符串输出，如"星期四"


* GetFeeTest.java
    *  week：星期数字符串，如"星期四"
    *  begin：开始时间，如9
    *  end： 结束时间，如10
    *  fee：期望的费用输出，如40


* GetGroundNumTest.java
    *  num：人数，如10
    *  g_num：期望的场地数输出，如2
    
####打包测试类
即SuiteTest.java,在@Suite.SuiteClasses({})中加入想打包的测试类然后在junit中运行即可

###如何运行代码
将Main.java运行后在控制台输入格式化的输入字符串，回车换行后输入下一行，全部输入完成后两次回车即可看到结果


###有问题反馈
在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流

* 邮件：liuxin9503@126.com
* QQ：  735079509
* 手机：18380217357

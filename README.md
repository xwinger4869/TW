![result](http://25.io/mou/Mou_128.png)

###如何运行单元测试
本单元测试运用junit4框架，在eclipse中运行，测试类名为MainTest.java，共测试4项方法

* testGenerateSummary()
    *  input：格式化字符串，如"2016-06-02 20:00~22:00 7"
    *  expected：期望的字符串输出，如"2016-06-02 20:00~22:00 +210 -240 -30"


* testGetWeek()
    *  date：格式化日期字符串，如"2016-06-02"
    *  expected：期望的星期数字符串输出，如"星期四"


* testGetFee()
    *  week：星期数字符串，如"星期四"
    *  begin：开始时间，如9
    *  end： 结束时间，如10
    *  expected：期望的费用输出，如40


* testGetGroundNum()
    *  num：人数，如10
    *  expected：期望的场地数输出，如2

###如何运行代码
将Main.java运行后在控制台输入格式化的输入字符串，回车换行后输入下一行，全部输入完成后两次回车即可看到结果


###有问题反馈
在使用中有任何问题，欢迎反馈给我，可以用以下联系方式跟我交流

* 邮件：liuxin9503@126.com
* QQ：  735079509
* 手机：18380217357

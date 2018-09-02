import requests
import re
from application import *
from common.InterfaceRequest import *

from logs.Log import Log


class InterfaceTest:
    def testRequest(self,uri,params,reqform,dataform,checkpoint,i,sheet,num,name,log):
    # def testRequest(self,uri):
        headers = headersJson
        # 引用请求方法
        request = InterfaceRequest()
        # 拼接url和path
        fullUrl = url + uri
        if (reqform == "GET"):
            self.requestTest = request.requestGet(fullUrl,params,headers)
        elif(reqform == "POST" and dataform == 'Form'):
            self.requestTest = request.requestPost(fullUrl,params,headers)
        elif(reqform == 'POST' and dataform == 'Json'):
            self.requestTest = request.jsonPost(fullUrl,params,headers)
        else:
            print("请求失败,请检查case用例配置")
        if(re.search(checkpoint,str(self.requestTest))):
            sheet.cell(row = i,column = 11).value = "pass" #row 是通过遍历case类传递
            sheet.cell(row = i,column = 12).value = str(self.requestTest)
            log.info("测试用例" + str(num) + " " + name + "接口执行成功")
        else:
            sheet.cell(row=i, column=11).value = "fail"  # row 是通过遍历case类传递
            sheet.cell(row=i, column=12).value = str(self.requestTest)
            log.info("测试用例" + str(num) + " " + name + "接口执行失败")

# if __name__ == '__main__':
#     uri='WebTours/login.pl'
#     params='userSession=124264.545240988zDQVifHpftfiDDDDDiDfVpVtfcHf&username=andy&password=123456&login.x=53&login.y=7&login=Login&JSFormSubmit=on'
#     reqform='POST'
#     dataform='Form'
#     checkpoint='bgcolor'
#     i=1
#     sheet='2'
#     num=1
#     name='test1'
#     log = Log('F:\\test.log')
#     x = InterfaceTest()
#     x.testRequest(uri)

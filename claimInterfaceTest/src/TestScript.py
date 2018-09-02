import json

import  mock
import  re
import requests
import datetime
import time



def correMethod(correlation):
    mytime = time.strftime("%Y%m%d%H%M%S", time.localtime())
    url = 'http://127.0.0.1:6688/reg'
    data = 'username=justin' + mytime + "&passwd=123456"
    req = requests.post(url, params=data)
    for i in correlation:
        result = json.loads(req.text)
        print('result=',result)
        res = {}
        # result[i], i
        res[result[i]] = i
        print(res)
        return i


# print (str.replace("is", "wcvas",1))
if __name__ == '__main__':
    correlation = ("msg", "msg_code")
    x = correMethod(correlation)
    # print(x)
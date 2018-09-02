import json
import requests
import time



def correMethod(correlation):
    mytime = time.strftime("%Y%m%d%H%M%S", time.localtime())
    url = 'http://127.0.0.1:6688/reg'
    data = 'username=justin' + mytime + "&passwd=123456"
    req = requests.post(url, params=data)
    for i in correlation:
        result = json.loads(req.text)
        res = {}
        for k in result:
        # result[i], i
            res[k] = result[k]
            # print('res=',res)
        return res


# print (str.replace("is", "wcvas",1))
if __name__ == '__main__':
    correlation = ("msg", "msg_code")
    x = correMethod(correlation)
    print(x['msg'])
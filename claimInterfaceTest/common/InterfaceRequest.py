import requests
import  json

class InterfaceRequest:
    #定义get请求
    print("InterfaceRequest================")
    def requestGet(self,url,params,headers):
        try:
            req = requests.get(url,params=params,headers=headers)
            #转换请求类型
            jsonReq = req.json()
            # print(req.text)
            return jsonReq
        except BaseException as e:
            print("请检测get请求数据:",str(e))
    # 定义post请求
    def requestPost(self,url,data,headers):
        print("-------------+++++++++++++++++")
        try:
            req = requests.post(url,data=data,headers=headers)
            print(data)
            jsonReq = req.json()
            print("-------------",req.text)
            return  jsonReq
        except BaseException as e:
            print("请检测post请求数据:",str(e))

    def jsonPost(self, url, data, headers):
        try:
            data = json.dumps(data)
            req = requests.post(url, data=data, headers=headers)
            jsonReq = req.json()
            # print(req.text)
            return jsonReq
        except BaseException as e:
            print("请检测post请求数据:", str(e))

#
# if __name__ == '__main__':
#     url = "http://v.juhe.cn/laohuangli/d"
#     params = {"key":"e711bc6362b3179f5a28de7fd3ee4ace","date":"2016-5-14"}
#     headers = {}
#
#
#     req = InterfaceRequest()
#     req.requestGet(url, params, headers)
#     req.requestPost(url,params,headers)
#     req.jsonPost(url,params,headers)
#
#
#
#















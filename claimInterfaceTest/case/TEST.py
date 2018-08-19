import requests


class Test():

# jsonReq = req.json()
# print(req.text)
    if __name__ == '__main__':
        url = 'http://127.0.0.1:2080/WebTours/home.html'
        parm = None
        req = requests.get(url,params=parm)
        print(req.text)
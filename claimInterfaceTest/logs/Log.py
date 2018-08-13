import logging
import os


class Log():
    def __init__(self,logFiles):
        self.logger = logging.getLogger("myLogger")
        self.logger.setLevel(logging.INFO)

        # 创建handler,将log写入
        file = logging.FileHandler(logFiles,mode = 'w')
        file.setLevel(logging.INFO)

        # 创建一个handler,将log输出到控制台
        consolePrint = logging.StreamHandler()
        consolePrint.setLevel(logging.INFO)

        # 设置输出格式
        logFormat = "%(asctime)s %(filename)s [line:%(lineno)d] %(levelname)s: %(message)s"
#         添加格式
        formatter = logging.Formatter(logFormat)
        file.setFormatter(formatter)
        consolePrint.setFormatter(formatter)

#         吧handler 添加到logger里
        self.logger.addHandler(file)
        self.logger.addHandler(consolePrint)
    def info(self,content):
        self.logger.info(content)

    def error(self,content):
        self.logger.error(content)
# if __name__ == '__main__':
#     log1 = Log('F:\\test.log')
#     log1.info("测试")
#     log1.error('下雨了')
#     log1.info('打雷了')
#





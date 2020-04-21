import time

start = time.time()
people = 500  # 假设有500个人


def action(num):
    global people
    while people > 0:
        people -= 50  # 每次运输50人
        print("车辆编号：%d, 当前车站人数：%d" % (num, people))
        time.sleep(1)


num = 1  # 车辆编号
action(num)
end = time.time()
print("Duration time: %0.3f" % (end - start))
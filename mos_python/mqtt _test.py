import paho.mqtt.client as mqtt
import mysql.connector
import json
# 连接数据库
db = mysql.connector.connect(
    host="localhost",
    user="root",
    password="Cjq760310!",
    database="bs"
)
cursor = db.cursor()#创建游标

def get_known_devices():
    cursor.execute("SELECT device_id FROM device")
    devices = [row[0] for row in cursor.fetchall()]
    #print(devices)
    return devices

# 当接收到MQTT消息时的回调函数
def on_message(client, userdata, message):#客户端实例本身，用户数据（是为了允许用户传递一些自定义数据，该数据可能在回调中有用，但与MQTT协议无关），消息本身，有topic，payload(内容)
    payload = message.payload.decode("utf-8")
    print(f"Received message '{payload}' on topic '{message.topic}'")#打印接收到的消息
    #device_id = message.topic.split("/")[1]#获取设备ID
    device_id=message.topic
    print(device_id in get_known_devices())
    if(device_id in get_known_devices()):#判断设备ID是否存在 
        # 将消息存入数据库
        insert_query = "INSERT INTO message (device_id, message) VALUES (%s, %s)"
        print(insert_query)
        cursor.execute(insert_query, (device_id, payload))
        #json_dict = json.loads(payload)
        #print(json_dict['active'])
        #update_query = "UPDATE device SET active = %s WHERE device_id = %s"
        #cursor.execute(update_query, (json_dict['active'], device_id))#为了测试改了
        db.commit()

# 设置MQTT客户端
client = mqtt.Client()
client.on_message = on_message

client.connect("localhost", 1883, 60)
client.subscribe("testapp")  #为了测试改了一下，原来是device/#

# 开始监听
client.loop_forever()
import requests

# img_path should be a file_name without path since docker have a different path
image_url = 'C:\\Users\\woori\\AI\\lee.png'
UUID ='uri_01'
# ret = requests.post("http://192.168.100.225:6000/detect", data = {'img_path': image_url, 'uuid':UUID})
ret = requests.post("http://127.0.0.1:5000/detect", data = {'img_path': image_url, 'uuid':UUID})
print(ret)
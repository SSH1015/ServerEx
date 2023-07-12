import os, shutil
from flask import Flask, request
import detect as Detect
import base64

prev_id = ''
app = Flask(__name__)

@app.route('/detect', methods=['POST'])
def detect_target():
    global prev_id

    file_name = request.form.get('img_path')
    img = request.form.get('data')
    
    # Check if both file_name and img are not None
    ret_img_string = img
    img = base64.b64decode(ret_img_string)

    # Save the image file to disk
    base_directory = "C:/Users/woori" # Replace with the desired directory
    file_path = os.path.join(base_directory, file_name)
    with open(file_path, 'wb') as file:
        file.write(img)

    uuid = request.form.get('uuid')
    print(file_name)

    # Perform the necessary processing on the image file
    # (e.g, call the Detect.detect() function)
    #shutil.rmtree('/AI/yolov5/runs/detect/')
    Detect.detect(file_path, True, True, uuid)

    prev_id = uuid
    image_url = 'C:/Users/woori/'+uuid
    image_path = os.path.join(image_url, file_name)


    filename = 'C:/Users/woori/AI/yolov5/runs/detect/' +uuid+ '/labels/' + (file_name.split('/')[-1])[0:-4] + '.txt'
    f = open(filename, 'r')
    lines = f.readlines()

    for line in lines:
        cata = line.split(' ')[0]
        break

    return cata


if __name__ == '__main__':
    app.run(host='0.0.0.0')



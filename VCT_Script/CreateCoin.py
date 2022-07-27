from pymongo import MongoClient
import random as rand
from datetime import datetime
import urllib
import os
import requests

username = urllib.parse.quote_plus('mongo');password=urllib.parse.quote_plus(os.getenv('MONGO_SERVER_PWD'))
client = MongoClient('mongodb://%s:%s@localhost:16025/' % (username, password))
vct_db = client['vctdata']
now = datetime.now()
vegetableList = ['백다다기오이', '감자', '고구마', '배추', '햇마늘 대서']

for value in vegetableList:
    vct_col = vct_db['vegetablePrice']
    query = {
        "vegetable_name": value
    }

    doc = vct_col.find(query)

    temp = []
    for data in doc:
        temp.append(data)
    
    price = float(temp[0]['vegetable_price'])
    coin = round((price + rand.uniform(-500, 500)), 2)
    coin_col = vct_db['vct_coin']
    
    data = {
      "coinName": value,
      "coinPrice": coin
    }
    
    
    if coin_col.estimated_document_count() < 5:
      data = coin_col.insert_one({
          "_id" : value,
          "coinName": value,
          "coinPrice": coin,
          "coinVolume": 1000
      })
    else:
      data = coin_col.update_one({
        "coinName": value
        }, {
        "$set": {"coinPrice": coin}
      })
    # Using API
    # response = requests.post("http://localhost:8081/coin/hist:", data=data)
    
    # Temp Data Saving...
    requestData = {
      "coinName": value,
      "coinPrice": coin,
      "crtDttm" : str(datetime.now().strftime("%Y-%m-%d %H:%M:%S"))
    }
    
    hist_col = vct_db['vct_coin_history']
    data = hist_col.insert_one(requestData)
    
    
    
    
    
    
    
    
    
    
    
    
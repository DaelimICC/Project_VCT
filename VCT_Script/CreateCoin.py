from pymongo import MongoClient
import random as rand
from datetime import datetime

client = MongoClient("mongodb://localhost:27017")
vct_db = client['VCT']
now = datetime.now()
vegetableList = ['백다다기오이', '감자', '고구마', '배추', '햇마늘 대서']

for value in vegetableList:
    vct_col = vct_db['VegetableAPI_vegetableprice']
    query = {
        "vegetable_name": value
    }

    doc = vct_col.find(query)

    temp = []
    for data in doc:
        temp.append(data)

    price = float(temp[0]['vegetable_price'])
    coin = round((price + rand.uniform(-500, 500)), 2)
    current_dt = now.strftime('%Y-%m-%d %H:%M:%S')
    vct_col = vct_db['VegetableAPI_vegetablecoin']

    # if vct_col.estimated_document_count() < 5:
    data = vct_col.insert_one({
        "coin_name": value,
        "coin_price": coin,
        "coin_date": current_dt
    })
    # else:
    #     data = vct_col.update_one({
    #         "coin_name": value
    #     }, {
    #         "$set": {"coin_price": coin}
    #     }
    #     )

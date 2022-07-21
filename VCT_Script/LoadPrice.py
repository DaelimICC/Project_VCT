from urllib.parse import urlencode, unquote

import pymongo
import requests
from pymongo import MongoClient
import xmltodict
from pprint import pprint
import os
import uuid

username = urllib.parse.quote_plus('mongo');password=urllib.parse.quote_plus(os.getenv('MONGO_SERVER_PWD'))
client = MongoClient('mongodb://%s:%s@localhost:16025/' % (username, password))
vct_db = client['vctdata']
vct_col = vct_db['vegetablePrice']

url = "http://www.garak.co.kr/publicdata/dataOpen.do"

vegetableList = ['오이', '감자', '고구마', '배추', '마늘']

for value in vegetableList:
    dataid = uuid.uuid4()

    queryString = "?" + urlencode(
        {
            "dataid": "data4",
            "pagesize": 1,
            "pageidx": 1,
            "portal.templet": False,
            "id": 3202,
            "passwd": os.getenv('API_SECRET_KEY'),
            "p_ymd": "20220528",
            "p_jymd": "20220527",
            "p_jjymd": "20210530",
            "d_cd": 2,
            "p_pos_gubun": 1,
            "pum_nm": value
        }
    )
    response = requests.get(url + queryString)


    result = xmltodict.parse(response.text)

    vegetable_name = result['lists']['list']['PUM_NM_A']
    vegetable_price = result['lists']['list']['AV_P_A']
    vegetable_unit = result['lists']['list']['U_NAME']

    if vct_col.estimated_document_count() < 5:
        data = vct_col.insert_one({
            "vegetable_name": vegetable_name,
            "vegetable_price": vegetable_price,
            "vegetable_unit": vegetable_unit
        })
    else:
        data = vct_col.update_one({
            "vegetable_name": vegetable_name
        }, {
            "$set": {"vegetable_price": vegetable_price}
        }
        )
